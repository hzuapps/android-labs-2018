package edu.hzuapps.androidlabs.soft1614080902422;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902422Activity_02 extends AppCompatActivity implements View.OnClickListener {
    public Intent i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422_02);
        Button bt1 = (Button) findViewById(R.id.m_1);
        Button bt2 = (Button) findViewById(R.id.m_2);
        Button bt3 = (Button) findViewById(R.id.m_3);
        Button bt4 = (Button) findViewById(R.id.m_4);
        Button bt5 = (Button) findViewById(R.id.m_5);
        Button bt6 = (Button) findViewById(R.id.m_6);
        Button bt7 = (Button) findViewById(R.id.m_7);
        Button bt8 = (Button) findViewById(R.id.m_8);
        Button bt9 = (Button) findViewById(R.id.m_9);
        Button bt10 = (Button) findViewById(R.id.m_10);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt10.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m_1:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_2:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_3:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_4:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_5:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_6:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_7:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_8:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_9:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
            case R.id.m_10:
                i1 = new Intent(this, Soft1614080902422Activity.class);
                startActivity(i1);
                break;
        }
    }
}