package edu.hzuapps.andriodlabs.soft1614080902228;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Soft1614080902228Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.bt);
        bt.setOnClickListener(new OnClickListener() {
 		
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub
 			 Intent intent=new Intent();
 			  intent.setClass(Soft1614080902228Activity.this, SecondActivity.class);
 			  Soft1614080902228Activity.this.startActivity(intent);
 		}
 	});
  }
}
