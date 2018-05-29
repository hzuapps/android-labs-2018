package edu.hzuapps.androidlabs.com1614080901118;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Com1614080901118Activity extends AppCompatActivity {
    private TextView tv_gomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901118);

        tv_gomain=(TextView)findViewById(R.id.gomain);
        tv_gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901118Activity.this,SecondActivity.class);
                startActivity(intent);
                Com1614080901118Activity.this.finish();
            }
        });
    }
}
