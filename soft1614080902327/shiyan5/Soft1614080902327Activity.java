package edu.hzuapps.androidlabs.soft1614080902327;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.*;
public class Soft1614080902327Activity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902327);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener((View.OnClickListener) this);
        Intent intent = new Intent(Soft1614080902327Activity.this, Soft1614080902327Activity1.class);
        thisActivity.startActivity(intent);
    }
}

