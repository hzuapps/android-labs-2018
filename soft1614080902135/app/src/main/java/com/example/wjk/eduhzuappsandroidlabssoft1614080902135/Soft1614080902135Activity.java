package com.example.wjk.eduhzuappsandroidlabssoft1614080902135;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902135Activity extends AppCompatActivity {

    private Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902135);

        newButton=(Button)findViewById(R.id.button_1);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902135Activity.this,Soft1614080902135Activity2.class);
                startActivity(intent);
            }
        });
    }
}
