package edu.hzuapps.androidlabs.Com1614080901130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Show extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anni_show);
        final Activity thisActivity = this;
        Button btnOpen =  findViewById(R.id.share_button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,Share.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
