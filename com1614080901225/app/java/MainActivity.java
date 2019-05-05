package com1614080901225.androidlabs.hzuapps.edu.campushelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText et_info;
    private Button   btn_read;
    private  Button  btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //������ʼ��
        et_info=(EditText)findViewById(R.id.et_info);
        btn_read=(Button)findViewById(R.id.btn_read);
        btn_save=(Button)findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new ButtonListener());
        btn_read.setOnClickListener(new ButtonListener());

    }
    private class ButtonListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_save:
                    String saveInfo=et_info.getText().toString().trim();
                    FileOutputStream fos;
                    try {
                        fos=openFileOutput("data.txt",MODE_APPEND);//���ļ������data��
                        fos.write(saveInfo.getBytes());//������д����ַ�������ַ����飩
                        fos.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this,"���ݱ���ɹ�",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_read:
                    String content="";
                    try {
                        FileInputStream fis=openFileInput("data.txt");
                        byte [] buffer=new  byte[fis.available()];
                        fis.read(buffer);
                        content=new String(buffer);
                        fis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(MainActivity.this,"�����������"+content,Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }
    }
}
