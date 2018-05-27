package com.example.myapplication;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import  java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import android.view.View;
import android.widget.Toast;



public class Main3Activity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;
    Handler handler=new Handler(){
      public void handleMessage(Message msg) {
         if(msg.what==404){
             imageView.setImageBitmap(bitmap);
         }
            }
        };

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        final String n1 = intent.getStringExtra("extra_n1");
        final String n2 = intent.getStringExtra("extra_n2");
        final String n3 = intent.getStringExtra("extra_n3");
        final String n4 = intent.getStringExtra("extra_n4");
        final String n5 = intent.getStringExtra("extra_n5");
        final String n6 = intent.getStringExtra("extra_n6");

        editText = (EditText) findViewById(R.id.path);
        button = (Button) findViewById(R.id.download);
        imageView = (ImageView) findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();
            }
        });

        ((Button) findViewById(R.id.btn_save)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = n1 + n2 + n3 + n4 + n5 + n6;
                        save(text);
                    }
                });

        ((Button) findViewById(R.id.btn_read)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        readsy5();
                    }
                });

    }
        public void save(String text) {

        FileOutputStream out = null;

        BufferedWriter writer = null;

        try {
            out = openFileOutput("sy5.txt", ContextWrapper.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(Main3Activity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
        }
    }



    public void readsy5() {
        String content = "";
        try {
            FileInputStream fis = openFileInput("sy5.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            fis.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

        Toast.makeText(Main3Activity.this, "保存的数据是" + content +editText.getText().toString(), Toast.LENGTH_SHORT).show();

    }
    Thread t=new Thread(){
        public void run() {
            String iPath=editText.getText().toString();
            try {
                URL url=new URL(iPath);
                //通过openstream从网络下载，返回Inputstream类型
                InputStream inputStream=url.openStream();
                //将inputstream转化为bitmap
                bitmap=BitmapFactory.decodeStream(inputStream);
                //使用handle,设置ImageView
                handler.sendEmptyMessage(404);
                inputStream.close();
                //下载到本地
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
        }
    };

}