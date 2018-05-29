package edu.hzuapps.androidlabs.com1614080901240;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.my.com1614080901240myapplication.Com1614080901240_second;
import com.example.my.com1614080901240myapplication.R;



public class Com1614080901240MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901240_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Com1614080901240_second.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnOpen_1 = (Button) findViewById(R.id.button_open1);
        btnOpen_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(thisActivity, Com1614080901240_Activity3.class);
                thisActivity.startActivity(intent1);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }

    }

