package edu.hzuapps.androidlabs.com1614080901219;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
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


public class com1614080901219activity3 extends AppCompatActivity {
    private TextView textView1,textView2,bt2,bt3,bt4,bt5,bt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219activity3);

        textView2 = (TextView) findViewById(R.id.nichen);
        bt2 = (TextView) findViewById(R.id.bt2);
        bt3 = (TextView) findViewById(R.id.bt3);
        bt4 = (TextView) findViewById(R.id.bt4);
        bt5 = (TextView) findViewById(R.id.bt5);
        bt6 = (TextView) findViewById(R.id.bt6);

    }

}
