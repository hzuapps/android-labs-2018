package edu.hzuapps.androidlabs.com1614080901241;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;



import org.w3c.dom.Text;



public class com1614080901241Activity extends AppCompatActivity {



    private TextView textView;




    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_com1614080901241);


        textView=(TextView)findViewById(R.id.textview_01);


        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(com1614080901241Activity.this,MainActivity.class);

                startActivity(intent);

            }

        });

    }

}
