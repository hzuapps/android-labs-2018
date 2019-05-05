package com.example.administrator.hzulife;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.administrator.hzulife.fragment.FleaMarketFragment;
import com.example.administrator.hzulife.fragment.LostFragment;
import com.example.administrator.hzulife.fragment.MainFragment;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/11
 *     desc   : 主页面描述
 *     version: 1.0
 * </pre>
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView lost_bn;
    private ImageView main_bn;
    private ImageView market_bn;
    private FragmentManager fragmentManager;
    private FragmentTransaction begin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
        }
    private void initView(){
        lost_bn= findViewById(R.id.ic_swzl);
        main_bn=findViewById(R.id.ic_main);
        market_bn=findViewById(R.id.ic_tzsc);
        lost_bn.setOnClickListener(this);
        main_bn.setOnClickListener(this);
        market_bn.setOnClickListener(this);
        //初始化fragment对象
        fragmentManager=getFragmentManager();
        main_bn.performClick();//模拟第一次点击
    }
    @Override
    public void onClick(View v) {
        begin=fragmentManager.beginTransaction();//生成事务对象
       //具体判断点击的是哪个按钮
        switch(v.getId()){
            case R.id.ic_main:
                begin.replace(R.id.fragment_layout,new MainFragment());
                break;
            case R.id.ic_swzl:
                begin.replace(R.id.fragment_layout,new LostFragment());
                break;
            case R.id.ic_tzsc:
                begin.replace(R.id.fragment_layout,new FleaMarketFragment());
                break;
                default:
                break;
        }
        begin.commit();
    }
}
