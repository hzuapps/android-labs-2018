package edu.hzuapps.androidlabs.soft1614080902205;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.*;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import edu.hzuapps.androidlabs.soft1614080902205.MainActivity2;

public class MainActivity1 extends AppCompatActivity{
Button b1;
    Button b5;
    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    public static final String TAG = MainActivity1.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        b1= (Button) findViewById(R.id.button3 );
        b5= (Button) findViewById(R.id.button4 );
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent = new Intent();
                intent.setClass(MainActivity1.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.editText)).getText().toString();
                saveTextIntoInternalStorage(text);
            }


        });
    }
    // 将文字保存到内部存储
    private void saveTextIntoInternalStorage(String text) {
        // 获取内部存储目录
        File dir = this.getFilesDir();
        //File dir = getCacheDir();

        if (dir.isDirectory()) {
//            dir.mkdir();
//            dir.mkdirs();
        }

        if (dir.isFile()) {
            // D:/Abc.txt , -> D:/Abc1.txt ->D:/abc.txt
        }

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



        // 删除文件
        // file.delete();
        // deleteFile(FILENAME);
    }




    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    private File getPublicExtStorageDir(String dirName, String type) {
        if (type == null) { // 指定文件类型
            type = Environment.DIRECTORY_PICTURES;
        }
        File dir = new File(Environment //
                .getExternalStoragePublicDirectory(type), dirName);
        if (!dir.mkdirs()) {
            Log.e(TAG, "目录无法创建!");
        }

        long freeSpace = dir.getFreeSpace();
        Log.i(TAG, "剩余空间大小: " + (freeSpace / 1024 / 1024) + "MB");
        long totalSpace = dir.getTotalSpace();
        Log.i(TAG, "总空间大小: " + (totalSpace / 1024 / 1024) + "MB");

        return dir;
    }


}
