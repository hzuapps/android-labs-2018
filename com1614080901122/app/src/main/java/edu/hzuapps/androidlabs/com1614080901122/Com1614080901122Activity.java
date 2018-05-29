package edu.hzuapps.androidlabs.com1614080901122;



import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;



import org.w3c.dom.Text;



public class Com1614080901122Activity extends AppCompatActivity {



    private TextView textView;
    private Button newbutton;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        textView=(TextView)findViewById(R.id.textview_01);



        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(Com1614080901122Activity.this,second1614080901122Ativity.class);

                startActivity(intent);

            }

        });
        newbutton=(Button)findViewById(R.id.button3);
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Com1614080901122Activity.this,second1614080901122Ativity.class);
                startActivity(intent);
            }
        });







    }

}