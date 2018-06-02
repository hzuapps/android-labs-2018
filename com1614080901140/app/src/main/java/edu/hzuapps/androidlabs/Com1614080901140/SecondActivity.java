package edu.hzuapps.androidlabs.com1614080901140;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import android.content.ContextWrapper;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import android.content.Intent;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ((Button) findViewById(R.id.btn_save)).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = ((EditText) findViewById(R.id.et_info)).getText().toString();
                        save(text);
                    }
                });
        ((Button) findViewById(R.id.btn_read)).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        readsy5();
                    }
                });
        nextbtn=(Button)findViewById(R.id.btn_t);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

    }

    public void save(String text) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("sy.txt", ContextWrapper.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(SecondActivity.this, "订单保存成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void readsy5() {
        String content = "";
        try {
            FileInputStream fis = openFileInput("sy.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(SecondActivity.this, "您的订单号是" + content, Toast.LENGTH_SHORT).show();

    }
}