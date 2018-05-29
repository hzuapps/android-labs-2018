package edu.hzuapps.androidlabs.soft1614080902409;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Soft1614080902409Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902409);

    }

    public void onClick(View v) {

            // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
            Intent intent = new Intent(this,tianjiaMainActivity.class);
            startActivity(intent);


    }
}
