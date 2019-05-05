package edu.hzuapps.androidlabs.Soft1614080902330;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Main2Activity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        Button btnOpen1 = (Button) findViewById(R.id.button2);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Main3Activity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

       Button btn2 = (Button) findViewById(R.id.button11);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });

    }
}
