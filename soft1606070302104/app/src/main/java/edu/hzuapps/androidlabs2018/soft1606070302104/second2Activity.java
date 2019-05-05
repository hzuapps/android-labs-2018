package edu.hzuapps.androidlabs2018.soft1606070302104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class second2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        //创建一个Intent实例存储传送过来的值
        Intent myIntent = getIntent();
        //读取Intent的值
        String TextValue = myIntent.getStringExtra("Text");
    }
}
