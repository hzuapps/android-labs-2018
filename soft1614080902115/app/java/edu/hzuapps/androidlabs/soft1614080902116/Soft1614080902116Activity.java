package edu.hzuapps.androidlabs.soft1614080902116.soft1614080902116;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902116Activity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902116);
        button=(Button) findViewById(R.id.button2) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902116Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}
