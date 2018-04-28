package edu.hzuapps.androidlabs.soft1614080902326;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

import edu.hzuapps.androidlabs.soft1614080902326.Activity_2;
import edu.hzuapps.androidlabs.soft1614080902326.R;

public class Soft1614080902326Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902326);

        final Activity thisActivity = this;

        Button collect = (Button) findViewById(R.id.collectButton);
        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent ();
                    intent.setClass(Soft1614080902326Activity.this,Activity_2.class);
                    startActivity(intent);

            }
    });

}}
