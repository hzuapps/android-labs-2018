package com1614080901136.androidlabs.hzuapps.edu.com1614080901136;

/**
 * Created by hzu on 2018/5/18.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;
public class Com1614080901136Activity extends AppCompatActivity  {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.YY);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901136Activity.this,Com1614080901136Activity.class);
                startActivity(intent);
            }
        }
    }
}
