package edu.hzuapps.android.labs.Com1614080901141;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cnt.ball.R;

public class Com1614080901141Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901141);
        Button button = (Button)findViewById(R.id.login_up);
        Button button1 = (Button)findViewById(R.id.login_in);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901141Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901141Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
