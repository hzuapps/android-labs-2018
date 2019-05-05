package edu.hzuapps.androidlabs.soft1614080902205;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


import static edu.hzuapps.androidlabs.soft1614080902205.R.layout.activity_soft1614080902205ctivity;

public class Soft1614080902205ctivity extends AppCompatActivity{
    Button b;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soft1614080902205ctivity);
        b= (Button) findViewById(R.id.button2 );

        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent = new Intent();
                intent.setClass(Soft1614080902205ctivity.this, MainActivity1.class);
                startActivity(intent);
            }
        });
        b3= (Button) findViewById(R.id.button );
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v1) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent1 = new Intent();
                intent1.setClass(Soft1614080902205ctivity.this, MainActivity2.class);
                startActivity(intent1);
            }
        });

    }



}

