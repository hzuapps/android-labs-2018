package edu.hzuapps.androidlabs.Soft1614080902332;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Soft1614080902332Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity2);

        final Activity thisActivity = this;

        final Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btn5)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity1.class);
                    thisActivity.startActivity(intent);
                }
            }
        });
    }
}
