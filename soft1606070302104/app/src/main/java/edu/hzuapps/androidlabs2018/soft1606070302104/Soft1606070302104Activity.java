package edu.hzuapps.androidlabs2018.soft1606070302104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Soft1606070302104Activity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1606070302104);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new MyButtonListener() );
    }
    //这个属于一个内部类
    class MyButtonListener implements OnClickListener {
        //
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //创建一个Intent的实例
            Intent intent = new Intent();
            //设置从哪个activity启动哪个activity
            intent.setClass(Soft1606070302104Activity.this, second2Activity.class);
            //把一个值写入到Intent中
            //intent.putExtra("Text", "测试值");
            //启动另一个activity
            Soft1606070302104Activity.this.startActivity(intent);
        }
    }
}
