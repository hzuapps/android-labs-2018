package com.example.administrator.soft1614080902220;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

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

public class Jinru extends Activity {
    private EditText EditText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==8){
                imageView.setImageBitmap(bitmap);
            }
        };
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinru);
        final Activity thisActivity = this;
        Button btnclose = (Button) findViewById(R.id.button_close);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button btnclose1 = (Button) findViewById(R.id.button_close1);
        btnclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,Laile.class);
                thisActivity.startActivity(intent);
            }
        });
        EditText=(EditText) findViewById(R.id.imagepath);
        button=(Button) findViewById(R.id.upload);
        imageView=(ImageView) findViewById(R.id.imageView);
        //给下载按钮添加一个监听
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();
            }
        });
    }
    //为了下载图片资源，添加一个新的子线程
    Thread t=new Thread(){
        public void run() {
            //下载图片的路径
            String iPath=EditText.getText().toString();
            try {
                //对资源链接
                URL url=new URL(iPath);
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap=BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(8);
                inputStream.close();
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/DCIM/");
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
