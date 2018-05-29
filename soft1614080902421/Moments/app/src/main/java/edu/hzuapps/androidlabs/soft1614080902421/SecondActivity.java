package edu.hzuapps.androidlabs.soft1614080902421;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondactivity);
        ImageButton button = (ImageButton) findViewById(R.id.button2);//返回开始界面
        ImageButton button1 =(ImageButton) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                    Intent intent = new Intent(SecondActivity.this,Moments.class);
                    startActivity(intent);
                }

        });
        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }

        });

    }

}