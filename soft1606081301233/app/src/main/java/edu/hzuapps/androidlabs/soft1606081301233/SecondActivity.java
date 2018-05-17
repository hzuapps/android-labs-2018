package edu.hzuapps.androidlabs.soft1606081301233;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SecondActivity extends AppCompatActivity {
    private EditText etContent1;
    private EditText etContent2;
    private EditText etContent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        etContent1=(EditText)findViewById(R.id.etContent1);
        etContent2=(EditText)findViewById(R.id.etContent2);
        etContent3=(EditText)findViewById(R.id.etContent3);
        Button btnCancel2 = (Button) findViewById(R.id.btnCancel);
        btnCancel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, Soft1606081301233Activity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 写入内容并保存在demo.txt中
     * @param view
     */
    public void save(View view){
       String content1=etContent1.getText().toString();
       String content2=etContent2.getText().toString();
       String content3=etContent3.getText().toString();
       FileOutputStream fos1=null;   //字节流
       FileOutputStream fos2=null;
       FileOutputStream fos3=null;
       BufferedWriter writer1=null;  //字符流
       BufferedWriter writer2=null;
       BufferedWriter writer3=null;

        try {
            fos1=openFileOutput("demo.txt",Context.MODE_APPEND);//使用API打开输出流
            fos2=openFileOutput("demo.txt",Context.MODE_APPEND);
            fos3=openFileOutput("demo.txt",Context.MODE_APPEND);
            writer1=new BufferedWriter(new OutputStreamWriter(fos1));  //把字节流与字符流连接在一起
            writer2=new BufferedWriter(new OutputStreamWriter(fos2));
            writer3=new BufferedWriter(new OutputStreamWriter(fos3));
            writer1.write(content1);  //写入
            writer2.write(content2);
            writer3.write(content3);
            writer1.flush();      //刷新
            writer2.flush();
            writer3.flush();
            Toast.makeText(this,"写入完成...",Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if(writer3!=null) {
                        writer3.close();   //用完之后关闭，后开的先关
                    }
                    if(writer2!=null){
                        writer2.close();
                    }
                    if(writer1!=null){
                        writer1.close();
                    }
                    if(fos3!=null){
                        fos3.close();;
                    }
                    if(fos2!=null){
                        fos2.close();
                    }
                    if(fos1!=null){
                        fos1.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



