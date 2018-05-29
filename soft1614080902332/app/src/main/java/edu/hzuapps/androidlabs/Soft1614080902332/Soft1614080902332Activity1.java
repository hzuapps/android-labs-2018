package edu.hzuapps.androidlabs.Soft1614080902332;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import edu.hzuapps.androidlabs.Soft1614080902332.Soft1614080902332Activity1;
import edu.hzuapps.androidlabs.Soft1614080902332.R;

public class Soft1614080902332Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity1);

        final Activity thisActivity = this;

        final Button btnOpen1 = (Button) findViewById(R.id.button_open1);
        final Button btnOpen2 = (Button) findViewById(R.id.button_open2);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen1)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btnOpen2)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity3.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}
