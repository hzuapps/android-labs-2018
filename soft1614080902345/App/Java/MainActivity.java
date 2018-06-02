package com.example.administrator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button runbutton,run2button,jsonbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runbutton=(Button) findViewById(R.id.button1);
        run2button=(Button) findViewById(R.id.button2);
        jsonbutton=(Button) findViewById(R.id.button);
        runbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,RunActivity.class);
                startActivity(intent);
            }
        });
        run2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Run2.class);
                startActivity(intent);
            }
        });
        jsonbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Json.class);
                startActivity(intent);
            }
        });

    }
}
