package com.hzu.edu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Soft1614080902428activityMain2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft1614080902428activity_main2);
        Button button1=(Button) findViewById( R.id.btn1_editnote);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902428activityMain2Activity.this,chakan.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.btn2_editnote);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Soft1614080902428activityMain2Activity.this,xiugai.class);
                startActivity(intent);
            }
        });
    }

}
