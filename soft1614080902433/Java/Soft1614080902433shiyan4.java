package com.example.administrator.instergram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Soft614080902433shiyan4 extends AppCompatActivity {
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft614080902433shiyan4);
       // final Activity thisActivity=this;
        final Button up=(Button)findViewById(R.id.up);
        final Button next=(Button)findViewById(R.id.next);
        final Button commits=(Button) findViewById(R.id.commits);
        final ImageView ima =(ImageView) findViewById(R.id.ima);


        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(up)){
                    switch(i){
                        case 1:ima.setImageResource(R.drawable.moments4);i=4;break;
                        case 2:ima.setImageResource(R.drawable.moments1);i=1;break;
                        case 3:ima.setImageResource(R.drawable.moments2);i=2;break;
                        case 4:ima.setImageResource(R.drawable.moments3);i=3;break;
                    }
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(next)){
                    switch(i){
                        case 1:ima.setImageResource(R.drawable.moments4);i=2;break;
                        case 2:ima.setImageResource(R.drawable.moments1);i=3;break;
                        case 3:ima.setImageResource(R.drawable.moments2);i=4;break;
                        case 4:ima.setImageResource(R.drawable.moments3);i=1;break;
                    }
                }
            }
        });
        commits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(commits)){
                    Intent intent = new Intent (Soft614080902433shiyan4.this,Soft1614080902433shiyan4commit.class);
                    startActivity(intent);
                }
            }
        });

    }
}
