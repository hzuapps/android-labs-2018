package edu.hzuapps.androidlabs.Com1614080901222;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.imagic.com1614080901222.R;

public class Com1614080901222Activity extends AppCompatActivity {

    public static final String TAG = Com1614080901222Activity.class.getSimpleName();
    private Button musicButton;
    private boolean musicValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901222);

        initData();

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Com1614080901222Activity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Com1614080901222Activity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        musicButton = findViewById(R.id.musicButton);
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences read = getSharedPreferences("user_info", MODE_PRIVATE);
                musicValue = read.getBoolean("musicValue", true);
                if(musicValue) musicValue = false;
                else musicValue = true;

                SharedPreferences.Editor editor = getSharedPreferences("user_info", MODE_PRIVATE).edit();
                if (musicValue) musicButton.setText("游戏音效           开");
                else musicButton.setText("游戏音效           关");
                editor.putBoolean("musicValue", musicValue);
                editor.commit();
                Log.i(TAG, "onClick: 使用SharedPreferences保存游戏音效的设置 music=" + musicValue);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initData();
    }

    private void initData() {
        //创建一个SharedPreferences接口对象
        SharedPreferences read = getSharedPreferences("user_info", MODE_PRIVATE);
        musicValue = read.getBoolean("musicValue", true);

        musicButton = findViewById(R.id.musicButton);
        if (musicValue) musicButton.setText("游戏音效           开");
        if (!musicValue) musicButton.setText("游戏音效           关");
        Log.i(TAG, "initData: musicValue=" + musicValue);
    }


}
