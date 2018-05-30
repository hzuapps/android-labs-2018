package edu.hzuapps.androidlabs.soft1614080902241;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class thirdActivity extends AppCompatActivity {
    private Button  button_cancle,button_hold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button_cancle= (Button) findViewById(R.id.button_cancle);
        button_hold = (Button) findViewById(R.id.button_hold);

        button_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
         button_hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.widget.EditText tx = (EditText) findViewById(R.id.edittext_xiaofei);
                String s = tx.getText().toString();

                Intent data = new Intent();
                data.putExtra("data", s);
                setResult(2,data);
                finish();
            }
        });
    }

}
