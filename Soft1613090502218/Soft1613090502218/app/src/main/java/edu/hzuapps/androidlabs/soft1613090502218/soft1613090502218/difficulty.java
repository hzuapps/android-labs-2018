package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class difficulty extends Activity {
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        button1=(Button)findViewById(R.id.normal);
        button2=(Button)findViewById(R.id.hard);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(difficulty.this,Playing.class);
                startActivity(intent1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(difficulty.this,Playing.class);
                startActivity(intent2);
            }
        });
    }
}
