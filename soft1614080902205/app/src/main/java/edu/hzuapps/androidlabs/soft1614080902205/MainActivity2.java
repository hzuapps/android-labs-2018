package edu.hzuapps.androidlabs.soft1614080902205;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import static edu.hzuapps.androidlabs.soft1614080902205.R.layout.activity_soft1614080902205ctivity;

public class MainActivity2 extends AppCompatActivity {
    Button b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b6=(Button) findViewById(R.id.button5 );
        b6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

    }

}
