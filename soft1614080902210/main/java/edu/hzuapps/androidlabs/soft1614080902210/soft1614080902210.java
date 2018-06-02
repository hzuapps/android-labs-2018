package edu.hzuapps.androidlabs.soft1614080902210;


import android.content.Context;

import android.content.Intent;

import android.content.SharedPreferences;

import android.os.Bundle;

import android.os.Environment;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

import android.widget.Toast;

public class soft1614080902210 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902210);



        final EditText editText=(EditText) findViewById(R.id.chicun);





        Button button=(Button)findViewById(R.id.button10);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String chicun=editText.getText().toString();

                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();

                editor.putString("chicun",chicun);



                editor.apply();

                Toast.makeText(soft1614080902210.this,"数据已提交！",Toast.LENGTH_SHORT).show();

            }

        });




    }



    public void click(View view) {

        Intent intent = new Intent();

        intent.setClass(soft1614080902210.this, SecondActivity.class);

        startActivity(intent);

    }


}