package edu.hzuapps.androidlabs.soft1614080902431;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class Soft1614080902431Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902431);

        textView=(TextView)findViewById(R.id.ic_2);

          textView.setOnClickListener(new View.OnClickListener() {
              @Override
         public void onClick(View view) {
        Intent intent=new Intent(Soft1614080902431Activity.this,InterfaceActivity.class);
        startActivity(intent);
                             }
    });
    }
}
