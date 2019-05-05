package edu.hzuapps.androidlabs.soft1614080902431;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class MyActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        textView=(TextView)findViewById(R.id.ic_2);

          textView.setOnClickListener(new View.OnClickListener() {
              @Override
         public void onClick(View view) {
        Intent intent=new Intent(MyActivity.this,LoginActivity.class);
        startActivity(intent);
                             }
    });
    }
}
