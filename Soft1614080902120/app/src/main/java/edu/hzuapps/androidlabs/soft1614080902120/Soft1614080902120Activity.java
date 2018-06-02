package edu.hzuapps.androidlabs.soft1614080902120;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902120Activity extends AppCompatActivity {

    Button Button1 = null;
    Button Button2 = null;
    Button Button3 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902120);

        Button1 = (Button)findViewById(R.id.button1);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902120Activity.this,Soft1614080902120Activity2.class);
                startActivity(intent);
            }
        });
        Button2 = (Button)findViewById(R.id.button2);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902120Activity.this,Soft1614080902120Activity3.class);
                startActivity(intent);
            }
        });
        Button3 = (Button)findViewById(R.id.button11);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902120Activity.this,Soft1614080902120Activity5.class);
                startActivity(intent);
            }
        });
    }
}
