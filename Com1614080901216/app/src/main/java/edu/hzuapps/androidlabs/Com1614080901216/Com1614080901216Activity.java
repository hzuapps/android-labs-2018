package ezu.hzuapps.androidlabs.Com1614080901216;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.anzhuoshiyan.R;

public class Com1614080901216Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901216);
        Button button1=(Button) findViewById(R.id.dailian);
        Button button2=(Button) findViewById(R.id.yonghui);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Com1614080901216Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(Com1614080901216Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

}
