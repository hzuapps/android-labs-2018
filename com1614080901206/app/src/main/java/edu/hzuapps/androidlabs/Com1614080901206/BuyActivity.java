package edu.hzuapps.androidlabs.Com1614080901206;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.huishouzhan.R;

public class BuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        EditText editor1=(EditText) findViewById(R.id.edit_text1);
        SharedPreferences pref=getSharedPreferences("shangpin",MODE_PRIVATE);
        String dongxi=pref.getString("dongxi","");
        editor1.setText(dongxi);
    }
}
