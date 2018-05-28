package edu.hzuapps.androidlabs.soft1614080902335;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class thirdactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);
        final EditText editText2 = (EditText) findViewById(R.id.mima);
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        String mima = pref.getString("mima1", "");
        editText2.setText(mima);
    }
    }
