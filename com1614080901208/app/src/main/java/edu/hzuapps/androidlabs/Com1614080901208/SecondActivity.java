package edu.hzuapps.androidlabs.Com1614080901208;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cnt.textapplication.R;
import com.example.cnt.textapplication.VM.SecondActivityVm;
import com.example.cnt.textapplication.databinding.ActivitySecondBinding;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);

        SecondActivityVm secondActivityVm = new SecondActivityVm();
        secondActivityVm.setUri(R.drawable.mainactivitybackground);
        secondActivityVm.setText("      《动物世界》是2010年4月1日航空工业出版社出版的图书，作者是郭漫。该书介绍了生物界形形色色的各种有趣动物，以全新的视角及准确、生动的文字带你进入动物的世界。");
        binding.setSecondActivityVm(secondActivityVm);
    }
}
