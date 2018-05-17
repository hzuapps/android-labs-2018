package edu.hzuapps.androidlabs.soft1614080902337;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Soft1614080902337Activity2 extends AppCompatActivity {
        EditText edt;
        Button but;
        TextView show;

        public static final String filename = "file_demo_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809023372);

        edt=(EditText)findViewById(R.id.class11);
        but=(Button)findViewById(R.id.write);
        show=(TextView)findViewById(R.id.show);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    WriteFiles(edt.getText().toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    show.setText(ReadFiles());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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
    }

       File file;
    //保存文件内容
    public void WriteFiles(String content) throws FileNotFoundException {
        File dir = this.getFilesDir(); //获取内部存储目录
        file = new File(dir,filename); //file就是内部存储的文件
        FileOutputStream fos = openFileOutput(filename,MODE_PRIVATE); //流指向文件
        try {
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //读取文件内容
    public String ReadFiles() throws IOException {
        FileReader reader = null;
        reader = new FileReader(file.getAbsoluteFile());
        BufferedReader bReader = new BufferedReader(reader);
        String content = bReader.readLine();
        bReader.close();
        reader.close();
        return content;
    }
}
