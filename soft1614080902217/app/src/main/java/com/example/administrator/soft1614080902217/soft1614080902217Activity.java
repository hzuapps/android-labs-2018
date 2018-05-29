package com.example.administrator.soft1614080902217;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;



import org.w3c.dom.Text;



public class soft1614080902217Activity extends AppCompatActivity {



    private TextView textView;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soft1614080902217);



        textView=(TextView)findViewById(R.id.textview_01);



        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(soft1614080902217Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });







    }

}