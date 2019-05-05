package ezu.hzuapps.androidlabs.Com1614080901216;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.anzhuoshiyan.R;

public class ChakanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chakan);
        final EditText editText1=(EditText) findViewById(R.id.zhanghao1);
        final EditText editText2=(EditText) findViewById(R.id.mima1);
        final EditText editText3=(EditText) findViewById(R.id.dengji1);
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String zhanghao=pref.getString("zhanghao","");
        String mima=pref.getString("mima","");
        String dengji=pref.getString("dengji","");
        editText1.setText(zhanghao);
        editText2.setText(mima);
        editText3.setText(dengji);
    }
}
