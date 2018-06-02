package edu.hzuapps.androidlabs.soft1614080902202;

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

import java.text.SimpleDateFormat;
import java.util.Date;

public class soft1614080902202 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902202);

        final EditText editText=(EditText) findViewById(R.id.mima1);


        Button button=(Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mima1=editText.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("mima1",mima1);

                editor.apply();
                Toast.makeText(soft1614080902202.this,"数据已提交！",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void click(View view) {
        Intent intent = new Intent();
        intent.setClass(soft1614080902202.this, SecondActivity.class);
        startActivity(intent);
    }

}
