package com.example.hasee.soft1614080902225;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NO2MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no2_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Soft1614080902225MainActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

    }
}
