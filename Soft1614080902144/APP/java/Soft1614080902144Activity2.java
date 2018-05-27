package edu.huzapps.androidlabs.soft1614080902144;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Soft1614080902144Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021442);
        Button button = (Button) findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soft1614080902144Activity2.this, Soft1614080902144Activity.class);
                startActivity(intent);
            }
        });
        Button button2 = (Button) findViewById(R.id.button_1);
        button2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Soft1614080902144Activity2.this,Soft1614080902144Activity3.class);
                startActivity(intent);
            }
        });
    }
}
