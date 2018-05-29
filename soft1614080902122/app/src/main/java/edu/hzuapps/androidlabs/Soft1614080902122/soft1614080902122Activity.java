package edu.hzuapps.androidlabs.Soft1614080902122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

public class soft1614080902122Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902122);
        textView=(TextView)findViewById(R.id.textview_01);



        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(soft1614080902122Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });
    }
}
