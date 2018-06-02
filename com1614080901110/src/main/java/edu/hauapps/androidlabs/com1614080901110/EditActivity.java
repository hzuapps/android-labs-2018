package com.zhongzexin.timemanagementzzx;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.zhongzexin.timemanagementzzx.adapter.MySpinnerAdapter;
import com.zhongzexin.timemanagementzzx.database.EventDatabaseHelper;
import com.zhongzexin.timemanagementzzx.reveiver.TimeOutReceiver;

import java.util.Calendar;

/**
 * 对事件编辑的界面
 * @author 王治平
 */
public class EditActivity extends AppCompatActivity {

    /**
     * FROM_EVENT = 2标签表示从ListView中的ShowEvent中跳转过来
     */
    private static final int FROM_EVENT = 2;
    private static final String TAG = "EditActivity";
    private static final int DATA_SDK_VERSION = 24;
    private Calendar cal;
    private int mYear, mMonth, mDay;
    private int mHour;
    private int mMinute;
    private EventDatabaseHelper mHelper;
    private SQLiteDatabase mDatabase;
    private RadioButton mNotificationRB;
    private RadioButton mClockedRB;
    private RadioButton mNoClockedRB;
    private RadioButton mNoNotificationRB;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        getDate();

        mNoNotificationRB = (RadioButton) findViewById(R.id.radio_no_notification);
        mNoClockedRB = (RadioButton) findViewById(R.id.radio_no_clock);
        mNotificationRB = (RadioButton) findViewById(R.id.radio_notification);
        mClockedRB = (RadioButton) findViewById(R.id.radio_clock);

        mHelper = new EventDatabaseHelper(this, "Event.db", null, 6);
        mDatabase = mHelper.getWritableDatabase();

        initSpinner();

//        initIntent();

        initData();

        initTime();

