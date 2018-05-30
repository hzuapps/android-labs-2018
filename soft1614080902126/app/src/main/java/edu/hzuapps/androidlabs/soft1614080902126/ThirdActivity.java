package edu.hzuapps.androidlabs.soft1614080902126;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button saveData=(Button)findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor =getSharedPreferences("data",MODE_PRIVATE).edit();
                EditText tv1=(EditText) findViewById(R.id.edit);
                String st=tv1.getText().toString();
                editor.putString("file",st);
                editor.apply();
                SharedPreferences  pref=getSharedPreferences("data",MODE_PRIVATE);
                String file2 =pref.getString("file","");
                Log.d("ThridActivity","用sharedPreference存入并读取的数据为："+file2);

                TextView textView = (TextView) findViewById(R.id.textView3);
                textView.setText(getResources().getString(R.string.file));

            }
        });
        Button button1=(Button)findViewById(R.id.button_xiazai);
        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent=new Intent(ThirdActivity.this,FinallyActivity.class);
                startActivity(intent);
            }
        });

    }
}
