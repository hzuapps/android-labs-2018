package edu.hzuapps.androidlabs.soft1614080902117;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
public class Soft1614080902117Activity1 extends Activity {

    Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021171);

        button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902117Activity1.this,Soft1614080902117Activity.class);
                startActivity(intent);
            }
        });
    }
}
