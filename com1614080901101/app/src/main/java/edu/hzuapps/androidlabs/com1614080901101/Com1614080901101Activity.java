package edu.hzuapps.androidlabs.com1614080901101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Com1614080901101Activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901101);

        Button textView1 = (Button) findViewById(R.id.button_open);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901101Activity.this, Activity2.class);
                startActivity(intent);
            }
        });

        Button textView2 = (Button) findViewById(R.id.button_leaderboard);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901101Activity.this, Activity3.class);
                startActivity(intent);
            }
        });

    }
}