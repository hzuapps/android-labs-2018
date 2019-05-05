package edu.hzuapps.android.labs.Com1614080901141;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.cnt.ball.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button button3 = (Button)findViewById(R.id.button_2);
        Button buttont=(Button)findViewById(R.id.button_t);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,FourActivity.class);
                startActivity(intent);
            }
        });
        buttont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this,FifthActivity.class);
                startActivity(intent);
            }
        });
    }
}
