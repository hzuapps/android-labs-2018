package edu.androidlabs.soft1614080902418;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
public class soft1614080902418MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902418_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(soft1614080902418MainActivity.this,sBianqian.class);
                               startActivity(intent);

                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

    }
}