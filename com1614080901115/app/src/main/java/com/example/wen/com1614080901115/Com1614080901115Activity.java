package com.example.wen.com1614080901115;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class Com1614080901115Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901115);

        final Intent it = new Intent(this,SecondActivity.class); //你要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(it); //执行
            }
        };
        timer.schedule(task, 1000 * 3);
    }
}