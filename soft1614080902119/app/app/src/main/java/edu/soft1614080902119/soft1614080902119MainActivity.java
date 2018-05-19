package edu.soft1614080902119;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity; // 注意这里我们导入的V4的包，不要导成app的包了
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 主页面内容
 */
public class soft1614080902119MainActivity extends FragmentActivity implements View.OnClickListener {
    // 初始化顶部栏显示
    private ImageView titleLeftImv;
    private TextView titleTv;
    // 定义4个Fragment对象
    private soft1614080902119management_Fragment mange;
    private soft1614080902119query_Fragment query;
    // 帧布局对象，用来存放Fragment对象
    private FrameLayout frameLayout;
    private FrameLayout m_frameLayout;
    // 定义每个选项中的相关控件
    private RelativeLayout first_La;
    private RelativeLayout second_La;
    private RelativeLayout m_z_l;
    private RelativeLayout m_s_l;
    private ImageView management_image;
    private ImageView query_image;
    private TextView management_text;
    private TextView query_text;
    // 定义几个颜色
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int dark = 0xff000000;

    // 定义FragmentManager对象管理器
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        initView(); // 初始化界面控件
        setChioceItem(0); // 初始化页面加载时显示第一个选项卡

    }

    /**
     * 初始化页面
     */
    private void initView() {
// 初始化页面标题栏
        titleLeftImv = (ImageView) findViewById(R.id.title);
        titleTv = (TextView) findViewById(R.id.title_text);
// 初始化底部导航栏的控件
        management_image = (ImageView) findViewById(R.id.management_image);
        query_image = (ImageView) findViewById(R.id.query_image);

        management_text = (TextView) findViewById(R.id.management_text);
        query_text= (TextView) findViewById(R.id.query_text);

        first_La = (RelativeLayout) findViewById(R.id.first_La);
        second_La = (RelativeLayout) findViewById(R.id.second_La);

        frameLayout = (FrameLayout) findViewById(R.id.content);

        first_La.setOnClickListener(this);
        second_La.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_La:
                setChioceItem(0);
                break;
            case R.id.second_La:
                setChioceItem(1);
                break;
            default:
                break;
        }
    }
    /**
     * 设置点击选项卡的事件处理
     * @param index 选项卡的标号：0, 1
     */
    private void setChioceItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clearChoice(); // 清空, 重置选项, 隐藏所有Fragment
        hideFragments(fragmentTransaction);
        switch (index) {
            case 0:
// firstImage.setImageResource(R.drawable.XXXX); 需要的话自行修改
                management_text.setTextColor(dark);
                first_La.setBackgroundColor(gray);
// 如果fg1为空，则创建一个并添加到界面上
                if (mange == null) {
                    mange = new soft1614080902119management_Fragment();
                    fragmentTransaction.add(R.id.content, mange);
                } else {
// 如果不为空，则直接将它显示出来
                    fragmentTransaction.show(mange);
                }
                break;
            case 1:
// secondImage.setImageResource(R.drawable.XXXX);
                query_text.setTextColor(dark);
                second_La.setBackgroundColor(gray);
                if (query == null) {
                    query = new soft1614080902119query_Fragment();
                    fragmentTransaction.add(R.id.content,query);
                } else fragmentTransaction.show(query);
                break;
        }
        fragmentTransaction.commit(); // 提交
    }
    /**
     * 当选中其中一个选项卡时，其他选项卡重置为默认
     */
    private void clearChoice() {
// firstImage.setImageResource(R.drawable.XXX);
        management_text.setTextColor(gray);
        first_La.setBackgroundColor(whirt);
// secondImage.setImageResource(R.drawable.XXX);
        query_text.setTextColor(gray);
        second_La.setBackgroundColor(whirt);
    }
    /**
     * 隐藏Fragment
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (mange != null) {
            fragmentTransaction.hide(mange);
        }
        if (query != null) {
            fragmentTransaction.hide(query);
        }
    }
}
