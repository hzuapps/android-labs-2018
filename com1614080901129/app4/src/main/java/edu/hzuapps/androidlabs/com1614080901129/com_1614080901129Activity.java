package edu.hzuapps.androidlabs.com1614080901129;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class com_1614080901129Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_1614080901129);
       Button button=(Button)findViewById(R.id.button);
      TextView text3=(TextView)findViewById(R.id.text3);
       SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("联系人",text3.getText().toString());;
        editor.apply();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com_1614080901129Activity.this,jsonActivity.class);
                startActivity(intent);
            }
        });
    }
}
