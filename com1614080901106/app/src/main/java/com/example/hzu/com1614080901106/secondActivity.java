package com.example.hzu.com1614080901106;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import android.content.ContextWrapper;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import org.w3c.dom.Text;

public class secondActivity extends AppCompatActivity {

    private TextView tvShowTall;
    String sex;
    double tall;
    double weight;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getDate();
        initViews();
        bindData();

        ((Button) findViewById(R.id.btn_save)).

                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String text = ((TextView) findViewById(R.id.tvShowTall)).getText().toString();
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


    }

    public void save(String text) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("sy5.txt", ContextWrapper.MODE_APPEND);
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
            Toast.makeText(secondActivity.this, "数据保存成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void readsy5() {
        String content = "";
        try {
            FileInputStream fis = openFileInput("sy5.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(secondActivity.this, "保存的数据是" + content, Toast.LENGTH_SHORT).show();

    }
    private void getDate(){
        Bundle bundle=getIntent().getExtras();
        sex=bundle.getString("sex");
        tall=bundle.getDouble("tall");
        if(sex.equals("男"))
            weight=(tall-80)*0.7;
        else
            weight=(tall-70)*0.6;

    }
    private void initViews(){
        tvShowTall=(TextView)findViewById(R.id.tvShowTall);

    }
    private void bindData(){
        tvShowTall.setText("你是一位"+sex+"性"+"\n你的身高是"+tall+"厘米\n你的标准体重是"+(float)weight+"千克。");
    }

}
