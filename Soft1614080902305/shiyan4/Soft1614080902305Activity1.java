package edu.hzuapps.androidlabs.soft1614080902305;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.Button;
import android.app.Activity;
import java.util.ArrayList;
import java.util.List;


public class Soft1614080902305Activity1 extends AppCompatActivity {
    private ListView listview;
    private ArrayAdapter<String> adapter;
    private List<String> data;
    private ListView listView = null;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener((View.OnClickListener) this);
        setContentView(R.layout.activity_soft16140809023051);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(Soft1614080902305Activity1.this, Soft1614080902305Activity.class);
                thisActivity.startActivity(intent);
            }

        });

    }
}
