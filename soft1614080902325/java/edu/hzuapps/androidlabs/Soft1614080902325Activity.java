package edu.hzuapps.androidlabs.soft1614080902325;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Soft1614080902325Activity extends AppCompatActivity {
    private Button textview_01;
    private Button textview_02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902325);
        textview_01 = findViewById(R.id.textview_01);
        textview_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到个人信息页面
                Intent intent = new Intent(Soft1614080902325Activity.this,personalInformationActivity.class);
                startActivity(intent);
            }
        });
        textview_02 = findViewById(R.id.textview_02);
        textview_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作者信息页面
                Intent intent = new Intent(Soft1614080902325Activity.this,zuozheActivity.class);
                startActivity(intent);
            }
        });
    }
}
