package edu.hzuapps.appforjiaxing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;

public class Soft1614080902103Activity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_soft1614080902103);

                                        textView=(TextView)findViewById(R.id.musicplayer);

                                        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                                                Intent intent=new Intent(Soft1614080902103Activity.this,SecondActivity.class);
                                                                 startActivity(intent);
                                                            }
        });



                                                                    }
}