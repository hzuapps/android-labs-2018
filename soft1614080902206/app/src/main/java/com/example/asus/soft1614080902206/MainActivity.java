package com.example.asus.soft1614080902206;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.asus.soft1614080902206.MESSAGE";
    protected void onCreate(Bundle savedInstanceState) {
        String str1="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity thisActivity = this;
        Button btnOpen = (Button) findViewById(R.id.button_open);
              btnOpen.setOnClickListener(new View.OnClickListener() {




           public void onClick(View view) {
                               Intent intent = new Intent(thisActivity, message.class);
                               thisActivity.startActivity(intent);
                                  }
       });

    }


}