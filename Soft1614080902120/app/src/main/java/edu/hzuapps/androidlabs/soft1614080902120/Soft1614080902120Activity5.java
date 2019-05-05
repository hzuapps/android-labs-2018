package edu.hzuapps.androidlabs.soft1614080902120;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.os.Handler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Soft1614080902120Activity5 extends AppCompatActivity {

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
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021205);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //初始化组件
        editText=(EditText) findViewById(R.id.imagepath);
        button=(Button) findViewById(R.id.upload);
        imageView=(ImageView) findViewById(R.id.imageView);

        //给下载按钮添加一个监听
        button.setOnClickListener(new View.OnClickListener() {
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
                bitmap= BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();

                //再一次打开
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/1120513656acc03b7dl.jpg");
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
