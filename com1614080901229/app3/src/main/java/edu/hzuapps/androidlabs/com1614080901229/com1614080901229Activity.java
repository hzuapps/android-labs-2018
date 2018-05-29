package edu.hzuapps.androidlabs.com1614080901229;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class com1614080901229Activity extends AppCompatActivity {
    private TextView textView;
    private Button newbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901229);

        Button newbutton = (Button) findViewById(R.id.button3);
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com1614080901229Activity.this, com1614080901229Activity2.class);
                startActivity(intent);
            }
        });
    }
}