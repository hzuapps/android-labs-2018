package edu.hzuapps.androidlabs.com1606081301137;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Date;

import static android.R.attr.button;

public class AlarmView extends LinearLayout {
    public AlarmView(Context context) {
        super(context);
    }

    public AlarmView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlarmView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        btnAddAlarm = (Button) findViewById(R.id.btnAddAlarm);
        lvAlarmList = (ListView) findViewById(R.id.lvAlarmList);

        adapter = new ArrayAdapter<AlarmData>(getContext(),android.R.layout.simple_list_item_1);
        lvAlarmList.setAdapter(adapter);

        adapter.add(new AlarmData(System.currentTimeMillis()));

        btnAddAlarm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addAlarm();
            }
        });
    }

    private void addAlarm(){
        //TODO
    }


    private Button btnAddAlarm;
    private ListView lvAlarmList;
    private ArrayAdapter<AlarmData> adapter;

    private static class AlarmData{
        public AlarmData(long time) {
            this.time = time;
            data = new Date(time);
            timeLable = data.getHours()+":"+data.getMinutes();
        }

        public long getTime() {
            return time;
        }

        public String getTimeLable() {
            return timeLable;
        }

        @Override
        public String toString() {
            return getTimeLable();
        }

        private String timeLable = "";

        private long time = 0;
        private Date data;
    }
}
