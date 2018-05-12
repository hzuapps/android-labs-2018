package com.example.administrator.soft1614080902217;

import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {


    private Button xiazai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        xiazai=(Button)findViewById(R.id.button_xiazai);
        xiazai.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                                          startActivity(intent);
                                      }
                                  }

        );

    }

}
