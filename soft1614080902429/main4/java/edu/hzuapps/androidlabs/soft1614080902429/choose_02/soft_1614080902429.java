package edu.hzuapps.androidlabs.soft1614080902429.choose_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class soft_1614080902429 extends AppCompatActivity {

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_1614080902429);

        final soft_1614080902429 thisActivity = this;

        //关联
        btnNext=(Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当点击按钮前需完成的工作
                Intent intent = new Intent(thisActivity,soft1614080902429.class);
                thisActivity.startActivity(intent);




            }
        });

    }
}
