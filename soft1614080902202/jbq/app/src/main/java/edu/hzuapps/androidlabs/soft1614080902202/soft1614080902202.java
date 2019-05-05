package edu.hzuapps.androidlabs.soft1614080902202;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class soft1614080902202 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902202);

    }


    public void click(View v) {
        Intent intent = new Intent();
        intent.setClass(soft1614080902202.this, SecondActivity.class);
        startActivity(intent);

    }
}
