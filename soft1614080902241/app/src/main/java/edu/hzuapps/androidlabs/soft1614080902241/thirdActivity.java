package edu.hzuapps.androidlabs.soft1614080902241;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class thirdActivity extends AppCompatActivity {
    private Button button1_3;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        button1_3=(Button)findViewById(R.id.button01_02) ;

        button1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1_3=new Intent(thirdActivity.this,SecondActivity.class);
                startActivity(intent1_3);
            }
        });


    }

}
