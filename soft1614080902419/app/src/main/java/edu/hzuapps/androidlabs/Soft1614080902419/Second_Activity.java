package edu.hzuapps.androidlabs.Soft1614080902419;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView t[] = new TextView[18];
    TextView counting,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        this.RegisterEvent();
    }
    public void RegisterEvent(){
        counting = (TextView) findViewById(R.id.counting);
        result = (TextView) findViewById(R.id.result);
        String str = "R.id.n_0";
        t[0] = (TextView) findViewById(R.id.n_0);
        t[1] = (TextView) findViewById(R.id.n_1);
        t[2] = (TextView) findViewById(R.id.n_2);
        t[3] = (TextView) findViewById(R.id.n_3);
        t[4] = (TextView) findViewById(R.id.n_4);
        t[5] = (TextView) findViewById(R.id.n_5);
        t[6] = (TextView) findViewById(R.id.n_6);
        t[7] = (TextView) findViewById(R.id.n_7);
        t[8] = (TextView) findViewById(R.id.n_8);
        t[9] = (TextView) findViewById(R.id.n_9);
        t[10] = (TextView) findViewById(R.id.n_10);
        t[11] = (TextView) findViewById(R.id.n_11);
        t[12] = (TextView) findViewById(R.id.n_12);
        t[13] = (TextView) findViewById(R.id.n_13);
        t[14] = (TextView) findViewById(R.id.n_14);
        t[15] = (TextView) findViewById(R.id.n_15);
        t[16] = (TextView) findViewById(R.id.n_16);
        t[17] = (TextView) findViewById(R.id.n_17);
        for(int i=0;i<18;i++){
            t[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        for(int i=0;i<18;i++){
            if(t[i]==view){
                String str = t[i].getText().toString();
                Log.d("dd",str);
                counting.setText(str);
            }
        }
    }
}
