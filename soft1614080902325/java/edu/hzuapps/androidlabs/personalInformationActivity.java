package edu.hzuapps.androidlabs.soft1614080902325;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTargetFactory;

public class personalInformationActivity extends AppCompatActivity {
    private ImageView tv_11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        tv_11=findViewById(R.id.tv_11);
        Glide.with(this).load("http://p8.qhmsg.com/dr/217_214_/t01fe2c1732a6a9a83d.jpg").into((ImageView) tv_11);
    }



}
