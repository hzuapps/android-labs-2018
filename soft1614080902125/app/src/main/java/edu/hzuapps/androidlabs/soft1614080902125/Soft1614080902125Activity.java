package edu.hzuapps.androidlabs.soft1614080902125;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Soft1614080902125Activity extends AppCompatActivity {


    private:

    String in_username;
    String in_password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902125);

        final Activity thisActivity = this;
        final EditText edit_username_in =findViewById(R.id.edit_username);
        final EditText edit_password_in =findViewById(R.id.edit_password);
        Button btnOpen =  findViewById(R.id.button_login);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                in_username=edit_username_in.getText().toString();
                in_password=edit_password_in.getText().toString();
                if(in_username.length()==0){
                    Toast.makeText(thisActivity, "请输入用户名", Toast.LENGTH_SHORT).show();
                }else if(in_password==null||in_password.length()==0){
                    Toast.makeText(thisActivity, "请输入密码", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(thisActivity, MainActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            }
        });
    }
}