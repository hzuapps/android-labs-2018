package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShowSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_search);

        Intent intent=getIntent();
        String string1=intent.getStringExtra("name");
        String string2=intent.getStringExtra("description");

        TextView textName=(TextView)findViewById(R.id.nameShow);
        textName.setText(string1);
        TextView textDescription=(TextView)findViewById(R.id.descriptionShow);
        textDescription.setText(string2);
    }
}