package edu.hzuapps.androidlabs.Com1614080901208;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.cnt.textapplication.BR;
import com.example.cnt.textapplication.VM.ImageViewBean;

import edu.hzuapps.androidlabs.Com1614080901208.SecondActivity;

/**
 * Created by cnt on 2018/5/3.
 */

public class ImageViewVM extends BaseObservable {
    public int uri;
    private ImageViewBean imageViewBean;

    public ImageViewVM() {
    }

    @Bindable
    public int getUri() {
        return uri;
    }

    public void setUri(int uri) {
        this.uri = uri;
        notifyPropertyChanged(BR.uri);
    }

    @BindingAdapter("app:uri")
    //这个方法必须是public static的，两个参数，一个是view，一个是app：uri获取到的值
    public static void loadBitmap(final ImageView imageView, final int uri) {
        //可以对值进行一个判断

        Glide.with(imageView.getContext())
                .load(uri)
                .listener(new RequestListener<Integer, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);


    }

    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), SecondActivity.class);
        view.getContext().startActivity(intent);
    }
}
