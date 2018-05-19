package edu.androidlabs.hzuapps.Com161480901221;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;;
import android.widget.DatePicker;
import java.util.Calendar;



public class com1614080901221Activity extends AppCompatActivity {
    int year = 0;
    int monthOfYear = 0;
    int dayOfMonth = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901221);
        initView();
    }

    private void initView() {
        DatePicker date =findViewById(R.id.main_dp);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        monthOfYear = c.get(Calendar.MONTH);
        dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        date.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                com1614080901221Activity.this.year = year;
                com1614080901221Activity.this.monthOfYear = monthOfYear;
                com1614080901221Activity.this.dayOfMonth = dayOfMonth;
            }
        });
    }

}
