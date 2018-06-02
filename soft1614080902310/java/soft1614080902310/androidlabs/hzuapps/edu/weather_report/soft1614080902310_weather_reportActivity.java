package soft1614080902310.androidlabs.hzuapps.edu.weather_report;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;


public class soft1614080902310_weather_reportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902310_weather_report);
        Init();
    }
    private void  Init(){
        Timer time=new Timer();
        TimerTask task=new TimerTask(){
            public void run(){
                Intent intent=new Intent(soft1614080902310_weather_reportActivity.this,soft1614080902310_weather_report2Activity.class);
                startActivity(intent);
                soft1614080902310_weather_reportActivity.this.finish();
            }

        };
        time.schedule(task,1000);
    }
}