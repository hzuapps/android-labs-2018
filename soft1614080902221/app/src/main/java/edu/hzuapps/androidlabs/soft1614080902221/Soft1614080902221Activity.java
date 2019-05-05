package edu.hzuapps.androidlabs.soft1614080902221;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class Soft1614080902221Activity extends AppCompatActivity {

    private Button startButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity_soft1614080902221);

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soft1614080902221Activity.this, Activity2.class);
                startActivity(intent);

            }
        });


    }
}
