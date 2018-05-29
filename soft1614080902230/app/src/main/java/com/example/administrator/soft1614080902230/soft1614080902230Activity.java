package com.example.administrator.soft1614080902230;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.*;
import android.widget.TextView;
import org.w3c.dom.Text;

public class soft1614080902230Activity extends AppCompatActivity {

    private Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902230);

        Button=(Button)findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902230Activity.this,secondActivity.class);
                startActivity(intent);
            }
        });



    }
}
