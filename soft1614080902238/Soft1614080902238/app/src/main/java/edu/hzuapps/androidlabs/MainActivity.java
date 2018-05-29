package edu.hzuapps.androidlabs;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    Button finish, startActivity;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;
        Button finsh = (Button) findViewById(R.id.finish);
        startActivity = (Button) findViewById(R.id.startActivity);
        startActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View source) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                thisActivity.startActivity(intent);

            }
        });


    }
}