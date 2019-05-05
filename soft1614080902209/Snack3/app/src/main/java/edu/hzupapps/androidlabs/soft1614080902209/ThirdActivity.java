package edu.hzuapps.androidlabs.soft1614080902209;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TextView UserName=(TextView) findViewById(R.id.UserName);
        SharedPreferences sharedPreferences = getSharedPreferences("jc", Context.MODE_PRIVATE);
        String userName=sharedPreferences.getString("username","");
        UserName.setText(userName);
    }
}