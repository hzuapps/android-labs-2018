package edu.hzuapps.androidlabs.soft1614080902334;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        final Activity thisActivity = this;
        final Button btn_back = (Button) findViewById(R.id.btn_back);
        //子页面增加按钮返回启动页面
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(btn_back)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902334WeatherActivity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
    }
}
