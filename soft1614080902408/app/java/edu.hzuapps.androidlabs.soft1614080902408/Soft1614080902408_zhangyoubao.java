package soft1614080902408.androidlabs.hzuapps.edu.soft1614080902408_zhangyoubao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;



public class Soft1614080902408_zhangyoubao extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soft1614080902408_zhangyoubao);

        Button loginBtn = (Button) findViewById(R.id.owbutton);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent();

                intent.setClass(Soft1614080902408_zhangyoubao.this, Soft1614080902408_LoginActivity.class);

                startActivity(intent);

            }

        });
}
}
