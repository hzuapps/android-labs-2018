package com.example.xjh.myapplicationxu;
//������ʾ��ʼ�Ľ���
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            setContentView(R.layout.my_layout);
            findViewById(R.id.btnStarAnotherAty).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this,AnotherAty.class));
                }
            });


    }
}
