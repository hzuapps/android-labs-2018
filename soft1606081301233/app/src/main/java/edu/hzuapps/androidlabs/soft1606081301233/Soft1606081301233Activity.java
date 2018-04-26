package edu.hzuapps.androidlabs.soft1606081301233;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Soft1606081301233Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1606081301233);
        Button loginBtn = (Button) findViewById(R.id.btn_Login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1606081301233Activity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}