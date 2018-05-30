package edu.hzuapps.androidlabs.Com1614080901209;

import android.content.SharedPreferences;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.com1614080901209.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class SecondActivity extends AppCompatActivity {
    ImageView imageView;

    Bitmap bitmap;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //开了一个线程来下载一个图片当做背景
        t.start();

        imageView = (ImageView)findViewById(R.id.imageView) ;
        handler =  new Handler(){
            public void handleMessage(Message msg) {
                if(msg.what==2){
                    imageView.setImageBitmap(bitmap);
                }
            }
        };

        final int randomNumber = getSharedPreferences("data",MODE_PRIVATE).getInt("ramdomNumber",0);




        final EditText ed = (EditText)findViewById(R.id.edit);
        Button bu = (Button)findViewById(R.id.button) ;
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed.getText().toString() == ""+randomNumber){
                    Toast.makeText(SecondActivity.this,"运气真好猜对了",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecondActivity.this,"运气用光了猜错咯",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Log.d("SecondActivity", "onCreate: "+randomNumber);
    }
    Thread t=new Thread(){
        public void run() {

            try {
                //对资源链接
                URL url=new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527681116194&di=2bfafd2661c26c28460b76ccfb631fd9&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F16%2F14%2F80%2F91J58PICzdA_1024.jpg");
                //打开输入流
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap= BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(2);
                inputStream.close();

                //再一次打开
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/jj.jpg");
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
