package edu.hzuapps.androidlabs.soft1614080902240;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902240Activity extends AppCompatActivity {


    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902240);

        mButton = (Button)findViewById(R.id.button2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(mButton)) {
                    // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                    Intent intent = new Intent(Soft1614080902240Activity.this,Soft1614080902240Activity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}
