package com.example.intelligentcooker.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.intelligentcooker.HeadActivity;
import com.example.intelligentcooker.MainActivity;
import com.example.intelligentcooker.adapter.GridViewAdapter;
import com.example.intelligentcooker.R;
import com.example.intelligentcooker.widget.MyGridView;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 底部栏点击时候切换到的的第一个碎片
 * @author henyiwu
 * @date 2017/11/18
 */
public class Page1Fragment extends Fragment {

    TextSliderView textSliderView1;
    TextSliderView textSliderView2;
    TextSliderView textSliderView3;
    TextSliderView textSliderView4;
    TextSliderView textSliderView5;
    TextSliderView textSliderView6;
    ArrayList<HashMap<String, Object>> mList = new ArrayList<>();
    /**
     * 定义图片图标
     */
    private int[] mImageRes = {
            R.drawable.ranking_list,
            R.drawable.cookbook,
            R.drawable.fruit,
            R.drawable.nutrition,
            R.drawable.local,
            R.drawable.soup,
            R.drawable.intelligent,
            R.drawable.forbidden};

    /**
     * 定义图片下方的数组
     */
    private String[] mStrings = {
            "榜单排名",
            "每周菜谱",
            "饭后蔬果",
            "营养菜谱",
            "地方菜系",
            "汤类菜谱",
            "智能选菜",
            "饮食禁忌"
    };
    private View mView;
    /**
     * 推荐菜谱的集合
     */
    private MyGridView mGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.page1_layout, container, false);
        mGridView = mView.findViewById(R.id.grid_view);
        initSlider();
        initGridView();
        return mView;
    }

    /**
     * 初始化轮播图
     */
    private void initSlider() {
        SliderLayout mSliderLayout = mView.findViewById(R.id.slider);
        textSliderView1 = new TextSliderView(getContext());
        textSliderView1
                .description("红烧排骨")
                .image(R.drawable.hongshaopaigu)
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {

                    }
                });
        textSliderView2 = new TextSliderView(getContext());
        textSliderView2
                .description("老上海生煎包")
                .image(R.drawable.shengjianbao)
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(getContext(), "老上海生煎包", Toast.LENGTH_SHORT).show();
                    }
                });
        textSliderView3 = new TextSliderView(getContext());
        textSliderView3
                .description("虾仁娃娃菜")
                .image(R.drawable.wawacai)
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(getContext(), "虾仁娃娃菜", Toast.LENGTH_SHORT).show();
                    }
                });
        textSliderView4 = new TextSliderView(getContext());
        textSliderView4
                .description("红烧肉")
                .image(R.drawable.hongshaorou)
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(getContext(), "红烧肉", Toast.LENGTH_SHORT).show();
                    }
                });
        textSliderView5 = new TextSliderView(getContext());
        textSliderView5
                .description("咖喱鱼蛋")
                .image(R.drawable.galiyudan)
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(getContext(), "咖喱鱼蛋", Toast.LENGTH_SHORT).show();
                    }
                });
        textSliderView6 = new TextSliderView(getContext());
        textSliderView6
                .description("水晶虾饺")
                .image(R.drawable.shuijinxiajiao)
                .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                    @Override
                    public void onSliderClick(BaseSliderView slider) {
                        Toast.makeText(getContext(), "水晶虾饺", Toast.LENGTH_SHORT).show();
                    }
                });
        mSliderLayout.addSlider(textSliderView1);
        mSliderLayout.addSlider(textSliderView2);
        mSliderLayout.addSlider(textSliderView3);
        mSliderLayout.addSlider(textSliderView4);
        mSliderLayout.addSlider(textSliderView5);
        mSliderLayout.addSlider(textSliderView6);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(3000);
    }

    /**
     * 初始化GridView
     */
    private void initGridView() {
        for (int i = 0; i < mImageRes.length; i++) {
            HashMap<String, Object> map = new HashMap<>(2);
            //添加图像资源的ID
            map.put("ItemImage", mImageRes[i]);
            //按序号做ItemText
            map.put("ItemText", mStrings[i]);
            mList.add(map);
        }
        GridViewAdapter gridView = new GridViewAdapter(getActivity(), mList);
        mGridView.setAdapter(gridView);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), mStrings[position], Toast.LENGTH_LONG).show();
            }
        });
    }

}
