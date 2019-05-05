package edu.hzuapps.androidlabs.soft1614080902307;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class Soft1614080902307Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902307);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902307Activity.this, Soft1614080902307Activity2.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

    }

}
