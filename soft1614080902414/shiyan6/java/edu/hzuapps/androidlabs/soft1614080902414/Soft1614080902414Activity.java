package edu.hzuapps.androidlabs.soft1614080902414;

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



public class Soft1614080902414Activity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 404) {
                imageView.setImageBitmap(bitmap);
            }
        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soft1614080902414);


        editText = ( EditText ) findViewById(R.id.path);
        button = ( Button ) findViewById(R.id.download);
        imageView = ( ImageView ) findViewById(R.id.imageView);




        final Thread t = new Thread() {
            public void run() {
                String iPath = editText.getText().toString();
                try {
                    URL url = new URL(iPath);
                    //通过openstream从网络下载，返回Inputstream类型
                    InputStream inputStream = url.openStream();
                    //将inputstream转化为bitmap
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    //使用handle,设置ImageView
                    handler.sendEmptyMessage(404);
                    inputStream.close();
                    //下载到本地
                    inputStream = url.openStream();
                    File file = new File(Environment.getExternalStorageDirectory() + "/DCIM/");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    int hasRead = 0;
                    while ((hasRead = inputStream.read()) != -1) {
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
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();
            }
        });
    }
}