package com.example.asus.soft1614080902206;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.*;
import android.content.Context;
import android.content.Intent;

import java.io.File;

public class message extends AppCompatActivity{
    private EditText meditText1 ,meditText2 ;
    private Button SaveBtn,GetBtn;
    //声明Sharedpreferenced对象
    private SharedPreferences sp ;
    private SharedPreferences sp1 ;

    // App的内部存储目录
    private File mPrivateRootDir;
    // “images”子目录
    private File mImagesDir;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        meditText1= (EditText) findViewById(R.id.editText);
        meditText2 = (EditText) findViewById(R.id.editText1);
        SaveBtn = (Button) findViewById(R.id.button3);
        GetBtn = (Button) findViewById(R.id.button4);
        final Activity thisActivity = this;
        Button btnOpen = (Button) findViewById(R.id.button4);
        btnOpen.setOnClickListener(new View.OnClickListener() {




            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Main2Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button btnOpen1 = (Button) findViewById(R.id.button3);
        btnOpen1.setOnClickListener(new View.OnClickListener() {




            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Main3Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
    public void Click(View view) {
        /**
         * 获取SharedPreferenced对象
         * 第一个参数是生成xml的文件名
         * 第二个参数是存储的格式（**注意**本文后面会讲解）
         */
        sp = getSharedPreferences("Value", Context.MODE_PRIVATE);
        sp1 = getSharedPreferences("Calue", Context.MODE_PRIVATE);
        switch (view.getId()){
            case R.id.button:
                //获取到edit对象
                SharedPreferences.Editor edit = sp.edit();
                SharedPreferences.Editor edit1 = sp1.edit();
                //通过editor对象写入数据
                edit.putString("Value",meditText1.getText().toString().trim());
                edit1.putString("Calue",meditText2.getText().toString().trim());
                //提交数据存入到xml文件中
                edit.commit();
                edit1.commit();
                break;
            case R.id.button2:
                //取出数据,第一个参数是写入是的键，第二个参数是如果没有获取到数据就默认返回的值。
                String value = sp.getString("Value","Null");
                String calue = sp1.getString("Calue","Null");
                meditText1.setText(value);
                meditText2.setText(calue);
                break;
        }
    }
}



