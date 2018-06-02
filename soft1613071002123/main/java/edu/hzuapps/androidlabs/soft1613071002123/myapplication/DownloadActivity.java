package edu.hzuapps.androidlabs.soft1613071002123.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hww on 2018/5/31.
 */

public class DownloadActivity extends AppCompatActivity {
    private Bitmap bitmap;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==111){
                mShowImage.setImageBitmap(bitmap);
            }
        }
    };
    private ImageView mShowImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_picture);
        mShowImage = findViewById(R.id.show_image);
        initButton();
    }

    private void initButton() {
        Button startDownLoad = findViewById(R.id.start_btn);
        startDownLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.start();
            }
        });
    }

    //为了下载图片资源，开辟一个新的子线程
    Thread t=new Thread(){
        @Override
        public void run() {
            //下载图片的路径
            String iPath="https://t" +
                    "imgsa.baidu.com/timg?" +
                    "image&quality=80&size=b9999_" +
                    "10000&sec=1527778386587&di=8be823" +
                    "0eaebdaeaa949d7b73357c2fa2&imgt" +
                    "ype=0&src=http%3A%2F%2F5b0988e595225.cdn.so" +
                    "hucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimage" +
                    "s%2F20180415%2Fb86096a5dac244ddbc8d9060eb68e1b0.jpeg";
            try {
                //对资源链接
                URL url=new URL(iPath);
                //打开输入流
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap= BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();

                //再一次打开
                inputStream=url.openStream();
                java.io.File file=new java.io.File(Environment.getExternalStorageDirectory()+"/haha.jpg");
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                int hasRead=0;
                while((hasRead=inputStream.read())!=-1){
                    fileOutputStream.write(hasRead);
                }
                fileOutputStream.close();
                inputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    };

}
