package edu.soft1614080902119;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent();
        intent.setClass(MainActivity.this, register.class);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            };
            timer.schedule(task, 3000);
    }
}
