package edu.hzuapps.androidlabs.soft1614080902422;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902422Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902422);
        Button bt1 = (Button) findViewById(R.id.b1);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,Soft1614080902422Activity_01.class);
        startActivity(intent);
    }
}


