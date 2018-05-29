package edu.hzuapps.androidlabs.soft1614080902127;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;



public class Soft1614080902127Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902127);
    }
    public void onClick(View view)
    {
        startActivity(new Intent(".SecondActivity"));
    }

}
