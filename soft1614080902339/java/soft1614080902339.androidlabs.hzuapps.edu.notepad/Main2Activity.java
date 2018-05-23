package soft1614080902339.androidlabs.hzuapps.edu.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Main2Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.roundBtn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.roundBtn2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Main3Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
