package edu.androidlabs.hzuapps.Com161480901221;


import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;



public class com1614080901221Activity extends AppCompatActivity {
    int year = 0;
    int monthOfYear = 0;
    int dayOfMonth = 0;
    private Button mBtn1;
    private TextView mTv;
    private Button mBtn2;
    private  Button mBtn3;
    private ImageView miV;
    private Handler h=new Handler();
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901221);
        initView();
        mBtn1=findViewById(R.id.btn_1);
        mBtn2=findViewById(R.id.btn_2);
        mBtn3=findViewById(R.id.download);
        mTv=findViewById(R.id.tView);
        miV=findViewById(R.id.im);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCurrentText(year,monthOfYear,dayOfMonth);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readSavedText();
            }
        });

        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Second("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527522860034&di=a901727570d258c8a09486f8734cbd72&imgtype=0&src=http%3A%2F%2Fimg3.a0bi.com%2Fupload%2Fttq%2F20150410%2F1428671829562.jpg",miV,h).start();
            }
        });
    }
    private void readSavedText()
    {
        try {
            InputStream is=openFileInput("data");
            byte[] bytes=new byte[is.available()];
            is.read(bytes);
            is.close();
            String str=new String(bytes,"utf-8");
            mTv.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void saveCurrentText(int year,int month,int day)
    {
         month++;
         String str1=Integer.toString(year);
         String str2=Integer.toString(month);
         String str3=Integer.toString(day);
        String str="今天是"+str1+"年"+str2+"月"+str3+"号";
        try {
            OutputStream os=openFileOutput("data", Context.MODE_PRIVATE);
            os.write(str.getBytes("utf-8"));
            os.flush();
            os.close();
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"保存出错",Toast.LENGTH_SHORT).show();
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
