package com.example.a14775.soft1614080902112activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button_1=(Button)findViewById(R.id.cuanjian);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText="创建成功";
                Toast.makeText(SecondActivity.this,inputText,Toast.LENGTH_SHORT).show();
            }
        });
    }
}