package edu.hzuapps.androidlabs.com1614080901213;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import android.widget.Button;
import android.os.Handler;

import android.widget.ImageView;

import java.io.File;

import org.w3c.dom.Text;

public class com1614080901213Activity extends AppCompatActivity {


    private TextView textView;
    private ImageView huizhou;

    private Handler handler=new Handler();


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_com1614080901213);


        textView=(TextView)findViewById(R.id.textview_01);
        huizhou=(ImageView)findViewById(R.id.imageView_huizhou);


        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(com1614080901213Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });
        ((Button)findViewById(R.id.button_xiazai)).setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                new chenbaju("http://chuantu.biz/t6/319/1527343858x-1404758383.jpg",huizhou,handler).start();

            }});

    }

}