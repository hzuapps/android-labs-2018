package edu.hzuapps.androidlabs.soft1614080902429.choose_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnOk,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainActivity thisActivity = this;

        //关联
        btnOk=(Button)findViewById(R.id.btnOk);
        btnCancel=(Button)findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //当点击确定按钮前需完成的工作，回调事件响应

                Intent intent = new Intent(thisActivity,soft_1614080902429.class);
                thisActivity.startActivity(intent);


            }
        });
      btnCancel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //当点击退出按钮前完成的工作
              Intent intent = new Intent(thisActivity,soft1614080902429.class);
              thisActivity.startActivity(intent);



          }
      });


    }
}
