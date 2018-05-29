package com1614080901225.androidlabs.hzuapps.edu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class TaskbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskbar);
        setTitle("任务栏");
    }
}
