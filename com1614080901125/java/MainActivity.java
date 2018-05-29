package com1614080901125.androidlabs.hzuapps.edu.hkmacgo;
        import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.TextView;
         import org.w3c.dom.Text;
         public class Com1614080901125 extends AppCompatActivity {
             private TextView textView;
            @Override
     protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_com1614080901125);

                       textView=(TextView)findViewById(R.id.3-1);

                       textView.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View v) {
                               Intent intent=new Intent(Com1614080901125.this,SecordActivity.class);
                               startActivity(intent);
                                }
        });
                                   }
 }