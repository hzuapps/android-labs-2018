package com.example.administrator.soft1614080902231;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;


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
     * 中间内容栏
     */
    private FrameLayout mBodylayout;
    private ArrayAdapter<String> adapter;
    private ListView listView;
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
    private String[] data = { "中超第一轮精彩回放", "中超第二轮精彩回放", "中超第三轮精彩回放", "中超第四轮精彩回放","中超第五轮精彩回放" };
    private String[] data1 = { "中超第一轮精彩赛事", "中超第二轮精彩赛事", "中超第三轮精彩赛事", "中超第四轮精彩赛事","中超第五轮精彩赛事" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
          init();
          setListener();
          setInitStatues();
          setTopStatues(0);
          String msg=read();
          refreshRecord(msg);
          listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  String msg = adapter.getItem(position).toString();
                  if (!msg.isEmpty())
                      write(msg);
                  msg = read();
                  Toast.makeText(SecActivity.this,msg,Toast.LENGTH_SHORT).show();
                  refreshRecord(msg);
                  Intent intent = new Intent(SecActivity.this, ThreeActivity.class);
                  startActivity(intent);
              }
          });
    }
    /*
    数据读取，读取最后一次观看的记录     */
    public String read() {
        try {
            FileInputStream inStream = this.openFileInput("record.txt");
            byte[] buffer = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder();
            while ((hasRead = inStream.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, hasRead));
            }
            inStream.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    数据写入，写入最后一次观看的记录
     */
    public void write(String msg){
        // 步骤1：获取输入值
        if(msg == null) return;
        try {
            // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
            FileOutputStream fos = openFileOutput("record.txt",
                    MODE_PRIVATE);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    添加最后一次浏览的信息
     */
    private void refreshRecord(String msg)
    {
        TextView tv_record=(TextView)findViewById(R.id.record);
        String s = tv_record.getText().toString();
        tv_record.setText(read());
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
               listView = (ListView)findViewById(R.id.ni);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mCharacter:
                adapter = new ArrayAdapter<String>(
                        SecActivity.this, android.R.layout.simple_list_item_1, data1);

                listView.setAdapter(adapter);
                clearBottom();
                setSelectStatues(0);
                break;
            case R.id.mPlay:
                 adapter = new ArrayAdapter<String>(
                        SecActivity.this, android.R.layout.simple_list_item_1, data);

                listView.setAdapter(adapter);
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
                adapter = new ArrayAdapter<String>(
                        SecActivity.this, android.R.layout.simple_list_item_1, data1);
                listView = (ListView) findViewById(R.id.ni);
                listView.setAdapter(adapter);
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
