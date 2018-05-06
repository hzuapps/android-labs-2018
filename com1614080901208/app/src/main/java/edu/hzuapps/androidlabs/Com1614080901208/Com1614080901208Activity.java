package edu.hzuapps.androidlabs.Com1614080901208;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.cnt.textapplication.R;
import com.example.cnt.textapplication.VM.ImageViewBean;
import com.example.cnt.textapplication.VM.ImageViewVM;
import com.example.cnt.textapplication.databinding.ActivityMainBinding;


public class Com1614080901208Activity extends AppCompatActivity {
    private int pictureSrc = R.drawable.mainactivitybackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ImageViewBean imageViewBean = new ImageViewBean();


        ImageViewVM imageViewVM = new ImageViewVM();
        imageViewVM.setUri(R.drawable.mainactivitybackground);
        binding.setImageViewVm(imageViewVM);

    }
}
