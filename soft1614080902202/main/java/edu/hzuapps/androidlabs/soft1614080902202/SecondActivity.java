package edu.hzuapps.androidlabs.soft1614080902202;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final EditText editText2 = (EditText) findViewById(R.id.mb);
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        String mb = pref.getString("mima1", "");
        editText2.setText(mb);

    }

}
