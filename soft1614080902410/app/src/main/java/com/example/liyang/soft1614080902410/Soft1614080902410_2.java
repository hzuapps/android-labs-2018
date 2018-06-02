package com.example.liyang.soft1614080902410;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Soft1614080902410_2 extends AppCompatActivity {
    private TextView textView;
    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    public static final String TAG = Soft1614080902410_2.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902410_2);

        final Activity thisActivity = this;
        Button btnHome1 = (Button) findViewById(R.id.buttom2);
        Button btnHome2 = (Button) findViewById(R.id.buttom3);
        btnHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent intent1 = new Intent(thisActivity,Soft1614080902410Activity_4.class);
                thisActivity.startActivity(intent1);
            }
        });
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent2 = new Intent(thisActivity, Soft1614080902410Activity_3.class);
                thisActivity.startActivity(intent2);
            }
        });

        String text = "content";
        saveTextIntoExternalStorage(text);
    }

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
        ((TextView) findViewById(R.id.text_path))//
                .setText(result.toCharArray(), 0, result.length());
    }
}
