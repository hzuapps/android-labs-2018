package com.zhancruilenovo.eduhzuappsandroidlabssoft161408090243;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Soft1614080902343SzsjsxqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902343_szsjsxq);

        setContentView(R.layout.activity_open);
        findViewById(R.id.button_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Soft1614080902343SzsjsxqActivity.this,OpenActivity.class));
            }
        });
    }
}