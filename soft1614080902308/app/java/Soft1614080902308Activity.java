package edu.hzuapps.androidlabs.soft1614080902308;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.admin.soft1614080902308.R;

public class Soft1614080902308Activity extends AppCompatActivity implements View.OnClickListener{

    private Button button_open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902308);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button_open=(Button)findViewById(R.id.button_open);
        button_open.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Soft1614080902308Activity.this,edu.hzuapps.androidlabs.soft1614080902308.Soft16140809023082Activity.class);
        this.startActivity(intent);
    }
}
