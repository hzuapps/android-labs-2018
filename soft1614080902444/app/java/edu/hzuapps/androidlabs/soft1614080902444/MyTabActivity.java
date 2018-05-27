package edu.hzuapps.androidlabs.soft1614080902444;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MyTabActivity extends TabActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost_activity);


        TabHost tabHost1=getTabHost();
        Intent intent1=new Intent();
        intent1.setClass(this,MessageActivity.class);
        TabHost.TabSpec  spec1= tabHost1.newTabSpec("消息");
        Resources resources1 =getResources();
        spec1.setIndicator("消息",resources1.getDrawable(R.drawable.xiaoxi));
        spec1.setContent(intent1);
        tabHost1.addTab(spec1);




       TabHost tabHost2=getTabHost();
        Intent intent2=new Intent();
        intent2.setClass(this,TestActivity.class);
        TabHost.TabSpec  spec2= tabHost1.newTabSpec("互动");
        Resources resources2 =getResources();
        spec2.setIndicator("互动",resources2.getDrawable(R.drawable.lianxiren));
        spec2.setContent(intent2);
        tabHost2.addTab(spec2);



        TabHost tabHost3=getTabHost();
        Intent intent3=new Intent();
        intent3.setClass(this,HudongActivity.class);
        TabHost.TabSpec  spec3= tabHost1.newTabSpec("动态");
        Resources resources3 =getResources();
        spec3.setIndicator("动态",resources3.getDrawable(R.drawable.dongtai));

        spec3.setContent(intent3);
        tabHost3.addTab(spec3);
    }
}
