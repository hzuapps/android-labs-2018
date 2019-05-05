package edu.hzuapps.androidlabs.wangzhe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class WangZheLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_zhe_log);
        ImageButton btn2 = (ImageButton)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //跳转至WangZheLog
                Intent iten = new Intent(WangZheLog.this,GameStart.class);
                startActivity(iten);
            }
        });

    }
}
