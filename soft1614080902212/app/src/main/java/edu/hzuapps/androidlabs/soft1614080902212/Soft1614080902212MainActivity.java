package edu.hzuapps.androidlabs.soft1614080902212;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Soft1614080902212MainActivity extends AppCompatActivity {

    private Button Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902212_main);

        Button=(Button)findViewById(R.id.button1);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902212MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
