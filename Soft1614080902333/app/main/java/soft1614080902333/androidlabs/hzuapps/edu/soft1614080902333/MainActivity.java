package soft1614080902333.androidlabs.hzuapps.edu.soft1614080902333;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.os.Message;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements Runnable {
    private AlarmManager alarmManager;
    Button btn,btn1,btn2;
     TextView  tt,aa;
    Calendar c=Calendar.getInstance();
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取闹钟的管理者
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


//      闹钟预览的按钮
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,RingActivity.class);
                startActivity(intent);
            }
        });
 //保存remark
        btn1 = (Button) findViewById(R.id.button_remark);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SavaremarkActivity.class);
                startActivity(intent);
            }
        });
        //下载图片
        btn2 = (Button) findViewById(R.id.button11);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,OnpActivity.class);
                startActivity(intent);
            }
        });
        //时间。
        tt=(TextView) findViewById(R.id.textView2);
        handler = new Handler() {
            public void handleMessage(Message msg) {
               tt.setText((String)msg.obj);
            }
        };

        new Thread(this).start();
    }

    public  void  alarmOne(View view){
        //获取当前系统的时间
        final Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        //弹出时间对话框
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                c.set(Calendar.MINUTE,minute);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);

                aa=(TextView)findViewById(R.id.textView3);
               aa.setText(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE));
                Intent intent  =new Intent(MainActivity.this,RingReceivedActivity.class);
                PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this,1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
                //set()设定的PendingIntent只会执行一次
                am.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),sender);
                //时间一到，发送广播（闹钟响了)
             //   Intent intent=new Intent();
               // intent.setAction("soft1614080902333.androidlabs.hzuapps.edu.soft1614080902333.RingActivity");
                //将来时态的跳
               // PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0x101,intent,0);
                //设置闹钟
              //  alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);
            }
        },hour,minute,true);
        timePickerDialog.show();
    }

    @Override
    public void run() {
        try {
            while(true){
                Calendar bb=Calendar.getInstance();
                String str=bb.get(Calendar.HOUR_OF_DAY)+":"+bb.get(Calendar.MINUTE);
                handler.sendMessage(handler.obtainMessage(100,str));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}