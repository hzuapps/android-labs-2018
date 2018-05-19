package edu.hzuapps.androidlabs.myapplication;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;



public class Main2Activity extends Activity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);


        final Activity thisActivity = this;


        Button btnOpen = (Button) findViewById(R.id.button_open1);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button_open1) {
                    Intent intent = new Intent(Main2Activity.this, select.class);
                    startActivity(intent);



                }
            }
        });


    }
}