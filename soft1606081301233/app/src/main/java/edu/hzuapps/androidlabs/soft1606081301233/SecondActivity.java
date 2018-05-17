package edu.hzuapps.androidlabs.soft1606081301233;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnCancel2=(Button)findViewById(R.id.btnCancel);
        btnCancel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, Soft1606081301233Activity.class);
                startActivity(intent);
            }
        });
    }
}



