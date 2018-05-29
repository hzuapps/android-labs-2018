package com.example.administrator.hzulife.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.hzulife.R;
/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/11
 *     desc   : 失物招领页面
 *     version: 1.0
 * </pre>
 */
public class LostFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_lost,null);
        return view;
    }
}
