package com.example.jeremy.soft1613071002205;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class 信息发布 extends AppCompatActivity {

    private Button 信息发布;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        信息发布 = (Button) findViewById(R.id.button);
        信息发布.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(信息发布.this,主界面.class);
                startActivity(intent);
            }

        });
        }
    }