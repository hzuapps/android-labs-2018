package com.example.asus.soft1614080902307;

import android.content.Context;
import android.content.ContextWrapper;
import android.nfc.Tag;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class soft16140809023071Activity extends AppCompatActivity {
    private EditText editText;
    private int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809023071);
        Button button = (Button) findViewById(R.id.button_1);
        Random rand = new Random();
         a = rand.nextInt(10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = (EditText) findViewById(R.id.edit_text);
                int b = Integer.parseInt(editText.getText().toString());
                if (a == b) {
                    Toast.makeText(soft16140809023071Activity.this, "恭喜您猜对了",
                            Toast.LENGTH_SHORT).show();
                }else if (a > b) {
                    Toast.makeText(soft16140809023071Activity.this, "抱歉了哦，你猜得可能有点小了哦，再试试吧",
                            Toast.LENGTH_SHORT).show();
                }else if(a < b) {
                    Toast.makeText(soft16140809023071Activity.this, "哦不，有点大了哦，要不再想想？",
                            Toast.LENGTH_SHORT).show();
                }
                String inputText=editText.getText().toString();
                save(inputText);
            }
        });
    }

    public void save(String inputText)
    {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try
        {
            out=openFileOutput("data", ContextWrapper.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
//为了下载图片子线程
     Thread t=new Thread(){
         public void run() {
             //下载图片的路径
             String iPath=editText.getText().toString();
             try {
                 //对资源链接
                 URL url=new URL(iPath);
                 //打开输入流
                 InputStream inputStream=url.openStream();
                 //对网上资源进行下载转换位图图片
                bitmap=BitmapFactory.decodeStream(inputStream);
                h.sendEmptyMessage(111);
               inputStream.close();

                 //再一次打开
                 inputStream=url.openStream();
                 File file=new File(Environment.getExternalStorageDirectoy()+"/DCIM/");
                 FileOutputStream fileOutputStream=new FileOutputStream(file);
                 int hasRead=0;
                 while((hasRead=inputStream.read())!=-1){
                    fileOutputStream.write(hasRead);
             }
                fileOutputStream.close();                 inputStream.close();
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         };
     };
 



}




