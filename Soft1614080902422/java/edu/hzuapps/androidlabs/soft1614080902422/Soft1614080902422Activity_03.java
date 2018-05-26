package edu.hzuapps.androidlabs.soft1614080902422;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Soft1614080902422Activity_03 extends AppCompatActivity {
    protected static final int CHANGE_UI = 1;
    protected static final int ERROR = 2;
    private EditText et_path;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422_03);
        et_path = (EditText) findViewById(R.id.et_path);
        iv = (ImageView) findViewById(R.id.iv);
        // 主线程创建消息处理器

    }

    ;
    // 主线程创建消息处理器
    private Handler handler = new Handler() {
        @SuppressLint("WrongConstant")
        public void handleMessage(android.os.Message msg) {
            if (msg.what == CHANGE_UI) {
                Bitmap bitmap = (Bitmap) msg.obj;
                iv.setImageBitmap(bitmap);
            } else if (msg.what == ERROR) {
                Toast.makeText(Soft1614080902422Activity_03.this, "显示图片错误", 0).show();
            }
        }

        ;
    };

    @SuppressLint("WrongConstant")
    public void click(View view) {
        final String path = et_path.getText().toString().trim();
        if (TextUtils.isEmpty(path)) {
            Toast.makeText(this, "图片路径不能为空", 0).show();
        } else {
            //子线程请求网络,Android4.0以后访问网络不能放在主线程中
            new Thread() {
                public void run() {
                    // 连接服务器 get 请求 获取图片.
                    try {
                        URL url=new URL(path);
                        HttpURLConnection conn = (HttpURLConnection) url
                                .openConnection();
                        conn.setRequestMethod("GET");
                        //设置超时时间
                        conn.setConnectTimeout(5000);
                        int code = conn.getResponseCode();

                        // 得到服务器返回的响应码

                        //请求网络成功后返回码是200
                        if (code == 200) {
                            //获取输入流
                            InputStream is = conn.getInputStream();
                            //将流转换成Bitmap对象
                            Bitmap bitmap = BitmapFactory.decodeStream(is);
                            //iv.setImageBitmap(bitmap);
                            //TODO: 告诉主线程一个消息:帮我更改界面。内容:bitmap
                            Message msg = new Message();
                            msg.what = CHANGE_UI;
                            msg.obj = bitmap;
                            handler.sendMessage(msg);
                        } else {
                            //返回码不是200  请求服务器失败
                            Message msg = new Message();
                            msg.what = ERROR;
                            handler.sendMessage(msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Message msg = new Message();
                        msg.what = ERROR;
                        handler.sendMessage(msg);
                    }
                }

                ;
            }.start();
        }
    }
}