package com1614080901228.androidlabs.hzuapps.edu.com1614080901228;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;


public class Com1614080901228Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901228);

        textView=(TextView)findViewById(R.id.pickup.jpg);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901228Activity.this,pickupActivity.class);
                startActivity(intent);
            }
        });


    }
}
