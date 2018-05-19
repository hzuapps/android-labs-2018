package edu.hzuapps.androidlabs.soft1614080902218;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;



public class soft1614080902218activity extends AppCompatActivity {

    private ImageButton pai1, pai2;
    private Button wendu;
    private Button shidu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902218activity);

        pai1 = (ImageButton) findViewById(R.id.wendu);
        pai2 = (ImageButton) findViewById(R.id.shidu);

        pai1.setOnClickListener(new View.OnClickListener() {
            @Override
         public void onClick(View v) {
                                     Intent intent=new Intent(soft1614080902218activity.this,SecordActivity.class);
                                    startActivity(intent);
                              }
        });
        pai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(soft1614080902218activity.this,ThirdActivity.class);

                startActivity(intent);
            }
        });
    }
}
