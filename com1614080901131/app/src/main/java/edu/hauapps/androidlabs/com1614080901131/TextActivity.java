package edu.hauapps.androidlabs.com1614080901131;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        final TextView tv_Text2=(TextView) findViewById(R.id.tv_text2);
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String text1=pref.getString("text1","");
        tv_Text2.setText(text1+"");
    }
}
