package edu.hzuapps.androidlabs.wangzhe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectWebActivity extends AppCompatActivity {
        ImageView imageView;
        private String url = "https://github.com/lgc1999/android-labs-2018/blob/master/soft1614080902134/%E5%AE%9E%E9%AA%8C5.png?raw=true";
               //在消息队列中实现对控件的更改
               private Handler handle = new Handler() {
               public void handleMessage(Message msg) {
                      switch (msg.what) {
                               case 0:
                                       Bitmap bmp=(Bitmap)msg.obj;
                                       imageView.setImageBitmap(bmp);
                                       break;
                           }
                   };
           };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_web);
        imageView = (ImageView) findViewById(R.id.my_view);
        Button btn=(Button) findViewById(R.id.btn5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建线程加载图片信息，发送到消息队列中
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Bitmap bmp = getURLimage(url);
                        Message msg = new Message();
                        msg.what = 0;
                        msg.obj = bmp;
                        handle.sendMessage(msg);
                    }
                }).start();
            }});
    }


        //加载图片
     public Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
                URL myurl = new URL(url);
                // 获得连接
                HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
                conn.setConnectTimeout(6000);//设置超时
                conn.setDoInput(true);
                conn.setUseCaches(false);//不缓存
                conn.connect();
                InputStream is = conn.getInputStream();//获得图片的数据流
                bmp = BitmapFactory.decodeStream(is);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return bmp;
    }
}



