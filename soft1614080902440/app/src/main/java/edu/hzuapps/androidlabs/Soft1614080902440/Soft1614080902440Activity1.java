package edu.androidlabs.soft1614080902440;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Soft1614080902440Activity1 extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_soft1614080902440);
        final EditText mUserName=(EditText)this.findViewById(R.id.login_username);
        final EditText mPassWord=(EditText)this.findViewById(R.id.login_password);
        Button mSubmit=(Button)this.findViewById(R.id.login_submit);
        final TextView mResult=(TextView) this.findViewById(R.id.login_result);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=mUserName.getText().toString();
                String password=mPassWord.getText().toString();
                //默认登陆账号为：admin；密码为：123456
                if("admin".equals(userName)&&"123456".equals(password)){

                    Intent intent = new Intent(Soft1614080902440Activity1.this,Soft1614080902440Activity2.class);
                    Soft1614080902440Activity1.this.startActivity(intent);


                }else{
                    mResult.setText("登陆失败，请重新输入！");
                }
            }
        });
    }
}
