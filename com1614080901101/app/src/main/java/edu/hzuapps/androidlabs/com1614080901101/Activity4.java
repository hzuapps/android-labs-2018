package edu.hzuapps.androidlabs.com1614080901101;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Activity4 extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap space;
    private Bitmap sky;

    public Bitmap getImage(String image_url){
        Bitmap bitmap = null;
        try{
            URL url=new URL(image_url);
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
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
        setContentView(R.layout.activity4);

        imageView = (ImageView) findViewById(R.id.background);
        Resources res = Activity4.this.getResources();
        space = BitmapFactory.decodeResource(res, R.drawable.space);

        Button use_space = (Button) findViewById(R.id.use_space);
        use_space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageBitmap(space);
                Toast.makeText(Activity4.this,"背景已设置为宇宙空间",Toast.LENGTH_SHORT).show();
            }
        });

        Button use_sky = (Button) findViewById(R.id.use_sky);
        use_sky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageBitmap(sky);
                Toast.makeText(Activity4.this,"背景已设置为天空",Toast.LENGTH_SHORT).show();
            }
        });

        Button download_sky = (Button) findViewById(R.id.download_sky);
        download_sky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sky = getImage("https://raw.githubusercontent.com/Tmouser/android-labs-2018/master/com1614080901101/sky.png");
                        try {
                            Thread.sleep(2500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                Toast.makeText(Activity4.this,"下载完成.",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

