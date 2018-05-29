package edu.hzuapps.androidlabs.soft1606081301233;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnCancel2 = (Button) findViewById(R.id.btnCancel);
        btnCancel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, Soft1606081301233Activity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.btnRead)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //从内部读取数据
                    String s=read();
                    Toast.makeText(SecondActivity.this,s,Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ((Button) findViewById(R.id.btnSave)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //往内部写入数据
                String text1 = ((EditText) findViewById(R.id.etContent1)).getText().toString();
                String text2 = ((EditText) findViewById(R.id.etContent2)).getText().toString();
                String text3 = ((EditText) findViewById(R.id.etContent3)).getText().toString();
                try {
                    save(text1);
                    save(text2);
                    save(text3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //写入
    public void save(String text) throws IOException {
        FileOutputStream fos = null;
        BufferedWriter writer = null;
        try {
            fos = openFileOutput("test.txt", ContextWrapper.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(text);
            writer.flush();
            Toast.makeText(this, "写入完成", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    //读出
    public String read() throws IOException {
        String s=null;
        FileInputStream fis=null;
        try {
            fis=this.openFileInput("test.txt");
            int len=0;
            byte[] buffer=new byte[1024];
            while((len=fis.read(buffer))!=-1){
                s=new String(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                fis.close();
            }
        }
        return s;
    }
}



