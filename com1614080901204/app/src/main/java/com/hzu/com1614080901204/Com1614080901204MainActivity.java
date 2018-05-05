package com.hzu.com1614080901204;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class Com1614080901204MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901204_main);
        textView=(TextView)findViewById(R.id.button);

        textView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v){

                Intent intent=new Intent(Com1614080901204MainActivity.this,SecondActivity.class);

                startActivity(intent);

            }});
    }
}

