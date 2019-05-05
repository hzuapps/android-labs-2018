package edu.hzuapps.androidlabs.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity thisActivity=this;
        Button btnopen1=(Button) findViewById(R.id.button1);
        btnopen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button1){
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
    }
