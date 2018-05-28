package edu.hzuapps.androidlabs.com1614080901139;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button bt_register;
    private EditText et_userName;
    private EditText et_passWord;
    private TextView tv_forgetPassWord;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_register=(Button)findViewById(R.id.bt_register);
        et_userName=(EditText)findViewById(R.id.et_userName);
        et_passWord=(EditText)findViewById(R.id.et_passWord);
        tv_forgetPassWord=(TextView)findViewById(R.id.tv_forgetPassWord);
        bt_login=(Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=et_userName.getText().toString();
                String passWord=et_passWord.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("user",MODE_PRIVATE).edit();
                editor.putString("userName",userName);
                editor.putString("passWord",passWord);
                editor.apply();
                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
