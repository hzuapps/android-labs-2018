package edu.hzuapps.androidlabs.Soft1614080902309;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class Soft1614080902309Activity extends AppCompatActivity {
    private EditText mEditTextContent;
    private Button mButtonSave;
    private Button mButtonDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902309_activity);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,Soft1614080902309Activity2.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
//进入gojson  进行监听

        Button btn = (Button) findViewById(R.id.gojson);
        btn .setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
    Intent intent = new Intent(thisActivity,Soft1614080902309Activity3.class);
                thisActivity.startActivity(intent);
            }
        });

        mEditTextContent = (EditText) findViewById(R.id.iii);
        Button button1 = (Button) findViewById(R.id.button_open1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //向内部存储写入数据
                saveContent();
                Toast.makeText(Soft1614080902309Activity.this, "保存成功!", Toast.LENGTH_SHORT).show();

            }
        });
        mButtonDisplay = (Button) findViewById(R.id.button_open2);
        mButtonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //从内部存储读取数据
                String s = getContent();
                Toast.makeText(Soft1614080902309Activity.this, s, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String getContent() {
        String s = null;
        FileInputStream fis = null;
        try {
            //通过该方法从内部存储中的edit_data.txt文件中读取数据
            fis = this.openFileInput("edit_data.txt");
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




    private void saveContent() {
        FileOutputStream fos = null;
        String content = mEditTextContent.getText().toString();

        try {


            //通过该方法向内部存储中写入数据，文件名为edit_data.txt，模式为MODE_PRIVATE，表示该文件操作权限为文本应用，另一个常用的权限MODE_APPEND表示在文件末尾添加内容
            fos = this.openFileOutput("edit_data.txt", MODE_PRIVATE);
            fos.write(content.getBytes());
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



