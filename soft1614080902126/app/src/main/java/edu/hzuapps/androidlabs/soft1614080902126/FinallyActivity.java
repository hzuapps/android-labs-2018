package edu.hzuapps.androidlabs.soft1614080902126;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class FinallyActivity extends AppCompatActivity {
        private Handler handler=new Handler();
        ImageView imageView;
        private String url = "https://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=https%3A%2F%2Ftimgsa.baidu.com%2Ftimg%3Fimage%26quality%3D80%26size%3Db9999_10000%26sec%3D1527672511486%26di%3Da8cc5e41d36523997cfb9b3c615b79f2%26imgtype%3D0%26src%3Dhttp%253A%252F%252Fpic28.nipic.com%252F20130417%252F12389388_002915416000_2.png&thumburl=https%3A%2F%2Fss0.bdstatic.com%2F70cFuHSh_Q1YnxGkpoWK1HF6hhy%2Fit%2Fu%3D529587146%2C4023250194%26fm%3D27%26gp%3D0.jpg";
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
        setContentView(R.layout.activity_finally);
                imageView = (ImageView) findViewById(R.id.my_view);
                Button btn=(Button) findViewById(R.id.btn);
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
//
//    public Bitmap returnBitMap(String url) {
//                URL myFileUrl = null;
//                Bitmap bitmap = null;
//                try {
//                   myFileUrl = new URL(url);
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    HttpURLConnection conn = (HttpURLConnection) myFileUrl.openConnection();
//                    conn.setDoInput(true);
//                    conn.connect();
//                    InputStream is = conn.getInputStream();
//                    bitmap = BitmapFactory.decodeStream(is);
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return bitmap;
//            }


        }
