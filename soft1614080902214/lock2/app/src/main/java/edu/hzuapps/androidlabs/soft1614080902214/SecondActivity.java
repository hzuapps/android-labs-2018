package edu.hzuapps.androidlabs.soft1614080902214;

/**
 * Created by Administrator on 2018/5/21 0021.
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902214);

        final EditText editText=(EditText) findViewById(R.id.mima1);


        Button button=(Button)findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mima1=editText.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("mima1",mima1);

                editor.apply();
                Toast.makeText(SecondActivity.this,"数据已提交！",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void click2(View view) {
        Intent intent = new Intent();
        intent.setClass(SecondActivity.this, ThreeActivity.class);
        startActivity(intent);
    }


}