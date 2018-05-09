package edu.hzuapps.androidlabs.soft1614080902241;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;



import org.w3c.dom.Text;



public class soft1614080902241Activity extends AppCompatActivity {



    private TextView textView;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soft1614080902241);


        textView=(TextView)findViewById(R.id.textview_01);


        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(soft1614080902241Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });

    }

}