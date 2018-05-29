package edu.hzuapps.androidlabs.soft1614080902422;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.DownloadManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Soft1614080902422Activity extends AppCompatActivity implements View.OnClickListener {
    String url = "http://imgsrc.baidu.com/forum/pic/item/ef1de1f790529822ab0ac7f0ddca7bcb0a46d48c.jpg";

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422);
        Button bt1 = (Button) findViewById(R.id.b_start);
        Button bt2 = (Button) findViewById(R.id.b_stop);
        Button bt3 = (Button) findViewById(R.id.b_download);
        imageView = (ImageView) findViewById(R.id.image);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);


    }
    public Bitmap getPicture(String wu){
        Bitmap yu=null;
        try{
            URL url=new URL(wu);
            URLConnection connection=url.openConnection();
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            yu= BitmapFactory.decodeStream(inputStream);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  yu;
    }

    private void downloadFile2(){
        //下载路径，如果路径无效了，可换成你的下载路径
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527234146991&di=e8fe0756ed1b0533cb8d0083202cebf1&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fc8177f3e6709c93dab14e3b5943df8dcd000548a.jpg";
        //创建下载任务,downloadUrl就是下载链接
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //指定下载路径和下载文件名
        request.setDestinationInExternalPublicDir("", url.substring(url.lastIndexOf("/") + 1));
        //获取下载管理器
        DownloadManager downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        //将下载任务加入下载队列，否则不会进行下载
        downloadManager.enqueue(request);
    }


    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.b_start:
                 Intent i1 = new Intent(this,Soft1614080902422Activity_03.class);
                 startActivity(i1);
                 break;
             case R.id.b_stop:
                 Intent i2 = new Intent(this,Soft1614080902422Activity_02.class);
                 startActivity(i2);
                 break;
              case R.id.b_download:
                  new Thread(new Runnable() {
                      @Override
                      public void run() {
                          final Bitmap bitmap=getPicture(url);
                          //final Bitmap bitmap=getPicture("http://pic36.photophoto.cn/20150704/0017029369483757_b.jpg");
                          try {
                              Thread.sleep(2000);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }

                          imageView.post(new Runnable() {
                              @Override
                              public void run() {
                                  imageView.setImageBitmap(bitmap);
                              }
                          });
                      }
                  }).start();
                  //downloadFile2();
                  break;
         }
    }
}


