package edu.huzapps.androidlabs.soft1614080902144;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Soft1614080902144Activity3 extends AppCompatActivity {
    private Button button_8;
    private EditText edit_text3,edit_text4;
    private int i;
    private String s;
    private Button button_6;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021443);

        button_8=(Button)findViewById(R.id.button_8);
        edit_text3 = (EditText) findViewById(R.id.edit_text3);
        edit_text4 = (EditText) findViewById(R.id.edit_text4);
        button_6=(Button)findViewById(R.id.button_6);
        radioGroup=(RadioGroup)findViewById(R.id.check_radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int j) {
                switch (j){
                    case R.id.chuqin_radio_button:
                        s="出勤";
                        break;
                    case R.id.qingjia_radio_button:
                        s="请假";
                        break;

                    case R.id.kuangke_radio_button:
                        s="旷课";
                        break;
                }
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_text3=(EditText)findViewById(R.id.edit_text3);
                String id=edit_text3.getText().toString();
                edit_text4=(EditText)findViewById(R.id.edit_text4);
                String name=edit_text4.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name"+(i),name);
                editor.putString("id"+i,id);
                editor.putString("check"+(i++),s);
                editor.apply();
                Toast.makeText(Soft1614080902144Activity3.this,"提交成功",Toast.LENGTH_SHORT).show();
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Soft1614080902144Activity3.this,"查看",Toast.LENGTH_SHORT).show();
                SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
                for (int j=0;j<i;j++){
            String name=pref.getString("name"+j,"");
            String id=pref.getString("id"+j,"");
            String s=pref.getString("check"+j,"");
                Log.d("tongzhi",name+"学号为："+id+" 出勤情况为："+s);
            }
            }
        });
    }
}
