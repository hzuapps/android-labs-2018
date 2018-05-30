package soft1614080902339.androidlabs.hzuapps.edu.notepad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main2Activity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;

    private Bitmap bitmap;

    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                //主线程
                imageView.setImageBitmap(bitmap);
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button=(Button) findViewById(R.id.upload);
        imageView=(ImageView) findViewById(R.id.imageView);

        //给下载按钮添加一个监听
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();
            }
        });
        final Main2Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.roundBtn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, MainActivity.class);
                thisActivity.startActivity(intent);
            }

        });

        Button btnOpen2 = (Button) findViewById(R.id.roundBtn2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, ListActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }

    Thread t=new Thread(){
        public void run() {
            String iPath="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528273941&di=9cbc5c8c26205927f273ade9a1abcede&imgtype=jpg&er=1&src=http%3A%2F%2Fec4.images-amazon.com%2Fimages%2FI%2F51lEENHQrnL._SL500_AA200.jpg";
            try {
                URL url=new URL(iPath);
                InputStream inputStream=url.openStream();
                bitmap= BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();

                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/haha.jpg");
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
