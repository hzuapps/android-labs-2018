package edu.hzuapps.androidlabs.soft1614080902442;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.soft1614080902442.soft1614080902442main1Activity;
import edu.hzuapps.androidlabs.soft1614080902442.R;

public class soft1614080902442main1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902442main1);

        final Activity thisActivity = this;
        final Button btnOpen1 = (Button) findViewById(R.id.button_open1);
        final Button btnOpen2 = (Button) findViewById(R.id.button_open2);

        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen1)) {
                    Intent intent = new Intent(thisActivity,soft1614080902442main2Activity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen2)) {
                    Intent intent = new Intent(thisActivity,soft1614080902442main3Activity.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
    }
}
