package edu.hzuapps.androidlabs.soft1614080902209;

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


public class Soft1614080902209Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902209);

    }

    public void click(View v) {
        Intent intent=new Intent();
        intent.setClass(Soft1614080902209Activity.this,SecondActivity.class);
        startActivity(intent);
    }
}
