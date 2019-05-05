package edu.hzuapps.androidlabs.Soft1609081602308;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public abstract class Soft1609081602308Activity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 中间内容栏
     */
    private FrameLayout mBodyLayout;
    /**
     * 底部按钮栏
     */
    public LinearLayout mBottomLayout = (LinearLayout) findViewById(R.id.main_bottom_bar);
    /**
     * 底部按钮
     */
    private View mHomeBtn;
    private View mMyInfoBtn;
    private View mListBtn;
    private TextView tv_home;
    private TextView tv_list;
    private TextView tv_myInfo;
    private ImageView iv_home;
    private ImageView iv_list;
    private ImageView iv_myInfo;
    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout rl_title_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1609081602308);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        initBottomBar();
        setListener();
        setInitStatus();
    }
    /**
     * 获取界面上的UI控件
     */
    private void init(){
        tv_back= findViewById(R.id.tv_back);
        tv_main_title= findViewById(R.id.tv_main_title);
        tv_main_title.setText("惠大帮帮忙");
        rl_title_bar= findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        tv_back.setVisibility(View.GONE);
        initBodyLayout();
    }
    /**
     * 获取底部导航栏上的控件
     */
    private void initBottomBar(){
        mBottomLayout= findViewById(R.id.main_bottom_bar);
        mHomeBtn=findViewById(R.id.bottom_bar_home_btn);
        mListBtn = findViewById(R.id.bottom_bar_list_btn);
        mMyInfoBtn=findViewById(R.id.bottom_bar_myself_btn);
        tv_home= findViewById(R.id.bottom_bar_text_home);
        tv_list= findViewById(R.id.bottom_bar_text_list);
        tv_myInfo= findViewById(R.id.bottom_bar_text_myself);
        iv_home= findViewById(R.id.bottom_bar_image_home);
        iv_list= findViewById(R.id.bottom_bar_image_list);
        iv_myInfo= findViewById(R.id.bottom_bar_image_myself);
    }
    private void initBodyLayout(){
        mBodyLayout= findViewById(R.id.main_body);
    }

    /**
     * 控件的点击事件
     */
    @Override
    public void onClick(View v){
        switch(v.getId()){
            //课程的点击事件
            case R.id.bottom_bar_home_btn:
                clearBottomImageState();
                selectDisplayView(0);
                break;
            //订单的点击事件
            case R.id.bottom_bar_list_btn:
                clearBottomImageState();
                selectDisplayView(1);
                break;
            //个人中心的点击事件
            case R.id.bottom_bar_myself_btn:
                clearBottomImageState();
                selectDisplayView(2);
                break;
        }
    }
    /**
     * 设置底部三个按钮的点击监听事件
     */
    private void setListener(){
        for(int i=0;i<mBottomLayout.getChildCount();i++){
            mBottomLayout.getChildAt(i).setOnClickListener(this);
        }
    }
    /**
     * 清除底部按钮的选中状态
     */
    private void clearBottomImageState(){
        tv_home.setTextColor(Color.parseColor("#666666"));
        tv_list.setTextColor(Color.parseColor("#666666"));
        tv_myInfo.setTextColor(Color.parseColor("#666666"));
        iv_home.setImageResource(R.drawable.main_home_icon);
        iv_list.setImageResource(R.drawable.main_list_icon);
        iv_myInfo.setImageResource(R.drawable.main_myself_icon);
        for(int i=0;i<mBottomLayout.getChildCount();i++){
            mBottomLayout.getChildAt(i).setSelected(false);
        }
    }
    /**
     * 设置底部按钮的选中状态
     */
    private void setSelectedStatus(int index){
        switch(index){
            case 0:
                mHomeBtn.setSelected(true);
                iv_home.setImageResource(R.drawable.main_home_icon_selected);
                tv_home.setTextColor(Color.parseColor("#0097F7"));
                break;
            case 1:
                mListBtn.setSelected(true);
                iv_list.setImageResource(R.drawable.main_list_icon_selected);
                tv_list.setTextColor(Color.parseColor("#0097F7"));
                break;
            case 2:
                mMyInfoBtn.setSelected(true);
                iv_myInfo.setImageResource(R.drawable.main_myself_icon_selected);
                tv_myInfo.setTextColor(Color.parseColor("#0097F7"));
                break;
        }
    }
    /**
     * 移除不需要的视图
     */
    private void removeAllView(){
        for(int i=0;i<mBodyLayout.getChildCount();i++){
            mBodyLayout.getChildAt(i).setVisibility(View.GONE);
        }
    }
    /**
     * 设置界面view的初始化状态
     */
    private void setInitStatus(){
        clearBottomImageState();
        setSelectedStatus(0);
        createView(0);
    }
    /**
     * 显示对应的页面
     */
    private void selectDisplayView(int index){
        removeAllView();
        createView(index);
        setSelectedStatus(index);
    }
    /**
     * 选择视图
     */
    private void createView(int viewIndex){
        switch(viewIndex){
            case 0:
                //首页界面
                break;
            case 1:
                //订单界面
                break;
            case 2:
                //个人中心界面
                break;
        }
    }
}
