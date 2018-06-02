package edu.hzuapps.androidlabs.soft1614080902331;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class saierhaoin extends AppCompatActivity{

    private Button buttonpk;
    private Button buttonzc;
    private Button buttonjc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saierhaoin);

        buttonpk = findViewById(R.id.button1);
        buttonpk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(saierhaoin.this,edu.hzuapps.androidlabs.soft1614080902331.saierhaopk.class);
                startActivity(intent);
            }
        });

        buttonzc = findViewById(R.id.button2);
        buttonzc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(saierhaoin.this,edu.hzuapps.androidlabs.soft1614080902331.saierhaozc.class);
                startActivity(intent);
            }
        });

        buttonjc = findViewById(R.id.button3);
        buttonjc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(saierhaoin.this,edu.hzuapps.androidlabs.soft1614080902331.json.class);
                startActivity(intent);
            }
        });
    }

}