package com.example.soft1614080902131stopwatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Soft1614080902131CoverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902131_cover);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(Soft1614080902131CoverActivity.this,Soft1614080902131HomeActivity.class);
                startActivity(intent);


            }
        }).start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(Soft1614080902131CoverActivity.this,Soft1614080902131HomeActivity.class);
                startActivity(intent);
            }
        }).start();
    }
}
