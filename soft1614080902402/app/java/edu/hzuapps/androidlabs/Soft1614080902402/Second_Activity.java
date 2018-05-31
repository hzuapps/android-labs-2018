package edu.hzuapps.androidlabs.Soft1614080902402;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Second_Activity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button record1 = findViewById(R.id.record1);
        record1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Activity.this, Third_Activity.class);
                startActivity(intent);
            }
        });
        Button record2 = findViewById(R.id.record2);
        record2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Second_Activity.this, Fourth_Activity.class);
                startActivity(intent);
            }
        });
    }
}

