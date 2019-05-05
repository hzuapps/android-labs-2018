package edu.hzuapps.androidlabs.com1614080901101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Com1614080901101Activity extends AppCompatActivity{
    public static final String FILENAME = "file_leaderboard.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901101);

        Button game = (Button) findViewById(R.id.button_open);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901101Activity.this, Activity2.class);
                startActivity(intent);
            }
        });

        Button leaderboard = (Button) findViewById(R.id.button_leaderboard);
        leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901101Activity.this, Activity3.class);
                startActivity(intent);
            }
        });

        Button background_settings = (Button) findViewById(R.id.background_settings);
        background_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901101Activity.this, Activity4.class);
                startActivity(intent);
            }
        });
    }
}
