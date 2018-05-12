package edu.hzuapps.androidlabs.com1614080901134;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class com1614080901134Activity extends AppCompatActivity {

    private TextView enterOrderFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901134);
        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com1614080901134Activity.this, com16140809011342Activity.class);
                startActivity(intent);
            }
        });
    }
}

