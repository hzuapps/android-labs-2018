package edu.hzuapps.androidlabs.soft1614080902334;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902334WeatherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902334_weather);
        final Activity thisActivity = this;
        final Button btn_open = (Button) findViewById(R.id.btn_open);
        //启动界面增加按钮进入子页面
        btn_open.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(btn_open)) {
//                    Intent intent = new Intent(thisActivity,BasicActivity.class);
                    Intent intent = new Intent(thisActivity,CityInfoActivity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });


    }



}
