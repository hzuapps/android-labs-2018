package edu.hzuapps.androidlabs.com1614080901139;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    }
}
