package edu.hzuapps.androidlabs.soft1614080902412;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class soft1614080902412main1Activity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902412main1);
        Button bt1 = (Button)findViewById(R.id.button);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,soft1614080902412main2Activity.class);
        startActivity(intent);
    }
}
