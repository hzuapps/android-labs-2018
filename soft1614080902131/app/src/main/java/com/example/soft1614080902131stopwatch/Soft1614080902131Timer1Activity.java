package com.example.soft1614080902131stopwatch;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Soft1614080902131Timer1Activity extends AppCompatActivity implements View.OnClickListener {

    //定义控件
    private TextView timer1TextView;
    private RecyclerView timer1RecycleView;
    private Button startButton;
    private Button recordButton;
    private Button pauseButton;
    private Button clearButton;
    private Button continueButton;
    private RecyclerView recyclerView;

    //日期信息
    private int startYear;
    private int startMonth;
    private int startDay;
    private int startHour;
    private int startMinute;
    private int startSecond;
    private int currId;



    //定义变量
    private long startTime;
    private int all,minute,second,point;
    private StringBuilder stringBuilder;

    private boolean stopFlag=false;
    private boolean pauseFlag=false;

    private long pauseStartTime;

    private Timer timer;

    //关于数据保存
    private int currentNumber;
    private List<Timer1Record> timer1RecordList =new ArrayList<>();
    private int recordN=0;        //点击了多少次计数

    //定义handler类
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    stringBuilder.setLength(0);
                    if (minute<10)
                        stringBuilder.append("0"+minute+":");
                    else
                        stringBuilder.append(minute+":");

                    if (second<10)
                        stringBuilder.append("0"+second+".");
                    else
                        stringBuilder.append(second+".");

                    if (point<10)
                        stringBuilder.append("0"+point);
                    else
                        stringBuilder.append(point+"");

                    timer1TextView.setText(stringBuilder);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902131_timer1);
        init();
    }

    //初始化方法
    private void init() {
        timer1TextView = (TextView) findViewById(R.id.timer_1_text_view);
        timer1RecycleView = (RecyclerView) findViewById(R.id.timer_1_recycler_view);
        startButton = (Button) findViewById(R.id.start_button);
        recordButton = (Button) findViewById(R.id.record_button);
        pauseButton = (Button) findViewById(R.id.pause_button);
        clearButton = (Button) findViewById(R.id.clear_button);
        continueButton = (Button) findViewById(R.id.continue_button);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        setTitle("");
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        startButton.setOnClickListener(this);
        recordButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        continueButton.setOnClickListener(this);

        stringBuilder =new StringBuilder();

        recyclerView=(RecyclerView)findViewById(R.id.timer_1_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private class Timer implements Runnable{
        @Override
        public void run() {
            while (stopFlag==false){
                while (true){
                    while (pauseFlag==false){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //currentTime=System.currentTimeMillis();
                        all=new Long(System.currentTimeMillis()-startTime).intValue();
                        all=all/10;
                        point=all%100;
                        all=all/100;
                        second=all%60;
                        all=all/60;
                        minute=all;
                        Message message0=new Message();
                        message0.what=0;
                        handler.sendMessage(message0);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                stopFlag=false;
                pauseFlag=false;
                timer=new Timer();
                new Thread(timer).start();
                all=0;
                startTime=System.currentTimeMillis();

                //获取计时日期
                getDate();

                DateRecord dateRecord=new DateRecord();

                StringBuilder dateBuilder=new StringBuilder();
                StringBuilder timeBuilder=new StringBuilder();
                dateBuilder.append(startYear+"-");
                if(startMonth<10){
                    dateBuilder.append("0"+startMonth+"-");
                }else{
                    dateBuilder.append(startMonth+"-");
                }
                if (startDay<10){
                    dateBuilder.append("0"+startDay);
                }else{
                    dateBuilder.append(startDay);
                }

                if(startHour<10){
                    timeBuilder.append("0"+startHour+":");
                }else{
                    timeBuilder.append(startHour+":");
                }
                if(startMinute<10){
                    timeBuilder.append("0"+startMinute+":");
                }else{
                    timeBuilder.append(startMinute+":");
                }
                if(startSecond<10){
                    timeBuilder.append("0"+startSecond);
                }else{
                    timeBuilder.append(""+startSecond);
                }

                dateRecord.setDate(dateBuilder.toString());
                dateRecord.setTime(timeBuilder.toString());
                dateRecord.setRemark("无");

                dateRecord.save();

                DateRecord lastRecord= DataSupport.findLast(DateRecord.class);
                currId =lastRecord.getId();

                startButton.setVisibility(View.GONE);
                recordButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.VISIBLE);
                break;

            case R.id.record_button:
                recordN++;
                Timer1Record timer1Record=new Timer1Record();
                timer1Record.setGrade(stringBuilder.toString());
                timer1Record.setNumber(currId);
                timer1Record.setRankN(recordN);
                timer1Record.save();



                timer1RecordList.add(DataSupport.findLast(Timer1Record.class));
                RecyclerAdaptTimer1 adapt=new RecyclerAdaptTimer1(timer1RecordList);
                recyclerView.setAdapter(adapt);




                break;

            case R.id.pause_button:
                pauseStartTime=System.currentTimeMillis();
                pauseFlag=true;
                recordButton.setVisibility(View.GONE);
                pauseButton.setVisibility(View.GONE);
                clearButton.setVisibility(View.VISIBLE);
                continueButton.setVisibility(View.VISIBLE);
                break;

            case R.id.continue_button:
                pauseFlag=false;
                startTime=startTime+System.currentTimeMillis()-pauseStartTime;
                continueButton.setVisibility(View.GONE);
                clearButton.setVisibility(View.GONE);
                recordButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.VISIBLE);
                break;

            case R.id.clear_button:
                stopFlag=true;
                continueButton.setVisibility(View.GONE);
                clearButton.setVisibility(View.GONE);
                startButton.setVisibility(View.VISIBLE);
                stringBuilder.setLength(0);
                stringBuilder.append("00:00.00");
                timer1TextView.setText(stringBuilder);
                recordN=0;
                timer1RecordList.clear();
                RecyclerAdaptTimer1 adaptTimer1=new RecyclerAdaptTimer1(timer1RecordList);
                recyclerView.setAdapter(adaptTimer1);

                Intent intent=new Intent(Soft1614080902131Timer1Activity.this,Soft1614080902131SaveActivity.class);
                startActivityForResult(intent,1);
                break;



        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;
    }

    //获取计时日期
    private void getDate(){
        Calendar calendar=Calendar.getInstance();
        startYear=calendar.get(Calendar.YEAR);
        startMonth=calendar.get(Calendar.MONTH)+1;
        startDay=calendar.get(Calendar.DAY_OF_MONTH);
        startHour=calendar.get(Calendar.HOUR_OF_DAY);
        startMinute=calendar.get(Calendar.MINUTE);
        startSecond=calendar.get(Calendar.SECOND);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==1){
            this.finish();
        }
    }
}
