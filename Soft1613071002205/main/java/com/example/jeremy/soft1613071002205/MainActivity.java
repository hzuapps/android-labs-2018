package com.example.jeremy.soft1613071002205;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button 登录;
    private EditText 用户名;
    private EditText 密码;
    private SharedPreferences mSharePreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharePreferences = getSharedPreferences("data", MODE_PRIVATE);

        用户名 = (EditText) findViewById(R.id.editText);
        密码 = (EditText) findViewById(R.id.editText2);
        //取出数据并渲染

        登录 = (Button) findViewById(R.id.login);
        登录.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String stringUsername = 用户名.getText().toString();
                    String stringPassword = 密码.getText().toString();
                    // 2. 调用SharedPreferences.edit()方法，返回SharedPreferences.Editor对象，用于写入数据；
                    SharedPreferences.Editor editor = mSharePreferences.edit();
                    //3. 调用SharedPreferences.Editor.putXxx(String key, xxx Value)方法以键值对的形式保存数据；
                    editor.putString("user", stringUsername);
                    editor.putString("password", stringPassword);
                    // 4. 调用SharedPreferences.Editor.commit()方法提交数据。
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, User.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", stringUsername);
                    bundle.putString("password", stringPassword);
                    intent.putExtra("data", bundle);

                    startActivity(intent);
            }

        });
    }
}