        initFinishButton();

    }

    /**
     * 初始化完成按钮
     */
    private void initFinishButton() {

        /*
        Spinner中
        0.紧急/重要
        1.紧急/不重要
        2.不紧急/重要
        3.不紧急/不重要
         */
        final Button finish = (Button) findViewById(R.id.complete);
        final TextView setTime = (TextView) findViewById(R.id.set_time);
        final TextView setDate = (TextView) findViewById(R.id.set_data);
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(editText.getText().toString())){
                    Toast.makeText(EditActivity.this, "请编写事件内容！", Toast.LENGTH_SHORT).show();
                } else if ("设置日期".equals(setDate.getText())) {
                    Toast.makeText(EditActivity.this, "日期不能为空！", Toast.LENGTH_SHORT).show();
                } else if ("设置时间".equals(setTime.getText())) {
                    Toast.makeText(EditActivity.this, "时间不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    ContentValues values = new ContentValues();
                    values.put("date", setDate.getText().toString());
                    values.put("time", setTime.getText().toString());
                    values.put("content", editText.getText().toString());
                    values.put("degree", spinner.getSelectedItemPosition());
                    values.put("notification", mNotificationRB.isChecked());
                    values.put("clocked", mClockedRB.isChecked());
                    mDatabase.insert("EventTable", null, values);

                    /*
                    时间到了的时候发送广播
                     */
                    alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                    Intent intent = new Intent(EditActivity.this, TimeOutReceiver.class);
                    PendingIntent pi = PendingIntent.getBroadcast(EditActivity.this, 0, intent, 0);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pi);
                    Log.d(TAG, "onDestroy: " + cal.getTimeInMillis());

                    finish();

                }
            }
        });
    }

    /**
     * 编辑时事件的重要程度
     */
    private void initSpinner() {
        String[] numbers = { "紧急/重要", "紧急/不重要", "不紧急/重要", "不紧急/不重要"};
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        MySpinnerAdapter adapter = new MySpinnerAdapter(this, android.R.layout.simple_spinner_item, numbers);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*
                对Spinner进行监听，选择事情的重要程度后自动选择是否开启闹钟和通知栏
                 */
                switch (position) {
                    case 0:
                        mNotificationRB.setChecked(true);
                        mClockedRB.setChecked(true);
                        break;
                    case 1:
                        mClockedRB.setChecked(true);
                        mNoNotificationRB.setChecked(true);
                        break;
                    case 2:
                        mNoClockedRB.setChecked(true);
                        mNotificationRB.setChecked(true);
                        break;
                    case 3:
                        mNoNotificationRB.setChecked(true);
                        mNoClockedRB.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * 点击设置日期
     */
    private void initData() {
        final TextView setData = (TextView) findViewById(R.id.set_data);
        setData.setOnClickListener(new View.OnClickListener() {

            private DatePickerDialog mDialog;

            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    //月份的数值是0～11
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        setData.setText(year+"-"+(++month)+"-"+dayOfMonth);
                        mYear = year;
                        mMonth = month - 1;
                        mDay = dayOfMonth;
                        cal.set(Calendar.DATE, mDay);
                        //如果现在是3月份，这里的mMonth是2
                        cal.set(Calendar.MONTH, mMonth);
                        cal.set(Calendar.YEAR, mYear);
                    }
                };
                mDialog = new DatePickerDialog(EditActivity.this, 0, listener, mYear, mMonth, mDay);
//                if (Build.VERSION.SDK_INT >= DATA_SDK_VERSION) {
//                } else {
//                    mDialog = new DatePickerDialog(EditActivity.this, 0, listener, mYear, mMonth, mDay);
//                    mDialog = new DatePickerDialog(EditActivity.this, 0, listener, 2018, 1, 1);
//                }
                mDialog.show();
            }
        });
    }

    /**
     * 初始化对时间的设置，点击设置时间的TextView时候弹出时间选择窗口
     */
    private void initTime() {
        final TextView setTime = (TextView) findViewById(R.id.set_time);
        setTime.setOnClickListener(new View.OnClickListener() {

            TimePickerDialog mTimePickerDialog;

            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        /*
                        格式化时间，如01：01
                         */
                        if (hourOfDay < 10 && minute < 10) {
                            setTime.setText("0" + hourOfDay + "：" + "0" + minute);
                        } else if (hourOfDay <10 && minute >= 10){
                            setTime.setText("0" + hourOfDay + "：" + minute);
                        } else if (hourOfDay >= 10 && minute < 10) {
                            setTime.setText(hourOfDay + "：" + "0" + minute);
                        } else {
                            setTime.setText(hourOfDay + "：" + minute);
                        }

                        mHour = hourOfDay;
                        mMinute = minute;

                        cal.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        cal.set(Calendar.MINUTE,minute);
                        cal.set(Calendar.SECOND, 0);
                        cal.set(Calendar.MILLISECOND, 0);

                    }
                };
                Log.d(TAG, "onClick: " + mHour);
                mTimePickerDialog = new TimePickerDialog(EditActivity.this, listener, mHour, mMinute, true);
//                if (Build.VERSION.SDK_INT >= DATA_SDK_VERSION) {
//                } else {
//                    mTimePickerDialog = new TimePickerDialog(EditActivity.this, listener, mHour, mMinute, true);
//                }
                mTimePickerDialog.show();
            }
        });
    }

    /**
     *获取当前日期
     */
    private void getDate() {
        cal = Calendar.getInstance();
        //获取年月日时分秒
        mYear =cal.get(Calendar.YEAR);
        //获取到的月份是从0开始计数
        mMonth =cal.get(Calendar.MONTH);
        mDay =cal.get(Calendar.DAY_OF_MONTH);
        mHour = cal.get(Calendar.HOUR_OF_DAY);
        mMinute = cal.get(Calendar.MINUTE);
        System.out.println("aaa年：" + mYear);
        System.out.println("aaa月：" + (mMonth + 1));
        System.out.println("aaa日：" + mDay);
        System.out.println("aaa时：" + mHour);
        System.out.println("aaa分：" + mMinute);
    }

}
