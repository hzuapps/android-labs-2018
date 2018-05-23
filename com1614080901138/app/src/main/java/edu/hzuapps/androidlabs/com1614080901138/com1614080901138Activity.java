package edu.hzuapps.androidlabs.com1614080901138;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class com1614080901138Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901138);
        ImageButton button=(ImageButton)findViewById(R.id.button_2);
        TextView textView=(TextView) findViewById(R.id.textview1);
        TextView textView1=(TextView) findViewById(R.id.textview2);
        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("第一条信息",textView.getText().toString());
        editor.putString("第二条信息",textView1.getText().toString());
        editor.apply();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com1614080901138Activity.this,com_1614080901138Activity.class);
                startActivity(intent);
            }
        });
    }
}
