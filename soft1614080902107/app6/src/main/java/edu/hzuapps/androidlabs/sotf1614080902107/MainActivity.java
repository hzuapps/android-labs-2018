package edu.hzuapps.androidlabs.sotf1614080902107;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.R.attr.handle;
import static edu.hzuapps.androidlabs.sotf1614080902107.R.id.b1;

public class MainActivity extends AppCompatActivity {

    private Handler handler=new Handler();
    ImageView imageView;
    private String url = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4287881862,1300592114&fm=27&gp=0.jpg";
    Bitmap bmImg;

    //在消息队列中实现对控件的更改
    private Handler handle = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    System.out.println("111");
                    Bitmap bmp=(Bitmap)msg.obj;
                    imageView.setImageBitmap(bmp);
                    break;
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.myimge);
        Button button1=(Button)findViewById(R.id.b1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.mypicture);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Bitmap bmp = getURLimage(url);
                        Message msg = new Message();
                        msg.what = 0;
                        msg.obj = bmp;
                        System.out.println("000");
                        handle.sendMessage(msg);
                    }
                }).start();
            }
        });
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

