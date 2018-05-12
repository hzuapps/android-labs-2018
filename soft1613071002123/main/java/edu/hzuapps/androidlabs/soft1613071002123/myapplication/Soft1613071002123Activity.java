package edu.hzuapps.androidlabs.soft1613071002123.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.soft1613071002123.myapplication.R;

public class Soft1613071002123Activity extends AppCompatActivity{

    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1613071002123);
        login = (Button)findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Soft1613071002123Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


}
