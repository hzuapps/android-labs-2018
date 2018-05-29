package com.example.hao.soft1614080902145;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button2= findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Main2Activity.this,Message_Activity.class);
                startActivity(intent);
            }
        });

        Button button3= findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Main2Activity.this,Contact_Activity.class);
                startActivity(intent);
            }
        });

        Button button4= findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Main2Activity.this,Personal_Activity.class);
                startActivity(intent);
            }
        });

        Button button5= findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Main2Activity.this,Wallpaper_Activity.class);
                startActivity(intent);
            }
        });
    }
}
