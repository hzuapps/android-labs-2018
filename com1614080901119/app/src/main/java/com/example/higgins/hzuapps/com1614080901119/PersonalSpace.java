package com.example.higgins.hzuapps.com1614080901119;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PersonalSpace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.space_personal);

        final Activity thisActivity = this;

        Button btn = (Button)findViewById(R.id.summitevents);
        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                LinearLayoutCompat ll = (LinearLayoutCompat)findViewById(R.id.myLayout);
                TextView mTextView = new TextView(thisActivity);
                mTextView.setText("做课程设计");
                ll.addView(mTextView);


            }
        });
    }
}
