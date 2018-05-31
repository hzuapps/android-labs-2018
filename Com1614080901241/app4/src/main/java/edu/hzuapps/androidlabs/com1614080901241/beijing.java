package edu.hzuapps.androidlabs.com1614080901241;

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

public class beijing extends Thread{
    private String url;

    private ImageView imageView;

    private Handler handler;

    public beijing(String url, ImageView imageView,Handler handler){

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

            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){

                File appDir=Environment.getExternalStorageDirectory();

                downloadFile=new File(appDir,fileName);

                out=new FileOutputStream(downloadFile);

            }

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