package edu.hzuapps.androidlabs.soft1614080902121;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static edu.hzuapps.androidlabs.soft1614080902121.R.attr.height;

/**
 * Created by 76027 on 2018/5/25.
 */

public class FifthActivity extends Activity {
    private TextView textView;
    private String line;
    private Button button;
    private Intent intent;
    private Bundle bundle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        textView=(TextView)findViewById(R.id.button1);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(FifthActivity.this,Soft1614080902121Activity.class);
                startActivity(intent);
            }});
       load();
        //设置返回上一个页面的数据
        setBackData();
    }

    public void load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            //设置将要打开的存储文件名称
            in = openFileInput("data1");
            //FileInputStream -> InputStreamReader ->BufferedReader
            reader = new BufferedReader(new InputStreamReader(in));
            //读取每一行数据，并追加到StringBuilder对象中，直到结束
            line = reader.readLine();



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    private void setBackData(){
        textView.setText("你新建的歌单成功"+"\n新建的歌单名为："+line);

    }
}
