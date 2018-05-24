package com.example.dengcyu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class com1614080901124Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901124);
        final com1614080901124Activity thisActivity=this;

        Button textView1 = (Button) findViewById(R.id.button_open1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com1614080901124Activity.this, Film.class);
                startActivity(intent);
            }
        });



    }
    }

