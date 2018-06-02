package edu.hzu.take_out;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class InternetActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;

    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

        editText=(EditText) findViewById(R.id.et_url);
        button=(Button) findViewById(R.id.btn_download);
        imageView=(ImageView) findViewById(R.id.iv_resources);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();
            }
        });
    }

    Thread t=new Thread(){
        public void run() {

            String iPath=editText.getText().toString();
            try {

                URL url=new URL(iPath);
                InputStream inputStream=url.openStream();
                bitmap=BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/DCIM/");
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                int hasRead=0;
                while((hasRead=inputStream.read())!=-1){
                    fileOutputStream.write(hasRead);
                }
                fileOutputStream.close();
                inputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    };
}
