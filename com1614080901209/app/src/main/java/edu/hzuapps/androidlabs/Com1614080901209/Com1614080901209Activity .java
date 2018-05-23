package edu.hzuapps.androidlabs.Com1614080901209;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.com1614080901209.R;

import java.util.Random;

public class Com1614080901209Activity extends AppCompatActivity implements View.OnClickListener {

    Button button_start;
    Button button_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901209);

        button_start = (Button) findViewById(R.id.game_start);
        button_exit = (Button) findViewById(R.id.game_exit);

        button_start.setOnClickListener(this);
        button_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.game_start:
                SharedPreferences.Editor pref=getSharedPreferences("data",MODE_PRIVATE).edit();
                pref.putInt("ramdomNumber",(Math.abs(new Random().nextInt())%100));
                pref.apply();

                Intent intent = new Intent(Com1614080901209Activity.this,SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.game_exit:
                finish();
                break;
            default:
                break;
        }
    }
}
