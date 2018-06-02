package com.example.soft1614080902140;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.w3c.dom.Text;

public class Soft1614080902140HomeActivity extends AppCompatActivity {

    private ImageView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902140_home);

        ImageView v=(ImageView) findViewById(R.id.imageView);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902140HomeActivity.this,Soft1614080902140RankActivity.class);
                startActivity(intent);
            }
        });
    }
}