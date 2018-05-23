package com.example.intelligentcooker.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.intelligentcooker.HeadActivity;
import com.example.intelligentcooker.MyMealActivity;
import com.example.intelligentcooker.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @author henyiwu
 * @date 2017/11/18
 */

public class Page3Fragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.page3_layout, container, false);
        CircleImageView head = mView.findViewById(R.id.circle_head);
        /**
         * 设置监听器，点击“我的菜谱”选项后跳转到“我的菜谱”界面
         * 可查看我添加的所有菜谱
         */
        LinearLayout myMeal = mView.findViewById(R.id.my_meal);
        myMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyMealActivity.class);
                startActivity(intent);
            }
        });
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HeadActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.head_in,R.anim.head_out);
            }
        });
        return mView;
    }

}
