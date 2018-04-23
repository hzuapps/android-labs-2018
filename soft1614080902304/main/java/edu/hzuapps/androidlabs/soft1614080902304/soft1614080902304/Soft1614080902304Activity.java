package edu.hzuapps.androidlabs.soft1614080902304.soft1614080902304;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902304Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn01=(Button) findViewById(R.id.btn01);
        Button btn02=(Button) findViewById(R.id.btn02);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Soft1614080902304Activity.this,BaseActivity.class);
                startActivity(intent);
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Soft1614080902304Activity.this,BaseActivity.class);
                startActivity(intent);
            }
        });
    }
}
