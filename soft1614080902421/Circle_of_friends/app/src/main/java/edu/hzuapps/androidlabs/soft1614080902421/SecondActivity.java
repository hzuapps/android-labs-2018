package edu.hzuapps.androidlabs.soft1614080902421;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        final Activity thisActivity = this;
        final Button btn_back = (Button) findViewById(R.id.btn_back);//返回开始界面
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(btn_back)) {
                    Intent intent = new Intent(thisActivity,CircleOfFriends.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
    }
}