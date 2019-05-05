package com.example.administrator.soft1614080902425;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Soft1614080902425Activity5 extends AppCompatActivity implements View.OnClickListener {
    TextView textview;
    private Button Button;
    public static final String TAG = Soft1614080902425Activity5.class.getSimpleName();
    Activity now;
    private AutoCompleteTextView username;
    String[] a=new String[5];
    String[] data = new String[]{
            "admin", "adm"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902425);
        Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(this);
        now=this;
        getMemory();
        username=(AutoCompleteTextView)findViewById(R.id.username);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Soft1614080902425Activity5.this,android.R.layout.simple_dropdown_item_1line,a);
        username.setAdapter(adapter);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                String text=((AutoCompleteTextView)findViewById(R.id.username)).getText().toString();
                Saveusername(text);
                Intent intent=new Intent();
                intent.putExtra("nexttableActivity", "123");
                intent.setClass(now, nexttableActivity.class); //设置跳转的Activity
                now.startActivity(intent);
                break;
            case R.id.button2:
                String str2="2";

                break;

        }
    }
    public void Saveusername(String text)
    {
        File dir=this.getFilesDir();
        File file = new File(dir, "memory.txt");
        if (file.exists()) { // 判断文件是否存在
           /* Log.i(TAG, file.getAbsolutePath());
            Log.i(TAG, file.length() + ""); // bytes*1024=kb *1024 MB
            Log.i(TAG, file.isFile() + "");*/
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }
        FileOutputStream fos = null;
        try { // 使用API打开输出流
            fos = openFileOutput("memory.txt", MODE_APPEND);
            //FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes()); // 写入内容
            fos.close(); // 关闭流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void getMemory()
    {
        File dir=this.getFilesDir();
        File file = new File(dir, "memory.txt");
        if (file.exists()) { // 判断文件是否存在
            /*Log.i(TAG, file.getAbsolutePath());
            Log.i(TAG, file.length() + ""); // bytes*1024=kb *1024 MB
            Log.i(TAG, file.isFile() + "");*/
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }
        FileReader reader = null; // char

        try {
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line=null;
            int i=0;
            while(i<5) {
                line = bReader.readLine();
                a[i]=line;
                if(line==null)
                    a[i]=" ";
                //Log.i(TAG, "从文件读取的内容: " + line);
                //Toast.makeText(getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                i++;
            }

            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    /*private void Tomemory(String result) {

        ((TextView) findViewById(R.id.text_path)) //
                .setText(result.toCharArray(), 0, result.length());
    }*/
}
}
