package edu.hzuapps.androidlabs.com1614080901134;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class com1614080901134Activity extends AppCompatActivity {

    private TextView enterOrderFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901134);
        enterOrderFood = (TextView) findViewById(R.id.start);
        enterOrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com1614080901134Activity.this, com16140809011342Activity.class);
                startActivity(intent);
            }
        });
    }
}
