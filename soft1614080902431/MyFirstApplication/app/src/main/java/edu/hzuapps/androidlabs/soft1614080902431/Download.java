package edu.hzuapps.androidlabs.soft1614080902431;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
public class Download extends Activity {
    private ImageView mImageView;
    private String imgPath="https://pic.baike.soso.com/ugc/baikepic2/0/20170825230330-2051740427_jpg_570_711_35774.jpg/800";
    private File cache;//缓存路径
    Handler handler=new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            //显示
            Bitmap b=(Bitmap)msg.obj;
            mImageView.setImageBitmap(b);
            //保存至本地
            File imgFile=new File(cache,"woca.jpg");
            try {
                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(imgFile));
                b.compress(Bitmap.CompressFormat.JPEG,80,bos);
                bos.flush();
                bos.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=(ImageView)findViewById(R.id.imageView);
        cache=new File(Environment.getExternalStorageDirectory(),"Test");
        if(!cache.exists()){
            cache.mkdirs();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn=null;
                InputStream is=null;
                try {
                    URL url=new URL(imgPath);
                    //开启连接
                    conn=(HttpURLConnection) url.openConnection();
                    //设置连接超时
                    conn.setConnectTimeout(5000);
                    //设置请求方式
                    conn.setRequestMethod("GET");
                    //conn.connect();
                    if(conn.getResponseCode()==200){
                        is=conn.getInputStream();
                        Bitmap b=BitmapFactory.decodeStream(is);
                        Message msg=new Message();
                        msg.obj=b;
                        handler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally{
                    try {
                        is.close();
                        conn.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

