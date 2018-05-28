package edu.hauapps.androidlabs.com1614080901133;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {


    private TextView tv_fenshu;
    private TextView tv_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tv_fenshu = (TextView) findViewById(R.id.tv_fenshu);


        Button bt_save = (Button) findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = tv_fenshu.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("text1", text1);
                editor.apply();
                Toast.makeText(GameActivity.this, "分数已提交到排行榜", Toast.LENGTH_LONG).show();
            }
        });

        tv_chat = (TextView) findViewById(R.id.tv_chat);
        tv_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, GradeActivity.class);
                startActivity(intent);
            }
        });

    }
}
