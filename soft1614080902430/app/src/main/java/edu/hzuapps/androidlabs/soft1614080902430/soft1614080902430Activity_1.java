package edu.hzuapps.androidlabs.soft1614080902430;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class soft1614080902430Activity_1 extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902430_1);


        Button btnOpen = (Button) findViewById(R.id.button_open);

        btnOpen.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                Intent intent = new Intent(soft1614080902430Activity_1.this,soft1614080902430Activity_2.class);
                startActivity(intent);
                }
         });


    }


}
