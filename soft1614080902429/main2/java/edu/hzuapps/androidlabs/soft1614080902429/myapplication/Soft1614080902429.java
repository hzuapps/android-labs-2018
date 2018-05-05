package edu.hzuapps.androidlabs.soft1614080902429.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902429 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902429);

       final Soft1614080902429 thisActivity = this;

        TextView btnOpen =(TextView) findViewById(R.id.hwp);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });

    }
}
