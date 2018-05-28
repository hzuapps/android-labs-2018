package edu.hauapps.androidlabs.com1614080901131;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private Button bt_get;
    private TextView tv_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bt_get=(Button)findViewById(R.id.bt_put);
        tv_text=(TextView)findViewById(R.id.tv_text);
        bt_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1=tv_text.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("text1",text1);
                editor.apply();
                Toast.makeText(SecondActivity.this,"发送成功",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(SecondActivity.this,TextActivity.class);
                startActivity(intent);
            }
        });
    }
}
