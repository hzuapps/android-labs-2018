package edu.hzuapps.androidlabs.Soft1614080902424;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class Soft1614080902424Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902424_activity3);
        Button yes = (Button) findViewById(R.id.yes);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity3.this, Soft1614080902424Activity2.class);
                startActivity(intent);
            }
        });


    }
}
