package com.example.myapplication;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import  java.io.*;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1=(Button) findViewById(R.id.sure);

        final EditText e1=(EditText) findViewById(R.id.editText1);
        final EditText e2=(EditText) findViewById(R.id.editText2);
        final EditText e3=(EditText) findViewById(R.id.editText3);
        final EditText e4=(EditText) findViewById(R.id.editText4);
        final EditText e5=(EditText) findViewById(R.id.editText5);
        final EditText e6=(EditText) findViewById(R.id.editText6);
        final File file=new File("Values.txt");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n1= e1.getText().toString();
                String n2= e2.getText().toString();
                String n3= e3.getText().toString();
                String n4= e4.getText().toString();
                String n5= e5.getText().toString();
                String n6= e6.getText().toString();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                intent.putExtra("extra_n1",n1);
                intent.putExtra("extra_n2",n2);
                intent.putExtra("extra_n3",n3);
                intent.putExtra("extra_n4",n4);
                intent.putExtra("extra_n5",n5);
                intent.putExtra("extra_n6",n6);



                startActivity(intent);
            }
        });
    }
}
