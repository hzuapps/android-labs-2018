package edu.hzuapps.androidlabs.com1614080901241;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    private ImageButton pai1, pai2, pai3;
    private Button mImage01;
    private Button mImage02;
    private Button mImage03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        pai1 = (ImageButton) findViewById(R.id.me01);
        pai2 = (ImageButton) findViewById(R.id.me02);
        pai3 = (ImageButton) findViewById(R.id.me03);
        pai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);

                startActivity(intent);
            }
        });

        pai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

        pai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

    }

}