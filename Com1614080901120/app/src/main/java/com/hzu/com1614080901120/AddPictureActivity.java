package com.hzu.com1614080901120;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AddPictureActivity extends AppCompatActivity {

    private EditText info;
    private Button save;
    private Button read;
    private Button jmpbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_picture);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        info=(EditText)findViewById(R.id.word);
        save=(Button)findViewById(R.id.save);
        read=(Button)findViewById(R.id.read);
        save.setOnClickListener(new ButtonListener());
        read.setOnClickListener(new ButtonListener());

        jmpbutton=(Button)findViewById(R.id.jmp);
        jmpbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                Intent intent = new Intent(AddPictureActivity.this, ThirdMainActivity.class);
                startActivity(intent);
            }
        });
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.save) {
                String saveInfo = info.getText().toString().trim();
                FileOutputStream fos;
                try {
                    fos = openFileOutput("data.text", Context.MODE_APPEND);
                    fos.write(saveInfo.getBytes());
                    fos.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(AddPictureActivity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
            }

            if (v.getId() == R.id.read) {
                String content = "";
                try {
                    FileInputStream fis = openFileInput("data.text");
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    content = new String(buffer);
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(AddPictureActivity.this, "保存的数据是" + content, Toast.LENGTH_SHORT).show();

            }


        }

        }



    }




