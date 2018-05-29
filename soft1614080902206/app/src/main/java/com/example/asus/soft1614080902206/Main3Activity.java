package com.example.asus.soft1614080902206;

import android.support.v7.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
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

public class Main3Activity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;

    private Bitmap bitmap;
    public Bitmap getPicture(String path){

        Bitmap bm=null;

        try{

            URL url=new URL(path);

            URLConnection connection=url.openConnection();

            connection.connect();

            InputStream inputStream=connection.getInputStream();

            bm= BitmapFactory.decodeStream(inputStream);

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return  bm;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //初始化组件
        imageView= (ImageView) findViewById(R.id.imageView1);

        new Thread(new Runnable() {

            @Override

            public void run() {

                final Bitmap bitmap=getPicture("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527580536371&di=afab87c6aa362a09b7d540565996ef17&imgtype=0&src=http%3A%2F%2Ffile.xdf.cn%2Fuploads%2F130912%2F134_130912141654W1EUxbXVtfBCH5Ly.jpg");

                try {

                    Thread.sleep(2000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                imageView.post(new Runnable() {

                    @Override

                    public void run() {

                        imageView.setImageBitmap(bitmap);

                    }

                });

            }

        }).start();
    };
    //给下载按钮添加一个监听

    //为了下载图片资源，开辟一个新的子线程
}
