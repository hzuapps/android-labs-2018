package com.example.administrator.soft1614080902217;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    private Button bofang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
       bofang=(Button)findViewById(R.id.button_bofang);
       bofang.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent=new Intent(ThirdActivity.this,FourthActivity.class);
                                          startActivity(intent);
                                      }
                                  }

        );
    }

}
