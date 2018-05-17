package edu.hzuapps.androidlabs.com1614080901139;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Com1614080901139Activity extends AppCompatActivity {
    private Button bt_come;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901139);
        bt_come=(Button)findViewById(R.id.bt_come);
        bt_come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901139Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
