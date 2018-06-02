package com.example.administrator.hzulife.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.hzulife.R;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/1
 *     desc   : 跳蚤市场页面
 *     version: 1.0
 * </pre>
 */
public class FleaMarketFragment extends Fragment {
    ImageView img;
    Button bn_img;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.flea_market_fragment,null);
        Toolbar toolbar=view.findViewById(R.id.toolbar1);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        init(view);
        return view;
    }
    private void init(View view){
       img=view.findViewById(R.id.github);
       bn_img=view.findViewById(R.id.tn_image);
       bn_img.setOnClickListener(new ImageOnclicklistener());

    }
    private class ImageOnclicklistener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String path="http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg";
            Glide.with(getActivity()).load(path).into(img);
            Toast.makeText( getActivity(),"点击成功"+Glide.with(getActivity()).load(path).into(img) ,Toast.LENGTH_SHORT).show();
        }
    }
}
