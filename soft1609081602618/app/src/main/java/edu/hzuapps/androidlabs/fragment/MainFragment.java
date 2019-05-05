package com.example.administrator.hzulife.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.administrator.hzulife.R;
import com.example.administrator.hzulife.SchoolNewsActivity;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/11
 *     desc   : 主页面fragment
 *     version: 1.0
 * </pre>
 */
public class MainFragment extends Fragment {
    private RollPagerView mRollviewPager;
    private Context context;
    private static final int IMAGE_NEWS_ONE=1;
    private static final int IMAGE_NEWS_TWO=2;
    private static final int IMAGE_NEWS_THREE=3;
    private static final int IMAGE_NEWS_FOUR=4;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_soft1609081602618,null);
        context=getActivity();
        RollViewPagerInit();
        return view;
    }

    /**
     * 轮播图
     */
    public void RollViewPagerInit(){
        mRollviewPager= view.findViewById(R.id.roll_view_pager);
        //设置播放时间间隔
        mRollviewPager.setPlayDelay(1000);
        //设置透明度
        mRollviewPager.setAnimationDurtion(500);
        mRollviewPager.setAdapter(new MyNomalAdapter());//设置适配器
        mRollviewPager.setHintView(new ColorPointHintView(context, Color.YELLOW,Color.WHITE));//设置原点指示器颜色
        mRollviewPager.setOnItemClickListener(new OnItemClickListener() {//设置点击事件
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent();
                intent.setClass(context,SchoolNewsActivity.class);
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
    class MyNomalAdapter extends StaticPagerAdapter {
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
