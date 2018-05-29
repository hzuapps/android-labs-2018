package edu.hzuapps.androidlabs.Com1614080901208;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by cnt on 2018/5/12.
 */

public class MainRVViewMode {
    private RVBean myBean;

    public MainRVViewMode(RVBean rvBean){
        this.myBean=rvBean;
    }

    public void setUri(String uri){
        myBean.setUri(uri);
    }

    public void setText(String text){
        myBean.setText(text);
    }

    public ObservableField<String> getText(){
        return myBean.getText();
    }

    public ObservableField<String> getUri(){
        return myBean.getUri();
    }

    //等下要从网络加载图片
    @BindingAdapter("app:uri")
    public static void setImag(ImageView imag , String uri){
        if (uri!=null){
            Glide.with(imag.getContext())
                    .load(uri)
                    .into(imag);
        }
    }

}
