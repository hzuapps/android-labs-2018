package edu.example.soft1614080902208;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class soft1614080902208Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView =(ImageView) findViewById(R.id.chaoshi);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(soft1614080902208Activity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

}
