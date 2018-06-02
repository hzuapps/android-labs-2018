package edu.hzuapps.androidlabs.soft1614080902240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902240Activity extends AppCompatActivity {


    Button Button2;
    Button Button3;
    Button Button4;
    Button Button5;
    Button Button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902240);

        Button2 = (Button)findViewById(R.id.button2);
        Button3 = (Button)findViewById(R.id.button3);
        Button4 = (Button)findViewById(R.id.button4);
        Button5 = (Button)findViewById(R.id.button5);

        Button6 = (Button)findViewById(R.id.button6);


        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(Button2)) {
                    // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                    Intent intent = new Intent(Soft1614080902240Activity.this,Soft1614080902240Activity2.class);
                    startActivity(intent);
                }
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(Button3)) {
                    // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                    Intent intent = new Intent(Soft1614080902240Activity.this,Soft1614080902240Activity3.class);
                    startActivity(intent);
                }
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(Button4)) {
                    // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                    Intent intent = new Intent(Soft1614080902240Activity.this,Soft1614080902240Activity4.class);
                    startActivity(intent);
                }
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(Button5)) {
                    // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                    Intent intent = new Intent(Soft1614080902240Activity.this,Soft1614080902240Activity5.class);
                    startActivity(intent);
                }
            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(Button6)) {
                    // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                    Intent intent = new Intent(Soft1614080902240Activity.this,Soft1614080902240Activity6.class);
                    startActivity(intent);
                }
            }
        });

    }
}
