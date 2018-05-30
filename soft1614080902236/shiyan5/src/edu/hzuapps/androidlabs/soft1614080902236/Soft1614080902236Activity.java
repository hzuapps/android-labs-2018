package edu.hzuapps.androidlabs.soft1614080902236;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Soft1614080902236Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soft1614080902236);
		Button startActivity = (Button)findViewById(R.id.startActivity);
	   
	}

	public void click(View v){
		 Intent intent = new Intent(Soft1614080902236Activity.this, SecondActivity.class);
         startActivity(intent);
	}
}
