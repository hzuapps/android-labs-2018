package edu.hzuapps.androidlabs.Com1614080901222;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.imagic.com1614080901222.R;

public class Com1614080901222Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901222);
        Button button=(Button)findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Com1614080901222Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
