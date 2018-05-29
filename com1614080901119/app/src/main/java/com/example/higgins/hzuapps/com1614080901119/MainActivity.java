package com.example.higgins.hzuapps.com1614080901119;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.higgins.hzuapps.com1614080901119.R.*;

public class MainActivity extends AppCompatActivity {

    private Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        final Activity thisActivity = this;

        btnOpen = (Button) findViewById(id.touxiang);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            private Button v;

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,PersonalSpace.class);
                thisActivity.startActivity(intent);

            }
        });

    }
}
