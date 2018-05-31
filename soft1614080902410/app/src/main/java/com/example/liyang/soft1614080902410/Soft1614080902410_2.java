package com.example.liyang.soft1614080902410;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902410_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902410_2);

        final Activity thisActivity = this;
        Button btnHome1 = (Button) findViewById(R.id.buttom2);
        Button btnHome2 = (Button) findViewById(R.id.buttom3);
        btnHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vv) {
                Intent intent1 = new Intent(thisActivity,Soft1614080902410Activity_4.class);
                thisActivity.startActivity(intent1);
            }
        });
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intent2 = new Intent(thisActivity, Soft1614080902410Activity_3.class);
                thisActivity.startActivity(intent2);
            }
        });
    }
}
