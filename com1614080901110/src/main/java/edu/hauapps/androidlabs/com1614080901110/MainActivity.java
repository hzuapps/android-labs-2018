package com.henyiwu.downloadtest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
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
        setContentView(R.layout.activity_main);
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
            String iPath="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1528372375&di=f310c3f1dcff79e2aca6664cc072e867&imgtype=jpg&er=1&src=http%3A%2F%2Fpic35.photophoto.cn%2F20150605%2F0030014610015907_b.jpg";
            try {
                //对资源链接
                URL url=new URL(iPath);
                //打开输入流
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                Log.d(TAG, "run2222222222: ");
                bitmap= BitmapFactory.decodeStream(inputStream);
                Log.d(TAG, "run2222222222: ");
                handler.sendEmptyMessage(111);

                Log.d(TAG, "run2222222222: ");
                inputStream.close();

                //再一次打开
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/haha.jpg");
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
