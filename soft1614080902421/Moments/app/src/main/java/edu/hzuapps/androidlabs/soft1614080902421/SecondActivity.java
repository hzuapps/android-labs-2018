package edu.hzuapps.androidlabs.soft1614080902421;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;



public class SecondActivity extends AppCompatActivity {
    private TextView textview;
    private ImageView imageview;
    private Bitmap bitmap;
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==123){
                imageview.setImageBitmap(bitmap);
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        ImageButton button = (ImageButton) findViewById(R.id.button2);//返回开始界面
        ImageButton button1 =(ImageButton) findViewById(R.id.button3);
        textview=(TextView) findViewById(R.id.address);
        Button button2=(Button) findViewById(R.id.xiazai);
        imageview=(ImageView) findViewById(R.id.timg11);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,Moments.class);
                startActivity(intent);
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }

        });

            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    new Thread(download).start();
                }
            });
        }
        Thread download=new Thread(){
        public void run() {
            String Path=textview.getText().toString();//下载图片的路径
            try {
                URL url=new URL(Path);//对资源链接
                InputStream inputStream=url.openStream();
                bitmap= BitmapFactory.decodeStream(inputStream);//转换成位图图片
                handler.sendEmptyMessage(123);
                inputStream.close();
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"./DCIM/timg11.jpg");
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
        }
    };
}