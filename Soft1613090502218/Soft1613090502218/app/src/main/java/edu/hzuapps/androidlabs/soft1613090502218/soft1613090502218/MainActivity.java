package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.btu1);
        button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,difficulty.class);
                startActivity(intent);
            }
        });
    }


}
