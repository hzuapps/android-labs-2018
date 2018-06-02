package edu.hzuapps.androidlabs.soft1614080902335;

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

public class activity_secord extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout);


            final EditText editText = (EditText) findViewById(R.id.mima1);


            Button button = (Button) findViewById(R.id.button4);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String mima1 = editText.getText().toString();
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    editor.putString("mima1", mima1);

                    editor.apply();
                    Toast.makeText(activity_secord.this, "时间已修改", Toast.LENGTH_SHORT).show();
                }
            });
        }
            public void click2 (View view){
                Intent intent = new Intent();
                intent.setClass(activity_secord.this, thirdactivity.class);
                startActivity(intent);



        }
}

