package edu.hzuapps.androidlabs.com1614080901137;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class com1614080901137Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901137);
        Button button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com1614080901137Activity.this,secondActivity.class);
                startActivity(intent);
            }
        });
        TextView textView=(TextView)findViewById(R.id.textview);
        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("word",textView.getText().toString());
        editor.putString("translation1","父母");
        editor.putString("translation2","兄弟");
        editor.putString("translation3","同学");
        editor.apply();
    }
}
