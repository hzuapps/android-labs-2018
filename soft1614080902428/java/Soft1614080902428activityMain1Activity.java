package com.hzu.edu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902428activityMain1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft1614080902428activity_main1);
        final Activity thisActivity=this;
        Button btnHome=(Button) findViewById( R.id.btn01);
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thisActivity,Soft1614080902428activityMain2Activity.class);
                thisActivity.startActivity(intent);

            }
        });
    }
}
