package edu.hzuapps.androidlabs.soft1614080902426;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText et_user_name;
    private EditText et_psw;
    private CheckBox cb_isCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //1.找到我们关心的按钮
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_psw = (EditText) findViewById(R.id.et_psw);
        cb_isCheckBox = (CheckBox) findViewById(R.id.cb_isCheckBox);
    }
    //2.写按钮的点击事件
    public void login(android.view.View v) {
        //[2.1]获取用户名和密码
        String name = et_user_name.getText().toString().trim();
        String pwd = et_psw.getText().toString().trim();
        //[2.2]判断name 和  pwd 是否为空
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)) {

            Toast.makeText(LoginActivity.this, "用户名或密码不能为空", 1).show();

        }else {
            //[2.3]进行登录的逻辑
            System.out.println("连接服务器  进行登录");

            if (cb_isCheckBox.isChecked()) {
                //[2.4]把用户名和密码的数据给我存起来
                boolean result = UserInfoUtils.saveInfo(LoginActivity.this,name, pwd);
                if (result) {
                    Toast.makeText(LoginActivity.this, "保存成功", 1).show();

                } else {
                    Toast.makeText(LoginActivity.this, "保存失败", 1).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "请勾选cb", 1).show();

            }
        }
    }
}
