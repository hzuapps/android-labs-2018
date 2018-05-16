package edu.hzuapps.androidlabs.com1614080901207;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 *
 */
public class Main2Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView txv,txvTime;
    Spinner cinema,time;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txv = findViewById(R.id.testview_id);

        txvTime = findViewById(R.id.testview_timer);
        cinema = findViewById(R.id.spinner);

        time = findViewById(R.id.spinner_time);
        time.setOnItemSelectedListener(this);

        but= findViewById(R.id.bt_selt);
        but.setOnClickListener(this);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        String [] cinemas=getResources().getStringArray(R.array.cinemas);

        int index = cinema.getSelectedItemPosition();//选取的位置

        txv.setText("订"+" "+cinemas[index]+" "+"票");
    }

    //这一种可以实时显示选择
    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String [] times=getResources().getStringArray(R.array.time);
        txvTime.setText("时间："+" " + times[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}