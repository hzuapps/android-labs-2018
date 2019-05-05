package edu.hzuapps.androidlabs.soft1612070501311;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;
import android.app.Activity;

import static edu.hzuapps.androidlabs.soft1612070501311.R.*;
public class Recharge extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        final Activity thisActivity = this;

        //设置查询界面的文本框和三个按钮
        final EditText info1=(EditText)findViewById(id.et1);   //账户文本框
        final EditText info2=(EditText)findViewById(id.et3);   //充值数目文本框
        Button btnsr = (Button) findViewById(id.bt3);      //确定按钮
        Button btnrt = (Button) findViewById(id.bt4);      //返回按钮
        Button btnls = (Button) findViewById(id.bt5);      //记录按钮

        //为返回按钮设置点击事件
        btnrt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Soft1612070501311Activity.class);    //跳转到主界面
                thisActivity.startActivity(intent);
            }
        });

        //为确定按钮设置点击事件
        btnsr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String saveInfo=info1.getText().toString().trim()+"  "+info2.getText().toString().trim();
                FileOutputStream fos;
                try {
                    fos=openFileOutput("data.txt",MODE_APPEND);        //把文件输出到data中
                    fos.write(saveInfo.getBytes());         //将我们写入的字符串变成字符数组
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(Recharge.this,"充值成功",Toast.LENGTH_SHORT).show();       //显示存储成功的信息
            }
        });

        //为记录按钮设置点击事件
        btnls.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String content="";
                try {
                    FileInputStream fis=openFileInput("data.txt");
                    byte [] buffer=new  byte[fis.available()];
                    fis.read(buffer);
                    content=new String(buffer);
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(Recharge.this,content,Toast.LENGTH_SHORT).show();        //显示存储文件里的信息
            }
        });

    }


    }




