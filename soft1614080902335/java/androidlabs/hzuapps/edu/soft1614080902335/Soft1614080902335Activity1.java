package androidlabs.hzuapps.edu.soft1614080902335;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

import androidlabs.hzuapps.edu.soft1614080902335.R;
import androidlabs.hzuapps.edu.soft1614080902335.Soft1614080902335Activity1;

public class Soft1614080902335Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq1);

        final Activity thisActivity = this;
        final Button btnOpen = (Button) findViewById(R.id.button_open);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(btnOpen)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902335Activity2.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

    }
}
