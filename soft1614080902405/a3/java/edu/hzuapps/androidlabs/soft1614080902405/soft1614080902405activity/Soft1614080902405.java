package edu.hzuapps.androidlabs.soft1614080902405.soft1614080902405activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902405 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902405);

        final  Soft1614080902405 thisActivity = this;

        TextView btnOpen = (TextView) findViewById(R.id.cnm);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Soft1614080902405Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
