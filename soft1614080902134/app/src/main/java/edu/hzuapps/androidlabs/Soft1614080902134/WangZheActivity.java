package edu.hzuapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.soft1614080902134.R;

/*
加减王者的app主页
 */
public class WangZheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_zhe);

        //添加跳转按钮，添加按钮点击事件
        Button Btn1=(Button)findViewById(R.id.btn1);
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转至 WangZheLogActivity.java
                Intent intent=new Intent(WangZheActivity.this,WangZheLogActivity.class);
                startActivity(intent);
            }
        });
    }
}
