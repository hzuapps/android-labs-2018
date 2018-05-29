package edu.hzuapps.androidlabs.soft1614080902243;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class SecondActivity extends AppCompatActivity {
    Button button_save = null;
    Button button_load = null;
    TextView contentView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button_save = (Button) findViewById(R.id.button_save);
        button_load = (Button) findViewById(R.id.button_load);
        contentView = (TextView) findViewById(R.id.textView2);
        button_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = ((EditText) findViewById(R.id.save_Text)).getText().toString();
                save(text);
               // contentView.setText(readFiles());
                //System.out.println(getFilesDir());


            }
        });

       button_load.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               contentView.setText(readFiles());


           }
       });
    }

    public void save(String text)  {
        FileOutputStream fos = null;

        try {
            //通过该方法向内部存储中写入数据，文件名为edit_data.txt，模式为MODE_PRIVATE，表示该文件操作权限为文本应用，另一个常用的权限MODE_APPEND表示在文件末尾添加内容
            fos = this.openFileOutput("Android实验", MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                    Toast.makeText(getBaseContext(),"保存成功",Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    public String readFiles()  {

        String s = null;
        FileInputStream fis = null;
        try {
            //通过该方法从内部存储中的edit_data.txt文件中读取数据
            fis = this.openFileInput("Android实验");
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
                    Toast.makeText(getBaseContext(),"保存成功",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;

    }


}






