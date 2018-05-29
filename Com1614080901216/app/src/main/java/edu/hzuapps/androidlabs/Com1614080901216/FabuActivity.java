package ezu.hzuapps.androidlabs.Com1614080901216;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anzhuoshiyan.R;

public class FabuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        final EditText editText1=(EditText) findViewById(R.id.zhanghao);
        final EditText editText2=(EditText) findViewById(R.id.mima);
        final EditText editText3=(EditText) findViewById(R.id.dengji);
        Button button=(Button)findViewById(R.id.tijiao);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String zhanghao=editText1.getText().toString();
                String mima=editText2.getText().toString();
                String dengji=editText3.getText().toString();
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("zhanghao",zhanghao);
                editor.putString("mima",mima);
                editor.putString("dengji",dengji);
                editor.apply();
                Toast.makeText(FabuActivity.this,"数据已提交！",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
