package edu.hzuapps.androidlabs.soft1614080902233;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class thirdActivity extends AppCompatActivity {
    private Button button3_1,button3_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button3_1=(Button)findViewById(R.id.button_03_01);
        button3_2=(Button)findViewById(R.id.button_03_02);
        button3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3_1=new Intent(thirdActivity.this,SecondActivity.class);
                startActivity(intent3_1);
            }
        });
        button3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3_2=new Intent(thirdActivity.this,SecondActivity.class);
                startActivity(intent3_2);
            }
        });
    }

}
