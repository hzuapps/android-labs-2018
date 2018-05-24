package edu.hzuapps.androidlabs.soft1614080902234application;

import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Soft1614080902234Activity1 extends AppCompatActivity {
    protected Button button2;
    protected Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809022341);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                TextView editText = findViewById(R.id.testview);
                editText.setText("vi 设计；计划；表达；投射 n 工程；计划；事业 【网络】 项目 例句： Please count me in on this project 请把我也算入这项计划的参加者。");
                String s = editText.getText().toString().trim();
                save(s);
                startActivity(intent);
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void save(String s) {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            try {
                out=openFileOutput("bc", ContextWrapper.MODE_APPEND);//name:"dat"是用于指定文件名称。创建的文件保存在/data/data/<package name>/fileMODE_APPEND目录中。MODE_APPEND是私有，在原有内容追加数据。
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            assert out != null;
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(s);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

