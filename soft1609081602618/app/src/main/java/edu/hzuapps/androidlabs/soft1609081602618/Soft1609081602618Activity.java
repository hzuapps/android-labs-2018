package com.example.administrator.hzulife;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

public class Soft1609081602618Activity extends AppCompatActivity {
    private RollPagerView mRollviewPager;
    private static final int IMAGE_NEWS_ONE=1;
    private static final int IMAGE_NEWS_TWO=2;
    private static final int IMAGE_NEWS_THREE=3;
    private static final int IMAGE_NEWS_FOUR=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1609081602618);
        RollViewPagerInit();
    }
    public void RollViewPagerInit(){
        mRollviewPager=(RollPagerView) findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        mRollviewPager.setPlayDelay(1000);
        //设置透明度
        mRollviewPager.setAnimationDurtion(500);
        mRollviewPager.setAdapter(new MyNomalAdapter());//设置适配器
        mRollviewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));//设置原点指示器颜色
        mRollviewPager.setOnItemClickListener(new OnItemClickListener() {//设置点击事件
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent();
                intent.setClass(Soft1609081602618Activity.this,SchoolNewsActivity.class);
                switch (position){//判断点击的是哪一张图片，并将图片的内容传递到另一个activity
                    case 0:
                        intent.putExtra("image_news",IMAGE_NEWS_ONE);
                        break;
                    case 1:
                        intent.putExtra("image_news",IMAGE_NEWS_TWO);
                        break;
                    case 2:
                        intent.putExtra("image_news",IMAGE_NEWS_THREE);
                        break;
                    case 3:
                        intent.putExtra("image_news",IMAGE_NEWS_FOUR);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        });
    }
    class MyNomalAdapter extends StaticPagerAdapter{
        private int[]imgs={
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view=new ImageView(container.getContext());//生成Imageview对象
            view.setImageResource(imgs[position]);//设置图片
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }
    }

}
