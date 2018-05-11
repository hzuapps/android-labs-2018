package edu.hzuapps.androidlabs.soft1614080902344;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class Soft1614080902344Activity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809023442);
        final Activity thisActivity = this;
        Button query = (Button) findViewById(R.id.query);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902344Activity2.this, Soft1614080902344Activity.class);//这里应另用另一个activity，为方便先不做
                thisActivity.startActivity(intent);
            }
        });
        Button quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902344Activity2.this, Soft1614080902344Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }

}
