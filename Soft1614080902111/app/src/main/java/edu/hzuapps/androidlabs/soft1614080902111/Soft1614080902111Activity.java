package edu.hzuapps.androidlabs.soft1614080902111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902111Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902111);
                android.widget.Button button1=(android.widget.Button)findViewById(R.id.buttonl);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902111Activity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        android.widget.Button button2=(android.widget.Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902111Activity.this,beijing.class);
                startActivity(intent);
            }
        });
    }
}
