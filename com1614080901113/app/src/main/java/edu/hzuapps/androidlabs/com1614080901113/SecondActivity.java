package edu.hzuapps.androidlabs.com1614080901113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView picture;
    private Button camera;
    private Button test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        picture=(TextView)findViewById(R.id.picture);
        camera=(Button)findViewById(R.id.camera);
        test=(Button)findViewById(R.id.test);
    }
}
