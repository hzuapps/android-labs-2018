package edu.hzuapps.androidlabs.soft1614080902314;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902314Activity extends AppCompatActivity {
    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902314);

        Button button = (Button)findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902314Activity.this,Soft1614080902314Activity2.class);
                startActivity(intent);
            }
        });
    }
}

