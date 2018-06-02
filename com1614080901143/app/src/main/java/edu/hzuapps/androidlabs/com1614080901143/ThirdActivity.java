package edu.hzuapps.androidlabs.com1614080901143;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button button3=(Button)findViewById(R.id.button_3);
        final EditText editText=(EditText)findViewById(R.id.edittext);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("便签内容",editText.getText().toString());
                editor.apply();
                Intent intent=new Intent(ThirdActivity.this,jsonActivity.class);
                startActivity(intent);
            }
        });
    }
}
