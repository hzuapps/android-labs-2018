package com.example.soft1614080902208;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GetStaffActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_get_staff);
                TextView UserName=(TextView) findViewById(R.id.UserName);
                SharedPreferences sharedPreferences = getSharedPreferences("jc", Context.MODE_PRIVATE);
                String userName=sharedPreferences.getString("username","");
                UserName.setText(userName);
            }
    }