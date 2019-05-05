package com.example.a76027.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft16140809021282MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitty_soft1614080902128_main2);
        textView=(TextView)findViewById(R.id.my_button1);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Soft16140809021282MainActivity.this,Soft1614080902128Activity2.class);
                startActivity(intent);
            }});
        textView=(TextView)findViewById(R.id.my_button4);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Soft16140809021282MainActivity.this,LoadActivity.class);
                startActivity(intent);
            }});
    }

}
