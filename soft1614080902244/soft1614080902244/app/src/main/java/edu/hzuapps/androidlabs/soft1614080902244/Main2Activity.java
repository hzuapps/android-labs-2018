package edu.hzuapps.androidlabs.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;

public class Main2Activity extends AppCompatActivity {
    public static final String FILENAME = "setting.set";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Activity thisActivity=this;
        Button btnopen2=(Button) findViewById(R.id.read);
        Button btnsave3=(Button) findViewById(R.id.save);
        btnopen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.read){
                    Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
                    startActivity(intent);
                }
            }
        });
        btnsave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText bu=(EditText) findViewById(R.id.word);
                String content = bu.getText().toString();
                try {
                    // 打开文件获取输出流，文件不存在则自动创建
                    FileOutputStream fos = openFileOutput(FILENAME,
                            Context.MODE_PRIVATE);
                    fos.write(content.getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
