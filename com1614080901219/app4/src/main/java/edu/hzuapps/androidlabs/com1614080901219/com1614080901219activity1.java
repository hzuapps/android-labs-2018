package edu.hzuapps.androidlabs.com1614080901219;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class com1614080901219activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219activity1);

        final Activity thisActivity = this;

        final Button button1 = (Button) findViewById(R.id.button_1);
        final Button button2 = (Button) findViewById(R.id.button_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(button1)) {
                    Intent intent = new Intent(thisActivity,com1614080901219activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(button2)) {
                    Intent intent = new Intent(thisActivity,com1614080901219activity3.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}