package edu.hzuapps.androidlabs.com1614080901113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class com1614080901113 extends AppCompatActivity {
    private TextView touchLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901113);

        touchLock=findViewById(R.id.tv_touch);
        touchLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(com1614080901113.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
