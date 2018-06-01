package com.example.can.soft1614080902116;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Soft161408090211602Activity extends AppCompatActivity {
Button button;
Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft161408090211602);
        button=(Button) findViewById(R.id.button3) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft161408090211602Activity.this,Soft161408090211603Activity.class);
                startActivity(intent);
            }
        });
        button1=(Button) findViewById(R.id.button2) ;
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft161408090211602Activity.this,Soft161408090211604Activity.class);
                startActivity(intent);
            }
        });
    }

}
