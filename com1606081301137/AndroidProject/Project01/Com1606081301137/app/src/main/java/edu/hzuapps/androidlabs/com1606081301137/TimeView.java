package edu.hzuapps.androidlabs.com1606081301137;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Calendar;

/**
 * Created by ChaShu on 2018/4/30.
 */

public class TimeView extends LinearLayout {

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public TimeView(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        csicon = (TextView) findViewById(R.id.csicon);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvTime.setText("Hello");
        timerHandler.sendEmptyMessage(0);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if(visibility==View.VISIBLE){
            timerHandler.sendEmptyMessage(0);
        }else {
            timerHandler.removeMessages(0);
        }
    }

    private void refreshTime(){
        Calendar c = Calendar.getInstance();
        tvTime.setText(String.format("%d:%d:%d",c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),c.get(Calendar.SECOND)));
        csicon.setText(" ");
    }

    private Handler timerHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            refreshTime();
            if(getVisibility()== View.VISIBLE){
                timerHandler.sendEmptyMessageDelayed(0,1000);
            }
        };
    };

    private TextView tvTime;
    private TextView csicon;

}
