package edu.hzuapps.androidlabs.com1614080901132;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class com1614080901132_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901132_2);
        ImageButton button=(ImageButton)findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com1614080901132_2Activity.this,com1614080901132secondActivity.class);
                startActivity(intent);
            }
        });
    }
}
