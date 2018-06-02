package edu.hzuapps.androidlabs2018.soft1613071002206;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;



public class Soft1613071002206 extends AppCompatActivity {
      private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1613071002206);
        btn = (Button) findViewById(R.id.开始);
        btn.setOnClickListener((View.OnClickListener) new MyButtonListener());

}


  class MyButtonListener implements View.OnClickListener {
        public void onClick(View v){
            Intent intent =  new Intent();
            intent.setClass(Soft1613071002206.this,MainActivity.class);

            Soft1613071002206.this.startActivity(intent);
        }
  }


        }

