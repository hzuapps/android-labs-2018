package edu.hzuapps.androidlabs.Soft161408092441;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Soft1614080902441MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902441_main);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this,Soft1614080902441BackActivity.class);
        startActivity(intent);

    }
}


