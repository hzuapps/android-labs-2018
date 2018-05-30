package edu.hzuapps.androidlabs.com1614080901224;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import android.widget.TextView;

import android.widget.Button;
import android.os.Handler;

import android.widget.ImageView;

import java.io.File;

import org.w3c.dom.Text;


import org.w3c.dom.Text;



public class com1614080901224Activity extends AppCompatActivity {



    private TextView textView;
    private ImageView lzb;

    private Handler handler=new Handler();




    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_com1614080901224);


        textView=(TextView)findViewById(R.id.textview_01);


        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(com1614080901224Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });
        ((Button)findViewById(R.id.button_xiazai)).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                new word("http://chuantu.biz/t6/321/1527563117x-1404781234.jpg",lzb,handler).start();

            }});

    }

}