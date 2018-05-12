package edu.hzuapps.androidlabs.soft1614080902344;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class Soft1614080902344Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902344);

        final Activity thisActivity = this;

        Button add = (Button) findViewById(R.id.add);
        Button  delete= (Button) findViewById(R.id.delete);
        Button inquire= (Button) findViewById(R.id.inquire);
        Button change= (Button) findViewById(R.id.change);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902344Activity.this, Soft1614080902344Activity2.class);
                thisActivity.startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902344Activity.this, Soft1614080902344Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        inquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902344Activity.this, Soft1614080902344Activity.class);
                thisActivity.startActivity(intent);
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902344Activity.this, Soft1614080902344Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }

}
