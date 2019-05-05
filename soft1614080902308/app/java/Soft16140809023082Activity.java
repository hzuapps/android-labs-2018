package edu.hzuapps.androidlabs.soft1614080902308;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.soft1614080902308.R;

public class Soft16140809023082Activity extends AppCompatActivity {
    EditText useraddress,userphone;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809023082);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        useraddress=(EditText) findViewById(R.id.useraddress);
        userphone=(EditText) findViewById(R.id.userphone);

        pref=getSharedPreferences("UserInfo",MODE_PRIVATE);
        editor=pref.edit();



    }
    public void doClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                String address=useraddress.getText().toString().trim();
                String phone=userphone.getText().toString().trim();


                        editor.putString("收货地址",address);
                        editor.putString("手机号",phone);
                        editor.commit();
                        Toast.makeText(Soft16140809023082Activity.this, "成功", Toast.LENGTH_LONG).show();






            break;
            default:
                break;

        }


}

}


