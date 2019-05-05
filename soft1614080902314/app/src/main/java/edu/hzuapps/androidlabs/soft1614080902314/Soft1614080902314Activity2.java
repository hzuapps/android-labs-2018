package edu.hzuapps.androidlabs.soft1614080902314;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.*;
import java.io.FileOutputStream;

public class Soft1614080902314Activity2 extends AppCompatActivity {
    Button button = null;
    private EditText t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_soft1614080902314);
        t1 = (EditText) findViewById(R.id.editText);
        t2 = (EditText) findViewById(R.id.editText2);
        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //向内部存储写入数据
                saveContent();
                Toast.makeText(Soft1614080902314Activity2.this, "信息存储成功!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //写入数据
    private void saveContent() {
        FileOutputStream fos = null;
        String content1 = t1.getText().toString();
        String content2 = t2.getText().toString();
        String s=getContent();
        int i=Integer.parseInt(s);
        i++;
        try {
            fos = this.openFileOutput("name"+i+".txt", MODE_PRIVATE);
            fos.write(content1.getBytes());
            fos = this.openFileOutput("message"+i+".txt", MODE_PRIVATE);
            fos.write(content2.getBytes());
            fos = this.openFileOutput("amount.txt", MODE_PRIVATE);
            s=String.valueOf(i);
            fos.write(s.getBytes());
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
    private String getContent() {
        String s=null;
        FileInputStream fis = null;
        try {
            fis = this.openFileInput("amount.txt");
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s = new String(buf, 0, len, "UTF-8");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }
}
