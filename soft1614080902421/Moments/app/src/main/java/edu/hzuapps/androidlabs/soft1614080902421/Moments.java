package edu.hzuapps.androidlabs.soft1614080902421;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Moments extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moments);
        final Activity thisActivity = this;
        final Button btn_open = (Button) findViewById(R.id.btn_open);//进入子页面
        btn_open.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.equals(btn_open)) {
                    Intent intent = new Intent(thisActivity,SecondActivity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });


    }



}