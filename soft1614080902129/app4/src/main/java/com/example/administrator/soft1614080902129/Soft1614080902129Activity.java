package com.example.administrator.soft1614080902129;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902129Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902129);
        textView=(TextView)findViewById(R.id.button);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902129Activity.this,SecondActivity.class);
                startActivity(intent);
            }});
    }

}

