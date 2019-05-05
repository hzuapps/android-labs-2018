package edu.hzuapps.androidlabs.soft1614080902314;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Soft1614080902314Activity extends AppCompatActivity {
    Button button = null;
    private EditText S;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902314);

        Button button1 = (Button)findViewById(R.id.button_open);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902314Activity.this,Soft1614080902314Activity2.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                S=(EditText) findViewById(R.id.editText3);
                saveContent();
                    Intent intent = new Intent();
                    intent.setClass(Soft1614080902314Activity.this,soft1614080902314Activity3.class);
                    startActivity(intent);

            }
        });
        Button button3 = (Button)findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902314Activity.this,Soft1614080902314Activity4.class);
                startActivity(intent);
            }
        });
    }
    private void saveContent() {
        FileOutputStream fos = null;
        String content1 = S.getText().toString();

        try {
            //通过该方法向内部存储中写入数据，文件名为search.txt，模式为MODE_PRIVATE，表示该文件操作权限为文本应用，另一个常用的权限MODE_APPEND表示在文件末尾添加内容
            fos = this.openFileOutput("search.txt", MODE_PRIVATE);
            fos.write(content1.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

