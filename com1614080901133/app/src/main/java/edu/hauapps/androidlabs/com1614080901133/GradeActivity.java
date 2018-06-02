package edu.hauapps.androidlabs.com1614080901133;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        TextView tv_paihan=(TextView) findViewById(R.id.tv_paihan);
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String text1=pref.getString("text1","");
        tv_paihan.setText(text1);

    }
}
