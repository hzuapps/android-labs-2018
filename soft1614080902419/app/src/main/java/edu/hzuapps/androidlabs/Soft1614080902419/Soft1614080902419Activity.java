package edu.hzuapps.androidlabs.Soft1614080902419;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902419Activity extends AppCompatActivity implements OnClickListener {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902419_activity);
        b = (Button)findViewById(R.id.open_cal);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==b){
            Intent intent = new Intent();
            intent.setClass(Soft1614080902419Activity.this,Second_Activity.class);
            startActivity(intent);
        }
    }
}
