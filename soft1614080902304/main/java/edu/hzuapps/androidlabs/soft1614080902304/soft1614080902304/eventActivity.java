package edu.hzuapps.androidlabs.soft1614080902304.soft1614080902304;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by 李惠怡 on 2018/5/18.
 */

public class eventActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_layout);
        LinearLayout important_emergency=(LinearLayout) findViewById(R.id.important_emergency);
        important_emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventActivity.this,FileStorageActivity.class);
                startActivity(intent);
            }
        });
    }
}
