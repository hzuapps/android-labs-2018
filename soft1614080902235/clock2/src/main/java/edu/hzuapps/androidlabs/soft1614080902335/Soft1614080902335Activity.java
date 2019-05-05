package edu.hzuapps.androidlabs.soft1614080902335;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

public class Soft1614080902335Activity extends AppCompatActivity {

    private TextView textView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.inearlayout );

    }



    public void click(View v) {
        Intent intent=new Intent();
        intent.setClass(Soft1614080902335Activity.this,activity_secord.class);
        startActivity(intent);
    }
}


