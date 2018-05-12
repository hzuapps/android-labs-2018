package com.example.asus.cet_4cet_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902122MainActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902122_main);
        textView=(TextView)findViewById(R.id.textview_01);



        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(Soft1614080902122MainActivity.this,SecondActivity.class);

                startActivity(intent);

            }

        });
    }
}
