package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class soft1614080902129MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902129_main);

        Button button=(Button)findViewById(R.id.button_open);

        button.setOnClickListener(new View.OnClickListener(){
                @Override
            public void onClick(View view){
                    Intent intent = new Intent("Activitysoft1614080902129.class");
                    startActivity(intent);
            }
        });
    }
}
