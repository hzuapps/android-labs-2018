package edu.hzuapps.androidlabs.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main3Activity extends AppCompatActivity {
    private Button push,bu;
    private ImageView imageView;
    private Bitmap bitmap;
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        push=(Button)this.findViewById(R.id.kong);
        // String content =null ;
        try {
            FileInputStream fis = openFileInput("setting.set");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            byte[] content = baos.toByteArray();
            push.setText(new String(content,"UTF-8"));
            fis.close();
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bu = (Button) this.findViewById(R.id.kong);
        imageView=(ImageView) findViewById(R.id.imageView);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(t).start();  }

        });}
        Thread t=new Thread(){
            public void run() {
                //下载图片的路径
                String iPath="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1084767195,2638084347&fm=11&gp=0.jpg";
                        try{
                    //对资源链接
                    URL url=new URL(iPath);
                    //打开输入流
                    InputStream inputStream=url.openStream();
                    //对网上资源进行下载转换位图图片
                    bitmap= BitmapFactory.decodeStream(inputStream);
                    handler.sendEmptyMessage(111);
                    inputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
        };
    }

