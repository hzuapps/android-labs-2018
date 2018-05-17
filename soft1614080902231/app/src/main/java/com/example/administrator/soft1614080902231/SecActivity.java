package com.example.administrator.soft1614080902231;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;
public class SecActivity extends Activity implements View.OnClickListener{
    /**
     * 顶部内容栏
     */
    private LinearLayout mTopLayout;
    private TextView tv_china;
    private TextView tv_england;
    private TextView tv_spanish;
    private TextView tv_nab;
    /**
     *
     * 中间内容栏,还没有编写
     */
    private FrameLayout mBodylayout;
    /*
    底部内容栏
     */
    public LinearLayout mBottomLayout;
    private View mCharacter;
    private View mPlay;
    private TextView tv_characetr;
    private TextView tv_play;
    private ImageView iv_wenzi;
    private ImageView iv_bofang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
          init();
          setListener();
          setInitStatues();
          setTopStatues(0);
    }
    private void init()//给控件赋值
    {
               mTopLayout=(LinearLayout)findViewById(R.id.mToplayout);
               tv_china=(TextView)findViewById(R.id.china);
               tv_england=(TextView)findViewById(R.id.england);
               tv_spanish=(TextView)findViewById(R.id.spanish);
               tv_nab=(TextView)findViewById(R.id.NBA);
               mBottomLayout=(LinearLayout) findViewById(R.id.mBottomLayout);
               mCharacter = findViewById(R.id.mCharacter);
               mPlay = findViewById(R.id.mPlay);
               tv_characetr = (TextView) findViewById(R.id.tv_character);
               tv_play = (TextView) findViewById(R.id.tv_play);
               iv_wenzi = (ImageView) findViewById(R.id.iv_wenzi);
               iv_bofang = (ImageView)findViewById(R.id.iv_bofang);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mCharacter:
                clearBottom();
                setSelectStatues(0);
                break;
            case R.id.mPlay:
                clearBottom();
                setSelectStatues(1);
                break;
            case R.id.china:
                clearTop();
                setTopStatues(0);
                break;
            case R.id.england:
                clearTop();
                setTopStatues(1);
                break;
            case R.id.spanish:
                clearTop();
                setTopStatues(2);
                break;
            case R.id.NBA:
                clearTop();
                setTopStatues(3);
                break;
            default:
        break;
        }
    }
    private void setTopStatues(int index)
    {
        switch (index)
        {
            case 0:
                mTopLayout.setSelected(true);
                tv_china.setTextColor(Color.parseColor("#0097F7"));
                break;
            case 1:
                mTopLayout.setSelected(true);
                tv_england.setTextColor(Color.parseColor("#0097F7"));
                break;
            case 2:
                mTopLayout.setSelected(true);
                tv_spanish.setTextColor(Color.parseColor("#0097F7"));
                break;
            case 3:
                mTopLayout.setSelected(true);
                tv_nab.setTextColor(Color.parseColor("#0097F7"));
                break;
        }
    }
    /*
    添加点击事件
     */
    private void setListener()
    {
    for(int i=0;i<mBottomLayout.getChildCount();i++)
        mBottomLayout.getChildAt(i).setOnClickListener(this);
    for(int i=0;i<mTopLayout.getChildCount();i++)
        mTopLayout.getChildAt(i).setOnClickListener(this);
    }
    private void clearBottom()
    {

        tv_play.setTextColor(Color.parseColor("#666666"));
        tv_characetr.setTextColor(Color.parseColor("#666666"));
        iv_bofang.setImageResource(R.drawable.nis);
        iv_wenzi.setImageResource(R.drawable.ni);
        for(int i=0;i<mBottomLayout.getChildCount();i++)
            mBottomLayout.getChildAt(i).setSelected(false);
    }
    private void clearTop()
    {
        tv_china.setTextColor(Color.parseColor("#666666"));
        tv_england.setTextColor(Color.parseColor("#666666"));
        tv_spanish.setTextColor(Color.parseColor("#666666"));
        tv_nab.setTextColor(Color.parseColor("#666666"));
        for(int i=0;i<mTopLayout.getChildCount();i++)
            mTopLayout.getChildAt(i).setSelected(false);
    }
    private void setSelectStatues(int index)
    {
        switch (index)
        {
            case 0:
                mCharacter.setSelected(true);
                tv_characetr.setTextColor(Color.parseColor("#0097F7"));
                break;
            case 1:
                mPlay.setSelected(true);
                tv_play.setTextColor(Color.parseColor("#0097F7"));
                break;

        }
    }
    private void setInitStatues()
    {
        clearBottom();
        setSelectStatues(0);
    }
    /*
    设置初始状态值
     */

}
