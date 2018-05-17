package edu.hzuapps.androidlabs.com1613090502214;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Com1613090502214Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1613090502214);
        textView=(TextView)findViewById(R.id.button);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Com1613090502214Activity.this,SecondActivity.class);
                startActivity(intent);
            }});
    }

}

