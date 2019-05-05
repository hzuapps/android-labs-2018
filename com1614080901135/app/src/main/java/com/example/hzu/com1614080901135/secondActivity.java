package com.example.hzu.com1614080901135;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                Intent intent = new Intent(secondActivity.this, thirdActivity.class);
                startActivity(intent);
            }

        });
    }
}
