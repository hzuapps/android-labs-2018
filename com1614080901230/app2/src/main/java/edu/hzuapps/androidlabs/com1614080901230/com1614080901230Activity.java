package edu.hzuapps.androidlabs.com1614080901230;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.TextView;

import org.w3c.dom.Text;

public class com1614080901230Activity extends AppCompatActivity {
    private TextView textView;
    implements OnClickListener, OnLongClickListener, OnTouchListener
,OnCheckedChangeListener{
        private TextView mLogView;
        private SimpleView mTouchView;
        private CheckBox mBoxClick;
        private CheckBox mBoxLongClick;
        private CheckBox mBoxTouch;
        private CheckBox mBoxTouchTrack;
        @Override
　　    public void onCreate(Bundle savedInstanceState) {
　　　　super.onCreate(savedInstanceState);
　　　　setContentView(R.layout.main);
　　　　mLogView = (TextView)findViewById(R.id.tv0);
　　　　mTouchView = (SimpleView)findViewById(R.id.tv1);
　　　　mTouchView.setBackgroundColor(Color.CYAN);
　　　　mTouchView.setOnClickListener(this);
　　　　mTouchView.setOnLongClickListener(this);
　　　　mTouchView.setOnTouchListener(this);
　　　　mLogView.setTextSize((float) 10.0);
　　　　
　　　　mBoxClick = (CheckBox)findViewById(R.id.box_click);
　　　　mBoxLongClick = (CheckBox)findViewById(R.id.box_longclick);
　　　　mBoxTouch = (CheckBox)findViewById(R.id.box_touch);
　　　　mBoxTouchTrack = (CheckBox)findViewById(R.id.box_touch_track);
　　　　mBoxTouchTrack.setOnCheckedChangeListener(this);
　　}

        @Override
        public void onClick(View arg0) {　// 单击
            if(mBoxClick.isChecked()) {　// 确定用户是否选择了监听单击事件
                if(arg0.getId() == R.id.tv1) {
                    mLogView.append("onClick event\n");　// 记录到日志窗口
                    mLogView.scrollBy(0, 10);　// 滚动日志
                }
            }
        }

        @Override
        public boolean onLongClick(View arg0) {　// 长按
            if(mBoxLongClick.isChecked()) {
                if(arg0.getId() == R.id.tv1) {
                    mLogView.append("onLongClick event\n");
                }
// 下面进行随机返回处理，以便于观察事件处理之间的关系，请参考后面的小结
                if(System.currentTimeMillis() % 2 == 0) {
                    mLogView.append("onLongClick return true\n");
                    return true;
                } else {
                    mLogView.append("onLongClick return false\n");
                    return false;
                }
            }
            return false;　// 默认不处理，交由后面的环节去处理
        }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901230);
        textView=(TextView)findViewById(R.id.textview_01);


        textView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent=new Intent(com1614080901230Activity.this,SecondActivity.class);

                startActivity(intent);

            }

        });
    }
}

