package edu.hzuapps.androidlabs.Com1614080901130;


import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.nio.file.FileStore;


public class Share extends Activity {

    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";
    public static final String TAG = FileStore.class.getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anni_share);

        // final Activity thisActivity = this;

        Button btnOpen = findViewById(R.id.upload_button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String share_name = ((EditText) findViewById(R.id.name)).getText().toString() + "\n";
                String share_content = ((EditText) findViewById(R.id.content)).getText().toString() + "\n";
                String share_type = ((Spinner) findViewById(R.id.block)).getSelectedItem().toString() + "\n";

                String text = share_type + share_name + share_content ;
                saveTextIntoExternalStorage(text);

            }
        });
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
        String msg = text + file.getAbsolutePath();
        // 显示结果
        showResult(msg);
    }


    // 检查 是否能将文字保存到外部
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
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
        ((TextView) findViewById(R.id.upload_msg)) //
                .setText(result.toCharArray(), 0, result.length());
    }

}
