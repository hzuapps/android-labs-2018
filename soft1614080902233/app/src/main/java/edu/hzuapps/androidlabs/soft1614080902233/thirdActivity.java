package edu.hzuapps.androidlabs.soft1614080902233;

import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class thirdActivity extends AppCompatActivity {
    private Button button_cancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ((Button) findViewById(R.id.button_cancle)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish();
            }
        });

        ((Button) findViewById(R.id.button_int)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tx = (EditText) findViewById(R.id.edittext_input);
                String s = tx.getText().toString();

                Intent data1 = new Intent();
                data1.putExtra("data1", s);
                setResult(2,data1);
                finish();
            }
        });
        ((Button) findViewById(R.id.button_out)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tx = (EditText) findViewById(R.id.edittext_input);
                String s = tx.getText().toString();

                Intent data2 = new Intent();
                data2.putExtra("data2", s);
                setResult(3,data2);
                finish();
            }
        });
     }
}
