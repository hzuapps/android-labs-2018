package edu.hzuapps.androidlabs.Soft1614080902309;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;





public class Soft1614080902309Activity2 extends AppCompatActivity {
    /** Called when the activity is first created. */
    private List<String> list = new ArrayList<String>();
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902309_activity2);
        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        list.add("星期一 1 2节");
        list.add("星期一 3 4节");
        list.add("星期一 5 6节");
        list.add("星期一 7 8节");
        list.add("星期一 9 10节");
        list.add("星期二 1 2节");
        list.add("星期二 3 4节");
        list.add("星期二 5 6节");
        list.add("星期二 7 8节");
        list.add("星期二 9 10节");
        list.add("星期三 1 2节");
        list.add("星期三 3 4节");
        list.add("星期三 5 6节");
        list.add("星期三 7 8节");
        list.add("星期三 9 10节");
        list.add("星期四 1 2节");
        list.add("星期四 3 4节");
        list.add("星期四 5 6节");
        list.add("星期四 7 8节");
        list.add("星期四 9 10节");
        list.add("星期五 1 2节");
        list.add("星期五 3 4节");
        list.add("星期五 5 6节");
        list.add("星期五 7 8节");
        list.add("星期五 9 10节");


        myTextView = (TextView)findViewById(R.id.TextView5);
        mySpinner = (Spinner)findViewById(R.id.spinner);

        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner.setAdapter(adapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                myTextView.setText("您选择的是："+ adapter.getItem(arg2));
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                myTextView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);
            }
        });
        /*下拉菜单弹出的内容选项触屏事件处理*/
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener(){
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /**
                 *
                 */
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });
    }
}
