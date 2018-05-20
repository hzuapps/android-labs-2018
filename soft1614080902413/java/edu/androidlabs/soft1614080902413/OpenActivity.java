package edu.androidlabs.soft1614080902413;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.EditText;
public class OpenActivity extends AppCompatActivity {
    String hms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        setTitle("皮皮钟已打开");
    }
    private void save(String hms) {
            SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();//获取对象，并且命名文件的名称
            editor.putString("hms", hms);  //保存数据
            editor.commit();
            editor.clear();
            Toast.makeText(OpenActivity.this, "保存成功", Toast.LENGTH_LONG).show();
        }
    private void readPrefs() {
        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE); //获取对象，读取data文件
        String hms = prefs.getString("hms", ""); //获取文件中的数据
        Toast.makeText(OpenActivity.this, "时间是："+hms, Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {          //按钮的点击事件
        switch (view.getId()) {
            case R.id.xieru:
                EditText ethour = (EditText)findViewById(R.id.hour);
                hms = ethour.getText().toString();
                save(hms);    //调用保存方法，将输入的姓名和年龄保存
                break;
            case R.id.duqu:
                readPrefs();   //调用读取方法，将保存的文件中的姓名和年龄显示出来
                break;
        }
    }
}
