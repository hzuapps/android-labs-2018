package soft1614080902336.androidlabs.hzuapps.edu.wuziqi;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

class wuziqirj extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_wuziqirj);

        final Activity thisActivity = this;

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Soft1614080902336Activity3.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}