package edu.hzuapps.androidlabs.Com1614080901209;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.com1614080901209.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final int randomNumber = getSharedPreferences("data",MODE_PRIVATE).getInt("ramdomNumber",0);

        final EditText ed = (EditText)findViewById(R.id.edit);
        Button bu = (Button)findViewById(R.id.button) ;
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed.getText().toString() == ""+randomNumber){
                    Toast.makeText(SecondActivity.this,"运气真好猜对了",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SecondActivity.this,"运气用光了猜错咯",Toast.LENGTH_SHORT).show();
                }
            }
        });
        Log.d("SecondActivity", "onCreate: "+randomNumber);
    }
}
