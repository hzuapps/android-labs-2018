package com.example.hzu.soft1614080902406;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Soft1614080902406Activity extends AppCompatActivity {
    private Button button_01,button_02,button_03,button_04;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902406);
        button_01=(Button)findViewById(R.id.botton01);
        button_02=(Button)findViewById(R.id.botton02);
        button_03=(Button)findViewById(R.id.botton03);
        button_04=(Button)findViewById(R.id.botton04);
        button_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent01=new Intent(Soft1614080902406Activity.this,Soft1614080902406ActivityA1.class);
                startActivity(intent01);
            }
        });
        button_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent02=new Intent(Soft1614080902406Activity.this,Soft1614080902406ActivityA2.class);
                startActivity(intent02);
            }
        });
        button_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent03=new Intent(Soft1614080902406Activity.this,Soft1614080902406ActivityA3.class);
                startActivity(intent03);
            }
        });
    }

}

