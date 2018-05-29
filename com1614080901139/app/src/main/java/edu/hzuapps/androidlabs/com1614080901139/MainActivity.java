package edu.hzuapps.androidlabs.com1614080901139;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}
