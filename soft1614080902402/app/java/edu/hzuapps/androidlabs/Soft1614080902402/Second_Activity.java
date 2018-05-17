package edu.hzuapps.androidlabs.Soft1614080902402;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Second_Activity extends AppCompatActivity {
    Button[] id = new Button[6];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        id[0] = findViewById(R.id.button1);
        id[1] = findViewById(R.id.button2);
        id[2] = findViewById(R.id.button3);
        id[3] = findViewById(R.id.button4);
        id[4] = findViewById(R.id.button5);
        id[5] = findViewById(R.id.button6);
        android.support.constraint.ConstraintLayout cl=findViewById(R.id.cl);

    }
}
