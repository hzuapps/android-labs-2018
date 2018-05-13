package edu.hzuapps.androidlabs.Soft1614080902424;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Soft1614080902424Activity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902424_activity2);
        Button send = (Button) findViewById(R.id.send);

       send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity3.class);
                startActivity(intent);
            }
        });
       Button get = (Button) findViewById(R.id.get);

       get.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity4.class);
                startActivity(intent);
            }
        });
        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity5.class);
                startActivity(intent);
            }
        });


    }
}
