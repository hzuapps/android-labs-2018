package com.example.administrator.com1614080901127;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
                setContentView(R.layout.activity1);
                Button but1=(Button)findViewById(R.id.button1);
                but1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                                Intent intent=new Intent(Activity1.this,MainActivity.class);
                                startActivity(intent);
                            }
         });
            }}