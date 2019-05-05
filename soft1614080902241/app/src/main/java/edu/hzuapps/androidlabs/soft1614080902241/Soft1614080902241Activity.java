package edu.hzuapps.androidlabs.soft1614080902241;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Soft1614080902241Activity extends AppCompatActivity {
    private TextView textView1_1;
    private Button button1_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902241);

        textView1_1=(TextView)findViewById(R.id.textView_01_01);
        button1_1=(Button) findViewById(R.id.button_01_01);

        button1_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1_1=new Intent(Soft1614080902241Activity.this,SecondActivity.class);
                startActivity(intent1_1);
            }
        });

    }
}
