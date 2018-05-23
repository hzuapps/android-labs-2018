package edu.hzuapps.androidlabs.Com1614080901208;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cnt.textapplication.R;
import com.example.cnt.textapplication.databinding.ActivitySecondBinding;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        SecondActivityVm secondActivityVm = new SecondActivityVm();
        secondActivityVm.setUri(getIntent().getType());
        String text = getSharedPreferences(Com1614080901208Activity.SPKEY,MODE_PRIVATE).getString(getIntent().getStringExtra("bookname"),"");
        secondActivityVm.setText(text);
        binding.setSecondActivityVm(secondActivityVm);
    }
}
