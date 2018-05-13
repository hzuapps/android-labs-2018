package edu.hzuapps.androidlabs.soft1614080902205;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.*;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity1 extends AppCompatActivity{
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        b1= (Button) findViewById(R.id.button3 );
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent = new Intent();
                intent.setClass(MainActivity1.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

}
