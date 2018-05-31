package edu.hzuapps.androidlabs.soft1613071002123.myapplication;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Soft1613071002123Activity extends AppCompatActivity{

    private static final String TAG = "Soft1613071002123Activi";
    private Button login;
    private Button register;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1613071002123);
        Log.d(TAG, "onCreate: ");
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = findViewById(R.id.accound);
        passwordEdit = findViewById(R.id.password);
        rememberPass = findViewById(R.id.remember_pass);
        //登录按钮
        login = findViewById(R.id.button_login);
        boolean isRemember = preferences.getBoolean("记住密码", false);
        if (isRemember){
            String account = preferences.getString("account", "");
            String password = preferences.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")){
                    editor = preferences.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("记住密码", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    }else {
                        editor.clear();
                    }
                    editor.commit();
                }
                Intent intent = new Intent(Soft1613071002123Activity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //注册按钮
        register = findViewById(R.id.button_register);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Soft1613071002123Activity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
