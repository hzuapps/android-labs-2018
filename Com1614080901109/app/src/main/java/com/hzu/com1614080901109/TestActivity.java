package edu.androidlabs.com1614080901109;

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

public class TestActivity extends AppCompatActivity {
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }
    private void save(String data) {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();//获取对象，并且命名文件的名称
        editor.putString("data", data);  //保存数据
        editor.commit();
        editor.clear();
        Toast.makeText(TestActivity.this, "数据已载入", Toast.LENGTH_LONG).show();
    }
    private void readPrefs() {
        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE); //获取对象，读取data文件
        String hms = prefs.getString("data", ""); //获取文件中的数据
        Toast.makeText(TestActivity.this, "现存储的数据是："+hms, Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {          //按钮的点击事件
        switch (view.getId()) {
            case R.id.xieru:
                EditText ethour = (EditText)findViewById(R.id.hour);
                data = ethour.getText().toString();
                save(data);    //调用保存方法，将输入的数据保存
                break;
            case R.id.duqu:
                readPrefs();   //调用读取方法，将保存的文件中的数据显示出来
                break;
        }
    }

}
