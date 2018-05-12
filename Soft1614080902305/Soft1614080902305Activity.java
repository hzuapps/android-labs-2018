package edu.hzuapps.androidlabs.soft1614080902305;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.*;
public class Soft1614080902305Activity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener((View.OnClickListener) this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902305);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Activity tupian= new Soft1614080902305Activity1();
                Intent intent = new Intent(tupian,Soft1614080902305Activity1.class);
                tupian.startActivity(intent);
            }

        });
    }
}

