package edu.hzuapps.androidlabs.Com1614080901239;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class pictureThread extends Thread {
    private String url;
    private EditText editText;
    private Handler handler;
    public pictureThread(String url, EditText editText, Handler handler){
        this.url=url;
        this.editText=editText;
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
            final Drawable drawable =new BitmapDrawable(bitmap);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    editText.setBackground(drawable);
                }
            });
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
