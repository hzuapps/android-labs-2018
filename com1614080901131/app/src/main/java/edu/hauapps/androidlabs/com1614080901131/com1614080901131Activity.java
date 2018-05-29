package edu.hauapps.androidlabs.com1614080901131;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class com1614080901131Activity extends AppCompatActivity {
    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901131);


        start=findViewById(R.id.bt_start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com1614080901131Activity.this,SecondActivity.class);
                startActivities(new Intent[]{intent});
            }
        });
    }
}
