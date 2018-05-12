package edu.hzuapps.androidlabs.Soft1614080902312;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import edu.hzuapps.androidlabs.Soft1614080902312.*;

public class Soft1614080902312Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902312);

        final Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902312Activity.this,saolei.class);
                thisActivity.startActivity(intent);

            }
        });

    }
}
