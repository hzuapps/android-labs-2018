package com.example.soft1614080902208;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DownloadPictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_picture);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        //获取控件
        Button downloadButton = (Button) findViewById(R.id.download);
        //final EditText EdUserName = (EditText) findViewById(R.id.edit_text);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("jnc", Context.MODE_PRIVATE);//创建SharedPreferences对象
                SharedPreferences.Editor editor = sharedPreferences.edit(); //需要获取SharedPreferences的编辑对象
                editor.putString("username", editText.getText().toString()); //向preferences写入数据：
                editor.commit();// 向preferences文件中提交数据：
                Intent intent = new Intent(DownloadPictureActivity.this, PictureActivity.class);
                startActivity(intent);
            }
        });
    }
}
