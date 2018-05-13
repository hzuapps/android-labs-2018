package edu.hzuapps.androidlabs.soft1614080902223;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class soft1614080902223BMainActivity extends AppCompatActivity {

    private ImageButton tp01_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902223_bmain);
        tp01_01=(ImageButton)findViewById(R.id.tp01_01);
        tp01_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902223BMainActivity.this,soft1614080902223CMainActivity.class);
                startActivity(intent);
            }
        });
    }

}
