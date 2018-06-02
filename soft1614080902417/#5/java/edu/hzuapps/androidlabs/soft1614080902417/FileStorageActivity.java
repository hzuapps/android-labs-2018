package edu.hzuapps.androidlabs.soft1614080902417;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import edu.hzuapps.androidlabs.*;



public class FileStorageActivity extends Soft1614080902417Activity {

    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";

    public static final String TAG = FileStorageActivity.class.getSimpleName();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902417);

        ((Button) findViewById(R.id.button_save_internal)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.editText)).getText().toString();
                save(text);

            }
            }
        );
        ((Button) findViewById(R.id.button_save_internal2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.editText)).getText().toString();

                read();
                deleteFile(FILENAME);
                Intent intent = new Intent(FileStorageActivity.this, NewActivity.class);
                startActivity(intent);

                }
        }
        );



    }

    public void save(String text) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("file_demo.txt", ContextWrapper.MODE_APPEND);
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
        }
        Toast.makeText(FileStorageActivity.this, "已保存", Toast.LENGTH_SHORT).show();
    }


    public void read() {
        String content = "";
        try {
            FileInputStream fis = openFileInput("file_demo.txt");
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(FileStorageActivity.this, "您的搜索结果：" + content, Toast.LENGTH_SHORT).show();

    }

}