package com.example.b.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class soft1606081301337MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
               getSupportActionBar().hide();// 隐藏ActionBar
               getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity_soft1606081301337_main);


        findViewById(R.id.imageButton9).setOnClickListener(new OnClickListener(){

                  @Override
           public void onClick(View v) {
                                              Intent intent = new Intent(  soft1606081301337MainActivity.this,soft1606081301337Activity2.class);
                                            startActivity(intent);
                                          }
      } );




    }	     }





