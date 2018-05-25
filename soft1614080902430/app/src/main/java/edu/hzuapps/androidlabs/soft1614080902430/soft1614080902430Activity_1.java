package edu.hzuapps.androidlabs.soft1614080902430;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class soft1614080902430Activity_1 extends AppCompatActivity {

    private TextView textView;
    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    public static final String TAG = soft1614080902430Activity_1.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902430_1);


        Button btnOpen = (Button) findViewById(R.id.button_open);

        btnOpen.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                Intent intent = new Intent(soft1614080902430Activity_1.this,soft1614080902430Activity_2.class);
                startActivity(intent);
            }
        });

        String text = "content";
        saveTextIntoExternalStorage(text);
    }


    // 将文字保存到外部存储
    private void saveTextIntoExternalStorage(String text) {
        if (!isExternalStorageWritable()) {
            Log.e(TAG, "外部存储不可写!");
            return;
        }

        File dir = getPublicExtStorageDir(DIRECTORY, Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir, FILENAME);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 显示结果
        showResult(file.getAbsolutePath());
    }

    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    // 创建公开的外部存储目录（App卸载时不会删除）
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

    private void showResult(String result) {
        ((TextView) findViewById(R.id.text_path)) //
                .setText(result.toCharArray(), 0, result.length());
    }

}
