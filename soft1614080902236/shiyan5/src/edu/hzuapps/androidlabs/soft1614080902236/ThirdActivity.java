package edu.hzuapps.androidlabs.soft1614080902236;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends Activity {

	private EditText et;
	private Button bt;
	private SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
	    sp = getSharedPreferences("config", 0);
	    et = (EditText)findViewById(R.id.et);
	    bt=(Button)findViewById(R.id.bt);
	    
	    String date=sp.getString("date", "");
	    et.setText(date);
	    
	
	}
	
	public void login(View v){
	    String str=et.getText().toString().trim();
	    Editor ed = sp.edit();
	    ed.putString("date", str);
	    ed.commit();
	}
}
