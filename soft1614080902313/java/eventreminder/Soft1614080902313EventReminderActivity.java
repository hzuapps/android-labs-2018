package soft1614080902313.androidlabs.hzuapps.edu.eventreminder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

public class Soft1614080902313EventReminderActivity extends AppCompatActivity {

	private Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 	getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_soft1614080902313_event_reminder);
	startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Soft1614080902313EventReminderActivity.this,turnActivity.class);
                startActivity(intent);
            }
        } );
    }
}
