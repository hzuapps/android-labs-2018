package edu.hzuapps.androidlabs.soft1614080902239;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;

public class Soft1614080902239Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902239);

        textView=(TextView)findViewById(R.id.mmm);

                        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                        Intent intent=new Intent(Soft1614080902239Activity.this,SecordActivity.class);
                                        startActivity(intent);
                                    }
        });



                                    }
}