package edu.hzuapps.androidlabs.soft1614080902211;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void onClick(View v) {

        if(v.equals(R.layout.activity_soft1614080902211)) {
            // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
            Intent intent = new Intent("edu.hzuapps.androidlabs.soft1614080902211.Soft1614080902211");
            startActivity(intent);

        }
    }
}
