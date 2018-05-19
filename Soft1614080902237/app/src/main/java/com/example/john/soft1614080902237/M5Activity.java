package com.example.john.soft1614080902237;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class M5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m5);
        TextView txtUserName=(TextView) findViewById(R.id.txt_UserName);
       // TextView txtPassword=(TextView) findViewById(R.id.txt_Password);

        SharedPreferences sharedPreferences = getSharedPreferences("jc", Context.MODE_PRIVATE); //创建SharedPreferences对象
        String userName=sharedPreferences.getString("username","");//根据key获取对应的数据
        //String password=sharedPreferences.getString("Password","");
       // txtPassword.setText(password);//给TextView设置text的值
        txtUserName.setText(userName);
    }
    }
