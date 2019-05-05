package edu.hzuapps.androidlabs.soft1614080902445;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902445MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902445_main);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this,Soft1614080902445Activity.class);
        startActivity(intent);

    }
}
