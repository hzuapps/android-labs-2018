package edu.hzuapps.androidlabs.com1614080901229;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.ImageView;

public class com1614080901229Activity2 extends AppCompatActivity {

    private EditText et;
    private Button btnSave;
    private  Button btn1;
    private Button btn2;
    private ImageView miV;
    private Handler h=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com16140809012292);

        et = findViewById(R.id.et);
        btnSave=findViewById(R.id.btnSave);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        miV=findViewById(R.id.im);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               saveCurrentText();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                readSavedText();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new third("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527877533834&di=5a98561f4935be81f6aa03c20c319971&imgtype=0&src=http%3A%2F%2Fupload.ikanchai.com%2F2018%2F0503%2F1525335971587.jpg",miV,h).start();

            }
        });
    }


    private void readSavedText() {

        try {
            InputStream is = openFileInput("data");
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            is.close();
            String str = new String(bytes, "utf-8");
            et.setText(str);
            Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void saveCurrentText(){
        try {
            OutputStream os=openFileOutput("data", Context.MODE_PRIVATE);
                os.write(et.getText().toString().getBytes("utf-8"));
                os.flush();
                os.close();
                Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
                return;
            } catch (Exception e) {
                e.printStackTrace();


        }

        Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();


    }
}
