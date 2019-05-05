package edu.hzuapps.androidlabs.Soft161408092441;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Soft1614080902441BackActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902441_back);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(this,Soft1614080902441DownLoad01Activity.class);
        startActivity(intent);

    }
}