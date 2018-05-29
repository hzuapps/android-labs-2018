package ezu.hzuapps.androidlabs.Com1614080901231;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ba.balabdemo.R;
import com.example.ba.balabdemo.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySecondBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        ResultVM vm = new ResultVM(this);
        binding.setResult(vm);
    }
}
