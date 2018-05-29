package soft1614080902310.androidlabs.hzuapps.edu.weather_report;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class soft1614080902310weather_report1Activity extends AppCompatActivity {
    private Button Bt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902310weather_report1);
    Bt1=findViewById(R.id.bt1);
    Bt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(soft1614080902310weather_report1Activity.this,soft1614080902310_weather_report2Activity.class);
            startActivity(intent);
        }
    });


    }


}
