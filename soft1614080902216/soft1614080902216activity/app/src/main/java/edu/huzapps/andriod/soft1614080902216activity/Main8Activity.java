package edu.huzapps.andriod.soft1614080902216;

import android.content.Intent;
import android.widget.EditText;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.*;
import android.util.Log;
import android.os.Environment;
import android.content.Context;
public class Main8Activity extends AppCompatActivity {

    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    public static final String TAG = Main8Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
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
        Button btnOpen1 = (Button) findViewById(R.id.button10);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main8Activity.this, Main4Activity.class);
                startActivity(intent);

            }
        });
       final EditText[] tx=new EditText[3];
        tx[0]= (EditText) findViewById(R.id.editText3);
        tx[1]= (EditText) findViewById(R.id.editText4);
        tx[2]= (EditText) findViewById(R.id.editText5);
        Button btnOpen2 = (Button) findViewById(R.id.button9);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    String[] s=new String[3];

                    for(int i=0;i<3;i++) {
                            s[i] = tx[i].getText().toString();

                        }
                saveTextIntoInternalStorage(s);

            }
        });
    }

    private void saveTextIntoInternalStorage(String[] text) {
        // 获取内部存储目录
        File dir = this.getFilesDir();
        File file = new File(dir, FILENAME);
//        try {
//            File = File.createTempFile(FILENAME, null, dir);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

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
            for (int i = 0; i < 3; i++) {
                fos.write(text[i].getBytes()); // 写入内容
             //  fos.close(); // 关闭流
            }
            Toast.makeText(Main8Activity.this,"数据保存成功",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(Main8Activity.this,"文件不能建成",Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(Main8Activity.this,"输入错误",Toast.LENGTH_SHORT).show();
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
            Toast.makeText(Main8Activity.this,"数据读取成功",Toast.LENGTH_SHORT).show();
            bReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}





