package com.example.administrator.soft1614080902136;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Soft1614080902136Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902136);

        ImageView v = (ImageView) findViewById(R.id.view1);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902136Activity.this,Soft1614080902136Activity2.class);
                startActivity(intent);
            }
        });
    }
}
