package com.zhongzexin.timemanagementzzx;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.zhongzexin.timemanagementzzx.adapter.EventAdapter;
import com.zhongzexin.timemanagementzzx.bean.Event;
import com.zhongzexin.timemanagementzzx.database.EventDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ImportantEmergency extends AppCompatActivity {

    private List<Event> mList = new ArrayList<>();
    private static final String TAG = "ImportantEmergency";
    private EventDatabaseHelper mHelper;
    private EventAdapter mAdapter;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_emergency);
        mHelper = new EventDatabaseHelper(this, "Event.db", null, 6);
        mDatabase = mHelper.getWritableDatabase();
        initEvent();
        initListView();
        initAddFAB();
    }

    /**
     * 初始化添加事件的按钮
     */
    private void initAddFAB() {
        FloatingActionButton addFAB = (FloatingActionButton) findViewById(R.id.fab_add);
        addFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImportantEmergency.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initListView() {
        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_data);
        if (emptyView == null) {
            Log.d(TAG, "initListView:  null");
        } else {
            Log.d(TAG, "initListView:  you ");
        }
        listView.setEmptyView(emptyView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ImportantEmergency.this, ReEditActivity.class);
                intent.putExtra("year_m_d", mList.get(position).getYearMD());
                intent.putExtra("time", mList.get(position).getTime());
                intent.putExtra("event", mList.get(position).getTitle());
                intent.putExtra("degree", mList.get(position).getDegree());
                intent.putExtra("isClockBol", mList.get(position).isClocked());
                intent.putExtra("isNotification", mList.get(position).isNotification());
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final Dialog mDialog = new Dialog(ImportantEmergency.this, R.style.ImageloadingDialogStyle);
                LinearLayout mLinearLayout = (LinearLayout) LayoutInflater.from(ImportantEmergency.this).inflate(
                        R.layout.layout_camera_control, null);
                mLinearLayout.findViewById(R.id.btn_del_img).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SQLiteDatabase database = mHelper.getWritableDatabase();
                        database.delete("EventTable", "content = ? and date = ? and time = ? and degree = ?",
                        new String[] {mList.get(position).getTitle(), mList.get(position).getYearMD(), mList.get(position).getTime(), "0"});
                        Log.d(TAG, "onItemLongClick: " + mList.get(position).getTime());
                        mList.clear();
                        initEvent();
                        mAdapter.notifyDataSetChanged();
                        mDialog.dismiss();
                    }
                });
                mLinearLayout.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDialog.dismiss();
                    }
                });
                mDialog.setContentView(mLinearLayout);
                Window dialogWindow = mDialog.getWindow();
                //在底部
                dialogWindow.setGravity(Gravity.BOTTOM);
                //设置切入出动画
                dialogWindow.setWindowAnimations(R.style.dialogstyle);
                // 添加动画
                WindowManager.LayoutParams mLayoutParams = dialogWindow.getAttributes();
                // 获取对话框当前的参数值
                mLayoutParams.x = 0;
                // 新位置X坐标
                mLayoutParams.y = -20;
                // 新位置Y坐标
                mLayoutParams.width = getResources().getDisplayMetrics().widthPixels;
                // 宽度
                mLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
                // 高度
                mLayoutParams.alpha = 9f;
                // 透明度
                mLinearLayout.measure(0, 0);
//                lp.height = root.getMeasuredHeight();
//                lp.alpha = 9f;
                // 透明度
                dialogWindow.setAttributes(mLayoutParams);
                mDialog.show();
                /*
                返回值表示是否在长按时候加一个短按动作
                打个比方，就是说当return返回值为true的时候，代表这个事件已经消耗完了，
                返回值为false的时候他还会继续传递，结果再加上一个短按。
                 */
                return true;
            }
        });
        mAdapter = new EventAdapter(ImportantEmergency.this, R.layout.item_view, mList);
        listView.setAdapter(mAdapter);
    }

    /**
     *
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        mList.clear();
        initEvent();
        initListView();
    }

    /**
     *初始化事件
     */
    private void initEvent() {

        boolean isNotification;
        boolean mIsClockedBool;

        Cursor cursor = mDatabase.query("EventTable", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                /*
                如果是重要且紧急的事件
                 */
                    String content = cursor.getString(cursor.getColumnIndex("content"));
                    String time = cursor.getString(cursor.getColumnIndex("time"));
                    String data = cursor.getString(cursor.getColumnIndex("date"));
                    int degree = cursor.getInt(cursor.getColumnIndex("degree"));
                    /*
                    if (cursor.getInt(cursor.getColumnIndex("clocked")) == 0) {
                        mIsClockedBool = false;
                    } else {
                        mIsClockedBool = true;
                    }
                    简化为：
                     */
                    isNotification = cursor.getInt(cursor.getColumnIndex("notification")) != 0;
                    mIsClockedBool = cursor.getInt(cursor.getColumnIndex("clocked")) != 0;

                    Event event = new Event(content, data, time, degree, mIsClockedBool, isNotification);
                    mList.add(event);
            } while (cursor.moveToNext());
        }

        cursor.close();

    }

}
