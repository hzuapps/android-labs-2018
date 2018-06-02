package edu.hauapps.androidlabs.com1614080901133;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.tv.TvContentRating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Com1614080901133Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901133);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, GameActivity.class);
                thisActivity.startActivity(intent);
            }
        });



    }
}
