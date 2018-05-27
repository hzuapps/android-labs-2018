package com.example.administrator.soft1614080902129;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Soft1614080902129MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ImageButton mImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902129_main);
        mTextView=(TextView) findViewById(R.id.tv1);
        mImageButton=(ImageButton)findViewById(R.id.ibtn1);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(Soft1614080902129MainActivity.this,Soft1614080902129MainActivity3.class
                );
                startActivity(intent1);
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(Soft1614080902129MainActivity.this,Soft1614080902129MainActivity2.class);
                startActivity(intent2);
            }
        });
    }
}
