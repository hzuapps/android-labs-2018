package edu.hzuapps.androidlabs.Soft1614080902435;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Soft1614080902435 extends AppCompatActivity implements View.OnClickListener {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902435);
        Log.d("dd","123");
        b = (Button)findViewById(R.id.open);
        b.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view==b){
            Intent intent = new Intent();
            Log.d("dd","123");
            intent.setClass(Soft1614080902435.this,jiemianerActivity.class);
            startActivity(intent);
        }
    }

}
