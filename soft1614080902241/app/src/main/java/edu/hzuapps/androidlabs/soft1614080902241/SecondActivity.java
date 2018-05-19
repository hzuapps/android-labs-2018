package edu.hzuapps.androidlabs.soft1614080902241;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    private ImageButton button1_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1_2=(ImageButton) findViewById(R.id.imagebutton_01_02);

        button1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1_2=new Intent(SecondActivity.this,thirdActivity.class);
                startActivity(intent1_2);
            }
        });
    }

}
