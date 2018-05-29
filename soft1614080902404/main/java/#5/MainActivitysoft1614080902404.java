package com.example.shinelon.soft1614080902404;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.EditText;
public class MainActivitysoft1614080902404 extends AppCompatActivity {

    String 文本;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysoft1614080902404);
        setTitle("每日推荐音乐");

    } 
                   private void 显示() {
                        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE); 
                        String 留言 = prefs.getString("文本", ""); 
                        Toast.makeText(MainActivitysoft1614080902404.this, "留言是："+留言, Toast.LENGTH_LONG).show();
                    }

               
                     private void 发送(String 文本) {
                            SharedPreferences.Editor et = getSharedPreferences("data", MODE_PRIVATE).edit();
                            et.putString("文本", 文本);  
                            et.commit();
                            et.clear();
                            Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_LONG).show();
                        }
               
                 public void onClick(View view) {   
       
                        switch (view.getId()) {
                                       case R.id.显示按钮:
                                        显示();   
                                        break;
                                case R.id.发送按钮:
                                        EditText et = (EditText)findViewById(R.id.留言输入);
                                        文本 = et.getText().toString();
                                        发送(文本);   
                                        break;
                              
                }

                }
    }