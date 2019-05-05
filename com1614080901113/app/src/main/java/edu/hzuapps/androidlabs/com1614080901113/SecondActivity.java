package edu.hzuapps.androidlabs.com1614080901113;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SecondActivity extends Activity {
    private EditText editText;
    private ImageView picture;
    private Bitmap bitmap;

    private TextView tv_grade;
    private Button camera;
    private Button test;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    int grade;
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                picture.setImageBitmap(bitmap);
            }
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        sp=getSharedPreferences("Grade",MODE_PRIVATE);
        editor=sp.edit();
        camera=(Button)findViewById(R.id.camera);
        test=(Button)findViewById(R.id.test);
        tv_grade=(TextView)findViewById(R.id.tv_grade);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grade=(int)(Math.random()*99+1);
                editor.putInt("Grade",grade);
                editor.commit();

                Integer Grade=sp.getInt("Grade",0);
                tv_grade.setText(Grade+" !");
            }
        });
        editText=(EditText) findViewById(R.id.et_path);
        Button bt_exchange = (Button) findViewById(R.id.bt_exchange);
        picture=(ImageView) findViewById(R.id.picture);
        bt_exchange.setOnClickListener(new OnClickListener() {
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
