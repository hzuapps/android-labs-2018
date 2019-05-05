package com.example.john.soft1614080902237;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class M1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);
        //获取控件
        Button btnLogin=(Button)findViewById(R.id.btn_login);
        final EditText EdPassword=(EditText) findViewById(R.id.Ed_Password);
        final EditText EdUserName=(EditText)findViewById(R.id.Ed_UserName);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SharedPreferences sharedPreferences = getSharedPreferences("jzc", Context.MODE_PRIVATE);//创建SharedPreferences对象
                SharedPreferences.Editor editor = sharedPreferences.edit(); //需要获取SharedPreferences的编辑对象
                editor.putString("username", EdUserName.getText().toString()); //向preferences写入数据：
                editor.putString("Password", EdPassword.getText().toString());
                editor.commit();// 向preferences文件中提交数据：
                Intent intent=new Intent(M1Activity.this,M4Activity.class);
                startActivity(intent);
            }
        } );
    }
}

