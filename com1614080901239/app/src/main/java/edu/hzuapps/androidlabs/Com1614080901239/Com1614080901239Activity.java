package edu.hzuapps.androidlabs.Com1614080901239;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.Com1614080901239.*;


public class Com1614080901239Activity extends AppCompatActivity {

    Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Button button = (Button)findViewById(R.id.button_equal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Com1614080901239Activity.this,labs3Activity.class);
                startActivity(intent);
            }
        });
    }
}