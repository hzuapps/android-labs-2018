package edu.hzuapps.androidlabs.com1614080901143;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class com_1614080901143Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_1614080901143);
        Button button2=(Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(com_1614080901143Activity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
