package edu.hzuapps.androidlabs.soft1614080902132;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondActivity extends AppCompatActivity {
    public ArrayList<String> data = new ArrayList<String>();
    private Handler handler=new Handler();
    ImageView imageView;
    private String url = "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2045184007,342230497&fm=11&gp=0.jpg";
    Bitmap bmImg;

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
        setContentView(R.layout.activity_second);
        imageView = (ImageView) findViewById(R.id.my_view);

        load();
        ListView listView=(ListView) findViewById(R.id.l1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

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

    public void load() {
        Resources resources = this.getResources();
        InputStream StdInfo = null;
        try {
            // 用InputStream方式读取保存在 /res/raw 下的原始文件
            StdInfo = resources.openRawResource(R.raw.data1);
            if (StdInfo.available() == 0)
                return;
            if (StdInfo != null) {
                //用utf-8读取文件
                Scanner input = new Scanner(StdInfo, "GBK");
                while (input.hasNext()) {
                    String Name = input.next();
                    data.add(Name);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
