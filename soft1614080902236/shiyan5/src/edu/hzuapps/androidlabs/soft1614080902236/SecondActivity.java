package edu.hzuapps.androidlabs.soft1614080902236;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}
  public void click(View v){
	  Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
      startActivity(intent);
  }
}
