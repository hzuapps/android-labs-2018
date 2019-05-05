package edu.hzuapps.androidlabs.Com1614080901130;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
//import android.widget.TextView;


public class Anni extends Activity {

//    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anni_home);

        final Activity thisActivity = this;


        Button btnOpen =  findViewById(R.id.home_button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,Show.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}