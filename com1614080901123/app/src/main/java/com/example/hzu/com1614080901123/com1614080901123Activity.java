package com.example.hzu.com1614080901123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class com1614080901123Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901123);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                Intent intent = new Intent(com1614080901123Activity.this, secondActivity.class);
                startActivity(intent);
            }

        });

        Button btn1 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                Intent intent = new Intent(com1614080901123Activity.this, thirdActivity.class);
                startActivity(intent);
            }

        });
    }
}

