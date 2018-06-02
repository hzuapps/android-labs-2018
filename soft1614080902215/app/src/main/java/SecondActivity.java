package androidlabs.hzuapps.edu.soft1614080902215;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {
    private Button Time;
    private Button Length;
    private Button Parities;
    private Button HouseLoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Time=(Button)findViewById(R.id.时间转换);
        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,FouthActivity.class);
                startActivity(intent);
            }
        });

        Length=(Button)findViewById(R.id.长度转换);
        Length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,FifthActivity.class);
                startActivity(intent);
            }
        });

        Parities=(Button)findViewById(R.id.汇率计算);
        Parities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,SixthActivity.class);
                startActivity(intent);
            }
        });

        HouseLoan=(Button)findViewById(R.id.房贷计算);
        HouseLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,SeventhActivity.class);
                startActivity(intent);
            }
        });


    }



}
