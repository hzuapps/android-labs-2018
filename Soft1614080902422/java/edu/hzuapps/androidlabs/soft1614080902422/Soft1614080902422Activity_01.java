package edu.hzuapps.androidlabs.soft1614080902422;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



public class Soft1614080902422Activity_01 extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422_01);
        View t1 = (View) findViewById(R.id.textview_02);
        t1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Soft1614080902422Activity.class);
        startActivity(intent);
    }
}