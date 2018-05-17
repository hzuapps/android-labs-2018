package com.example.administrator.hzulife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class SchoolNewsActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_news_layout);
        initData();
    }
    public void initData(){
        textView=findViewById(R.id.school_news);
        Intent intent=getIntent();
        switch (intent.getIntExtra("image_news",0)){
            case 1:
                textView.setText("今日第一条新闻");
                break;
            case 2:
                textView.setText("今日第二条新闻");
                break;
            case 3:
                textView.setText("今日第三条新闻");
                break;
            case 4:
                textView.setText("今日第四条新闻");
                break;
        }
    }

}
