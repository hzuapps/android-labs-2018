package com.example.gwl20.soft1614080902204;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class soft1614080902204BActivity extends AppCompatActivity {

    private Button bu,jiandao,shitou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902204_b);
        bu=(Button)findViewById(R.id.button_bu);
        jiandao=(Button)findViewById(R.id.button_jiandao);
        shitou=(Button)findViewById(R.id.button_shitou);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204BActivity.this,soft1614080902204CActivity.class);
                startActivity(intent);
            }
        });
        jiandao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204BActivity.this,soft1614080902204CActivity.class);
                startActivity(intent);
            }
        });
        shitou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902204BActivity.this,soft1614080902204CActivity.class);
                startActivity(intent);
            }
        });
    }
}
