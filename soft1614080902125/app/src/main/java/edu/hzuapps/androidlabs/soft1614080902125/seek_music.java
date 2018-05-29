package edu.hzuapps.androidlabs.soft1614080902125;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class seek_music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;

        setContentView(R.layout.activity_seek_music);

        ImageView back_view_seek = findViewById(R.id.imageView_back_seek);
        super.onCreate(savedInstanceState);
        back_view_seek.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }
}
