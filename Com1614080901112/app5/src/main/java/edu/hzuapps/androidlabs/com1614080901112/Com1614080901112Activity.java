package edu.hzuapps.androidlabs.com1614080901112;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Com1614080901112Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_info;
    private Button btn_save;
    private Button btn_read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901112);

        et_info = (EditText)findViewById(R.id.et_info);
        btn_save = (Button)findViewById(R.id.bt_save);
        btn_read = (Button)findViewById(R.id.bt_read);
        btn_save.setOnClickListener(this);
        btn_read.setOnClickListener(this);

    }

    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_save:
                String saveInfo = et_info.getText().toString().trim();
                FileOutputStream fos;
                try {
                    fos = openFileOutput("data.txt", Context.MODE_APPEND);
                    fos.write(saveInfo.getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(Com1614080901112Activity.this,"保存成功",0).show();
                break;
            case R.id.bt_read:
                String content = "";
                try {
                    FileInputStream fis = openFileInput("data.txt");
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    content = new String(buffer);
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(Com1614080901112Activity.this,"保存成功"+content,0).show();
                break;
            default:;
        }


    }
}
