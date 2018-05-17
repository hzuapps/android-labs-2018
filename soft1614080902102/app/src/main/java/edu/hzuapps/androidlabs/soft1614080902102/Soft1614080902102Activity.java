package edu.hzuapps.androidlabs.soft1614080902102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Soft1614080902102Activity extends AppCompatActivity {
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902102);
        bt1= (Button) findViewById(R.id.button1);
        bt2= (Button) findViewById(R.id.button2);
        bt3= (Button) findViewById(R.id.button3);
        bt4= (Button) findViewById(R.id.button4);
        bt5= (Button) findViewById(R.id.button5);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902102Activity.this,Main1Activity.class);
                startActivity(intent);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902102Activity.this,Main1Activity.class);
                startActivity(intent);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902102Activity.this,Main1Activity.class);
                startActivity(intent);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902102Activity.this,Main1Activity.class);
                startActivity(intent);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902102Activity.this,Main1Activity.class);
                startActivity(intent);
            }
        });
    }
}
