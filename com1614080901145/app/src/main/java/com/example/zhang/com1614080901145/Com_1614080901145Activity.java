package com.example.zhang.apps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Com_1614080901145Activity extends AppCompatActivity{

    private static final String TAG =Com_1614080901145Activity.class.getSimpleName() ;
    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    @Override
   protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_1614080901145);
        Button button1 = (Button)findViewById(R.id.button_5);
                button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                @SuppressLint("WrongViewCast") String text = ((EditText) findViewById(R.id.edit_text)).getText().toString();
                saveTextIntoInternalStorage(text);
                Toast.makeText(Com_1614080901145Activity.this, "非常抱歉，暂时没有找到相关资源，我们已经将你的需求记录，敬请期待！", Toast.LENGTH_SHORT).show();
            }
        });
        Button button2 = (Button)findViewById(R.id.button_9);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Com_1614080901145Activity.this,Download.class);
                startActivity(intent);
            }
        });

    }

        // 将文字保存到内部存储
        private void saveTextIntoInternalStorage(String text) {
                // 获取内部存储目录
                        File dir = this.getFilesDir();
                File file = new File(dir, FILENAME);

                        if (file.exists()) { // 判断文件是否存在
                        Log.i(TAG, file.getAbsolutePath());
                        Log.i(TAG, file.length() + ""); // bytes*1024=kb *1024 MB
                        Log.i(TAG, file.isFile() + "");
                        file.canRead();
                        file.canWrite();
                        file.canExecute();

                                file.getFreeSpace();
                        file.getTotalSpace();
                    }

                       FileOutputStream fos = null;  // 字节流  | char | cn : gbk 2 bytes, utf8 3 bytes

                        try { // 使用API打开输出流
                        fos = openFileOutput(FILENAME, MODE_PRIVATE);
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

                        FileReader reader = null; // char

                        try {
                        reader = new FileReader(file.getAbsoluteFile());
                        BufferedReader bReader = new BufferedReader(reader);
                        String line = bReader.readLine();
                        Log.i(TAG, "从文件读取的内容: " + line);
                        bReader.close();
                        reader.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                // 显示结果
                        showResult(file.getAbsolutePath());
            }
            //显示路径
            public void showResult(String result) {
                {((TextView) findViewById(R.id.text_1)).setText(result.toCharArray(), 0, result.length());}
    }}


