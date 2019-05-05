package edu.hzuapps.androidlabs.soft1614080902431;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class InterfaceActivity extends AppCompatActivity {

   // private EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
       // et_phone = (EditText) findViewById(R.id.bt3);
        Button bt_call = (Button) findViewById(R.id.bt1);
        Button bt_call2 = (Button) findViewById(R.id.bt2);
        Button bt_call3 = (Button) findViewById(R.id.bt3);
        //设点事件第一种
        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //在按钮响应//MainActivity.this 为当前窗体，LoginActivity.class 为跳到的第二个窗体
                Intent intent =new Intent(InterfaceActivity.this,InformationActivity.class);
                startActivity(intent);

            }
        });
        bt_call2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(InterfaceActivity.this,SendActivity.class);
                startActivity(intent);

            }
        });
        bt_call3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
               // return true;
                //startActivity(intent);

            }
        });
    }}
