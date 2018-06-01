package com.example.administrator.instergram;
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

public class Soft614080902433shiyan4 extends Activity {
    int i=1;
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;
    //手柄更新的作用
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        };
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft614080902433shiyan4);
        final Button up=(Button)findViewById(R.id.up);
        final Button next=(Button)findViewById(R.id.next);
        final Button commits=(Button) findViewById(R.id.commits);
        final ImageView ima =(ImageView) findViewById(R.id.ima);
        //初始化组件
        editText=(EditText) findViewById(R.id.ed);
        button=(Button) findViewById(R.id.dl);
        imageView=(ImageView) findViewById(R.id.ima);
        //给下载按钮添加一个监听
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(up)){
                    switch(i){
                        case 1:ima.setImageResource(R.drawable.moments4);i=4;break;
                        case 2:ima.setImageResource(R.drawable.moments1);i=1;break;
                        case 3:ima.setImageResource(R.drawable.moments2);i=2;break;
                        case 4:ima.setImageResource(R.drawable.moments3);i=3;break;
                    }
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(next)){
                    switch(i){
                        case 1:ima.setImageResource(R.drawable.moments4);i=2;break;
                        case 2:ima.setImageResource(R.drawable.moments1);i=3;break;
                        case 3:ima.setImageResource(R.drawable.moments2);i=4;break;
                        case 4:ima.setImageResource(R.drawable.moments3);i=1;break;
                    }
                }
            }
        });
        commits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(commits)){
                    Intent intent = new Intent (Soft614080902433shiyan4.this,Soft1614080902433shiyan4commit.class);
                    startActivity(intent);
                }
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();
            }
        });
    }

    //为了下载图片资源，开辟一个新的子线程
    Thread t=new Thread(){
        public void run() {
            //下载图片的路径
            String iPath=editText.getText().toString();
            try {
                //对资源链接
                URL url=new URL(iPath);
                //打开输入流
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap=BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();
                //再一次打开
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