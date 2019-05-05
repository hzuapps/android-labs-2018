package com.example.john.soft1614080902141;

/**
 * Created by john on 2018/5/22.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import com.example.john.soft1614080902141.R;
import android.webkit.WebViewClient;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

public class ActivitySecond extends AppCompatActivity{
    private Handler handler=new Handler();
    ImageView imageView;
    private  String ur1="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527609089949&di=5ceba072d816b5cbce041344e225e048&imgtype=0&src=http%3A%2F%2Ffile.mumayi.com%2Fforum%2F201602%2F28%2F164722sy84snndg8a0pnsm.jpg";
    Bitmap bmImg;
    private Handler handle = new Handler() {
               public void handleMessage(Message msg) {
                       switch (msg.what) {
                                case 0:
                                       System.out.println("111");
                                        Bitmap bmp=(Bitmap)msg.obj;
                                       imageView.setImageBitmap(bmp);
                                        break;
                            }
                   };
           };

    private EditText edit;
      @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);

          imageView = (ImageView) findViewById(R.id.image) ;
          Button btn = (Button) findViewById(R.id.btn);
          btn.setOnClickListener(new View.OnClickListener(){

              @Override
              public void onClick(View v) {
                  new Thread(new Runnable(){

                      @Override
                      public void run() {
                          Bitmap bmp = getURlimage(ur1);
                          Message msg = new Message();
                          msg.what = 0 ;
                          msg.obj = bmp;
                          System.out.println("000");
                          handle.sendMessage(msg);
                      }
                  }).start();
              }
          });
            edit = (EditText) findViewById(R.id.edit);
            String inputText = load();
          if(!TextUtils.isEmpty(inputText)){
              edit.setText(inputText);
              edit.setSelection(inputText.length());
              Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show();
          }
        }
    public Bitmap getURlimage(String ur1){
        Bitmap bmp = null;
        try{
            URL myur1 = new URL(ur1);
            HttpURLConnection conn =(HttpURLConnection) myur1.openConnection();
            conn.setConnectTimeout(6000);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.connect();
            InputStream is =conn.getInputStream();
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bmp;
    }//以上皆为下载图片的代码，以下为内部存储的代码；
    @Override
        protected  void onDestroy(){
            super.onDestroy();
            String inputText=edit.getText().toString();
            save(inputText);
        }
    public void save(String inputText){
        FileOutputStream out=null;
        BufferedWriter writer = null;
        try {
             out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(writer !=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
     public String load(){
         FileInputStream in = null;
         BufferedReader reader = null;
         StringBuilder content = new StringBuilder();
         try {
             in = openFileInput("data");
             reader = new BufferedReader((new InputStreamReader(in)));
             String line = "";
             while((line = reader.readLine())!=null){
                 content.append(line);
             }
         }catch(IOException e){
             e.printStackTrace();
         }finally{
             if(reader != null){
                 try{
                     reader.close();
                 }catch(IOException e){
                     e.printStackTrace();
                 }
             }
         }
         return content.toString();
     }
}
