package com.example.liyang.soft1614080902410;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Soft161408092410Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft161408092410);

        final Activity thisActivity = this;
        Button btnHome = (Button) findViewById(R.id.buttom1);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Soft1614080902410_2.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}