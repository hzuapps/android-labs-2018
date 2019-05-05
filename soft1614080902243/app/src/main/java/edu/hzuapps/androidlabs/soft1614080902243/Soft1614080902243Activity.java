package edu.hzuapps.androidlabs.soft1614080902243;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Soft1614080902243Activity extends AppCompatActivity {

    Button button1 = null;
    Button button2 = null;
    Button button3=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902243);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902243Activity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });

        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902243Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });




    }

    }
