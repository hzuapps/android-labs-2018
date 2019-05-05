package com.example.soft1614080902208;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PictureActivity extends AppCompatActivity {

    private ImageView imageView;
        //获取图片
            public Bitmap getPicture(String st){
                Bitmap bitmap=null;
                try{
                        URL url=new URL(st);
                        URLConnection connection=url.openConnection();
                        connection.connect();
                        InputStream inputStream=connection.getInputStream();
                        bitmap= BitmapFactory.decodeStream(inputStream);
                    } catch (java.net.MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return  bitmap;
            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        imageView = (ImageView) findViewById(R.id.add_image);
        TextView txtUserName = (TextView) findViewById(R.id.txt_User);
        SharedPreferences sharedPreferences = getSharedPreferences("jnc", Context.MODE_PRIVATE);
       final String userName = sharedPreferences.getString("username", "");
        txtUserName.setText(userName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = getPicture(userName);
                try {
                    Thread.sleep(1997);
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

    }}