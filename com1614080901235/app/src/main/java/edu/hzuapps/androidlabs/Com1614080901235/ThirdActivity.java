package edu.hzuapps.androidlabs.Com1614080901235;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tubiao.R;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button button1=(Button) findViewById(R.id.tijiao);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText1=(EditText) findViewById(R.id.yiyue);
                final EditText editText2=(EditText) findViewById(R.id.eryue);
                final EditText editText3=(EditText) findViewById(R.id.sanyue);
                final EditText editText4=(EditText) findViewById(R.id.siyue);
                final EditText editText5=(EditText) findViewById(R.id.wuyue);
                final EditText editText6=(EditText) findViewById(R.id.liuyue);
                String yiyue=editText1.getText().toString();
                String eryue=editText2.getText().toString();
                String sanyue=editText3.getText().toString();
                String siyue=editText4.getText().toString();
                String wuyue=editText5.getText().toString();
                String liuyue=editText6.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("yiyue",yiyue);
                editor.putString("eryue",eryue);
                editor.putString("sanyue",sanyue);
                editor.putString("siyue",siyue);
                editor.putString("wuyue",wuyue);
                editor.putString("liuyue",liuyue);
                editor.apply();
                Toast.makeText(ThirdActivity.this,"数据已提交！",Toast.LENGTH_SHORT).show();

            }
        });
        Button button=(Button) findViewById(R.id.shuju);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText1=(EditText) findViewById(R.id.yiyue);
                final EditText editText2=(EditText) findViewById(R.id.eryue);
                final EditText editText3=(EditText) findViewById(R.id.sanyue);
                final EditText editText4=(EditText) findViewById(R.id.siyue);
                final EditText editText5=(EditText) findViewById(R.id.wuyue);
                final EditText editText6=(EditText) findViewById(R.id.liuyue);
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                String yiyue1=pref.getString("yiyue","");
                String eryue1=pref.getString("eryue","");
                String sanyue1=pref.getString("sanyue","");
                String siyue1=pref.getString("siyue","");
                String wuyue1=pref.getString("wuyue","");
                String liuyue1=pref.getString("liuyue","");
                editText1.setText(yiyue1+1);
                editText2.setText(eryue1+1);
                editText3.setText(sanyue1+1);
                editText4.setText(siyue1+1);
                editText5.setText(wuyue1+1);
                editText6.setText(liuyue1+1);

            }
        });
    }
}
