package edu.hzuapps.androidlabs.soft1614080902223;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Soft1614080902223MainActivity_1 extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902223_main_1);
        textView=(TextView)findViewById(R.id.textview_01);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902223MainActivity_1.this,Soft1614080902233Activity_2.class);
                startActivity(intent);
            }
        });
    }
}
