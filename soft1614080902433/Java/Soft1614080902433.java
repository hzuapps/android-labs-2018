package com.example.administrator.instergram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class Soft1614080902433 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902433);
        final Activity thisActivity=this;
        final Button start=(Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(start)){
                    Intent intent = new Intent (Soft1614080902433.this,Soft614080902433shiyan4.class);
                    startActivity(intent);
                }
            }
        });
    }

}
