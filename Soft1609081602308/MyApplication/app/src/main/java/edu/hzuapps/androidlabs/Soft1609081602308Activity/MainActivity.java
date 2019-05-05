package edu.hzuapps.androidlabs.Soft1609081602308Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity thisActivity=this;
        Button button01=(Button)findViewById(R.id.button_01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(thisActivity,SecondActivity.class);
                thisActivity.startActivity(intent);
            }
        });

    }
}
