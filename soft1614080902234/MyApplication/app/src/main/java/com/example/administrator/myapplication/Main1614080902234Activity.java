package com.example.administrator.myapplication;

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
import android.widget.TextView;
import org.w3c.dom.Text;

public class Main1614080902234Activity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1614080902234);

        textView=(TextView)findViewById(R.id.index);

                        textView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                                        Intent intent=new Intent(Main1614080902234Activity.this,MainActivity1.class);
                                        startActivity(intent);
                                    }
        });
    }
}
