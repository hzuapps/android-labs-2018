package com.example.dyl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivity thisActivity=this;

        TextView btnOpen = (TextView) findViewById(R.id.AD);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(thisActivity,Soft1614080902432Activity.class);
                thisActivity.startActivity(intent);


            }
        });
    }
}
