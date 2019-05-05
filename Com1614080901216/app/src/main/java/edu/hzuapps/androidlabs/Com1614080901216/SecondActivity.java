package ezu.hzuapps.androidlabs.Com1614080901216;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anzhuoshiyan.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button1=(Button) findViewById(R.id.fabu);
        Button button2=(Button) findViewById(R.id.chakan);
        Button button3=(Button) findViewById(R.id.xiazai);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(SecondActivity.this,FabuActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(SecondActivity.this,ChakanActivity.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(SecondActivity.this,XiazaiActivity.class);
                startActivity(intent);
            }
        });
    }
}
