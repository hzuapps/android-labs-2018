package edu.hzuapps.androidlabs.com1614080901139;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView user=(TextView) findViewById(R.id.user);
        SharedPreferences pref=getSharedPreferences("user",MODE_PRIVATE);
        String userName=pref.getString("userName","");
        user.setText(userName);
        TextView password=(TextView) findViewById(R.id.password);
        String passWord=pref.getString("passWord","");
        password.setText(passWord);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,jsonActivity.class);
                startActivity(intent);
            }
        });

    }
}
