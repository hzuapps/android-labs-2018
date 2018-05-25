package edu.androidlabs.soft1614080902440;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Soft1614080902440Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_soft1614080902440);
        //获取UI对象
        Button bt_write = (Button) findViewById(R.id.write);
        Button bt_read = (Button) findViewById(R.id.read);
        Button bt_next = (Button) findViewById(R.id.next);
        //对写入数据的按钮添加监听器
        bt_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = ((EditText) findViewById(R.id.EditText_1)).getText().toString();
                write(text);

            }
        });
        //对读取数据的按钮添加监听器
        bt_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                read();

            }
        });
        //对跳转的按钮添加监听器
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902440Activity2.this,Soft1614080902440Activity3.class);
                Soft1614080902440Activity2.this.startActivity(intent);

            }
        });
    }
    //写入数据
    public void write(String text) {
                FileOutputStream out = null;
                BufferedWriter writer = null;
                try {
                        out = openFileOutput("test.txt", ContextWrapper.MODE_APPEND);
                        writer = new BufferedWriter(new OutputStreamWriter(out));
                        writer.write(text);
                        writer.flush();
                        out.flush();
                        writer.close();
                        out.close();
                   } catch (Exception e) {
                        e.printStackTrace();
                    }
                        Toast.makeText(Soft1614080902440Activity2.this, "发布成功", Toast.LENGTH_SHORT).show();

            }
    //读取数据
     public void read() {
                String content = "";
                try {
                        FileInputStream fis = openFileInput("test.txt");
                        byte[] buffer = new byte[fis.available()];
                        fis.read(buffer);
                     content = new String(buffer);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                Toast.makeText(Soft1614080902440Activity2.this, "发布内容为：" + content, Toast.LENGTH_SHORT).show();
           }
}

