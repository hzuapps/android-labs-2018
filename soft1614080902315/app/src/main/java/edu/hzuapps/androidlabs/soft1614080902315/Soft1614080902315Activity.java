package edu.hzuapps.androidlabs.soft1614080902315;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Soft1614080902315Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902315_activity);
        ImageView button = (ImageView) findViewById(R.id.imageView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soft1614080902315Activity.this, rednews.class);
                startActivity(intent);
            }
        });

    }}
/*
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        new View.OnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soft1614080902315Activity.this, rednews.class);
                startActivity(intent);
            }
        });


    }}*/