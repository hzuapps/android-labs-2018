package com.example.com1614080901244;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class secondActivity extends AppCompatActivity {

    protected Button button1;
    protected Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = new Intent(secondActivity.this, thirdActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901244);
        setContentView(R.layout.activity_second);
        setTitle("app已启动");
        button1 = findViewById(R.id.my_button1);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edit_message1);
                intent.putExtra("mesd", editText.getText().toString().trim());
                String s = editText.getText().toString().trim();
                save(s);

                startActivity(intent);
            }
        });
    }

    private void save(String s) {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            try {
                out=openFileOutput("dat", ContextWrapper.MODE_APPEND);//name:"dat"是用于指定文件名称。创建的文件保存在/data/data/<package name>/fileMODE_APPEND目录中。MODE_APPEND是私有，在原有内容追加数据。
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

