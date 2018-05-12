package edu.hzuapps.andriodlabs.com1614080901140;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.com1614080901140.R;

public class Com1614080901140Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901140);
        Button button2=(Button) findViewById(R.id.yonghu);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Com1614080901140Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
