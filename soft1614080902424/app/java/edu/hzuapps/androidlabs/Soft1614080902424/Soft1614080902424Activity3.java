package edu.hzuapps.androidlabs.Soft1614080902424;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Soft1614080902424Activity3 extends AppCompatActivity {
    private Button mButtonSave;
    private Button mButtonDisplay;
    private EditText mEditTextContent;
    private EditText mEditTextContent1;
    private EditText mEditTextContent2;
    private EditText mEditTextContent3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902424_activity3);
        Button yes = (Button) findViewById(R.id.yes);
        mEditTextContent = (EditText) findViewById(R.id.name);
        mEditTextContent1 = (EditText) findViewById(R.id.phone);
        mEditTextContent2 = (EditText) findViewById(R.id.province);
        mEditTextContent3 = (EditText) findViewById(R.id.address);
        mButtonSave = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity3.this, Soft1614080902424Activity2.class);
                startActivity(intent);
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //向内部存储写入数据
                saveContent();
                Toast.makeText(Soft1614080902424Activity3.this, "saved!", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void saveContent() {
        FileOutputStream fos = null;
        String content = mEditTextContent.getText().toString();
        String content1 = mEditTextContent1.getText().toString();
        String content2 = mEditTextContent2.getText().toString();
        String content3 = mEditTextContent3.getText().toString();

        try {


            //通过该方法向内部存储中写入数据，文件名为edit_data.txt，模式为MODE_PRIVATE，表示该文件操作权限为文本应用，另一个常用的权限MODE_APPEND表示在文件末尾添加内容
            fos = this.openFileOutput("edit_data.txt", MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.write(content1.getBytes());
            fos.write(content2.getBytes());
            fos.write(content3.getBytes());
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
