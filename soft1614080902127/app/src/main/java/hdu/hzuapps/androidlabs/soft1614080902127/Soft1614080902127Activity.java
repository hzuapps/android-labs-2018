package edu.hzuapps.androidlabs.soft1614080902127;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Soft1614080902127Activity extends AppCompatActivity implements View.OnClickListener{
    private Button bn_Login;
    private EditText et_username;
    private EditText et_password;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902127);
        context=Soft1614080902127Activity.this;
        initView();
    }


    private  void login(){
        InputMethodManager imm = (InputMethodManager) context.getApplicationContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_password.getWindowToken(), 0);
        final String username = et_username.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        final Map<String,String> map=new HashMap<>();
        if(et_username.equals(null)||et_password.equals(null)){
            Toast.makeText(Soft1614080902127Activity.this,"账号和密码不可以为空",Toast.LENGTH_SHORT).show();
        }else {
            map.put("username", username);
            map.put("password", password);
            //这里是发送数据并获取返回值的地方
            HttpWeb.postDataAsync(map).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Soft1614080902127Activity.this, "服务器繁忙", Toast.LENGTH_SHORT).show();

                        }
                    });
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new Gson();
                            User user = gson.fromJson(response.body().charStream(), User.class);
                            if (user.getResult().equals("success")) {
                                Intent intent = new Intent();
                                intent.setClass(Soft1614080902127Activity.this, SecondActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(Soft1614080902127Activity.this, "账号不存在或密码错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
        }



    }
    private void initView(){
        bn_Login=(Button)findViewById(R.id.btn_login);
        et_username=(EditText)findViewById(R.id.username);
        et_password=(EditText)findViewById(R.id.password);
        bn_Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login();
                break;
            default:
                break;
        }
    }
}

