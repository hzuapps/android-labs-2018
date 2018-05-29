package edu.hzuapps.androidlabs.soft1614080902130;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.widget.ImageView;
import android.content.Context;
import android.os.Environment;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 林继锐 on 2018/5/28.
 */

public class HttpThread extends Thread {
    private String url;
    private ImageView imageView;
    private Handler handler;
    public HttpThread(String url, ImageView imageView, Handler handler){
        this.url=url;
        this.imageView=imageView;
        this.handler=handler;
    }
    @Override
    public void run(){
        try {
            URL httpUrl=new URL(url);
            HttpURLConnection conn=(HttpURLConnection)httpUrl.openConnection();
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            InputStream in=conn.getInputStream();
            FileOutputStream out=null;
            File downloadFile=null;
            String fileName=String.valueOf(System.currentTimeMillis());
            String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "demo";
            File appDir = new File(storePath);

            if (!appDir.exists()) {
                appDir.mkdir(); }
            downloadFile=new File(appDir,fileName);
            out=new FileOutputStream(downloadFile);

            byte [] b=new byte[4*1024];
            int len;
            if(out!=null) {
                while ((len = in.read(b)) != -1) {
                    out.write(b,0,len);
                }
            }
            final Bitmap bitmap= BitmapFactory.decodeFile(downloadFile.getAbsolutePath());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                }
            });
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}