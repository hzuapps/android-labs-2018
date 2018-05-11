package edu.hzuapps.androidlabs.com1614080901118;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout s_eyu;
    private LinearLayout s_ruiwen;
    private LinearLayout s_yasuo;
    private LinearLayout s_huangzi;
    private LinearLayout s_timo;
    private LinearLayout s_nuoshou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        s_eyu=(LinearLayout)findViewById(R.id.ll_eyu);
        s_ruiwen=(LinearLayout)findViewById(R.id.ll_ruiwen);
        s_yasuo=(LinearLayout)findViewById(R.id.ll_yasuo);
        s_huangzi=(LinearLayout)findViewById(R.id.ll_huangzi);
        s_timo=(LinearLayout)findViewById(R.id.ll_timo);
        s_nuoshou=(LinearLayout)findViewById(R.id.ll_nuoshou);

        //鳄鱼视频网站
        /* s_eyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                设置对应的点击跳转视频网站，因为还没联网，所以暂时不设置。
            }
        });*/

        //瑞文视频网站
        /* s_ruiwen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                设置对应的点击跳转视频网站，因为还没联网，所以暂时不设置。
            }
        });*/

        //亚索视频网站
        /*s_yasuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                设置对应的点击跳转视频网站，因为还没联网，所以暂时不设置。
            }
        });*/

        //皇子视频网站
        /*s_huangzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                设置对应的点击跳转视频网站，因为还没联网，所以暂时不设置。
            }
        });*/

        //提莫视频网站
        /*s_timo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                设置对应的点击跳转视频网站，因为还没联网，所以暂时不设置。
            }
        });*/

        //诺手视频网站
        /*s_nuoshou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                设置对应的点击跳转视频网站，因为还没联网，所以暂时不设置。
            }
        });*/
    }
}
