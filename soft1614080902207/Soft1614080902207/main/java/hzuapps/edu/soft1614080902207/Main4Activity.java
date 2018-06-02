package edu.hzuapps.androidlabs.soft1614080902207;

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

public class Main4Activity extends AppCompatActivity {


    private ImageView image;
         //获取图片
             public Bitmap getPicture(String str){
                Bitmap s=null;
                try{
                        URL url=new URL(str);
                        URLConnection connection=url.openConnection();
                        connection.connect();
                        InputStream inputStream=connection.getInputStream();
                        s = BitmapFactory.decodeStream(inputStream);
                    } catch (java.net.MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return  s;
            }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        image = (ImageView) findViewById(R.id.picture);

                SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE);
                final String Address=sharedPreferences.getString("Address","");
                new Thread(new Runnable() {

                 public void run() {
                     final Bitmap bitmap=getPicture(Address);
                     try {
                         Thread.sleep(2000);
                         } catch (InterruptedException e) {
                         e.printStackTrace();
                         }

                         image.post(new Runnable() {

                     public void run() {
                         image.setImageBitmap(bitmap);
                         }
                         });
                 }
         }).start();
    }
}
