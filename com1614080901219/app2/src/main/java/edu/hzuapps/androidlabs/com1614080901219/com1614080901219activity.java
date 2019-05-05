package edu.hzuapps.androidlabs.com1614080901219;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;



public class com1614080901219activity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901219activity);
        textView=(TextView)findViewById(R.id.textview_01);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(com1614080901219activity.this,com1614080901219.class);
                startActivity(intent);
            }
        });
    }
}