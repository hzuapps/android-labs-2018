package com.example.hasee.soft1612070501328;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Soft1612070501328Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1612070501328);

        findViewById(R.id.btnStarAndroidActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(Soft1612070501328Activity.this,SecondActivity.class)});
            }
        });

    }
}
