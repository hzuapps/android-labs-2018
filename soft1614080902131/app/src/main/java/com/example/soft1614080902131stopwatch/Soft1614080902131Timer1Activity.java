package com.example.soft1614080902131stopwatch;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Soft1614080902131Timer1Activity extends AppCompatActivity implements View.OnClickListener {

    //定义控件
    private TextView timer1TextView;
    private RecyclerView timer1RecycleView;
    private Button startButton;
    private Button recordButton;
    private Button pauseButton;
    private Button clearButton;
    private Button continueButton;



    //定义变量
    private long startTime,currentTime;
    private int all,minute,second,point;
    private StringBuilder stringBuilder;

    private boolean stopFlag=false;
    private boolean pauseFlag=false;

    private long pauseStartTime;

    private Timer timer;

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

        startButton.setOnClickListener(this);
        recordButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        continueButton.setOnClickListener(this);

        stringBuilder =new StringBuilder();

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
                        currentTime=System.currentTimeMillis();
                        all=new Long(currentTime-startTime).intValue();
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
                startButton.setVisibility(View.GONE);
                recordButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.VISIBLE);
                break;

            case R.id.record_button:
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
                break;

        }
    }


}
