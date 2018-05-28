package com.example.soft1614080902131stopwatch;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.litepal.tablemanager.Connector;
import org.w3c.dom.Text;

import java.nio.channels.NonReadableChannelException;

public class Soft1614080902131HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView timer1TextView;
    private TextView recordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902131_home);
        init();
        SQLiteDatabase db = Connector.getDatabase();
    }

    private void init(){
        timer1TextView=(TextView) findViewById(R.id.timer_1_intent_text_view);
        recordTextView=(TextView) findViewById(R.id.record_intent_text_view);
        timer1TextView.setOnClickListener(this);
        recordTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.timer_1_intent_text_view:
                intent=new Intent(Soft1614080902131HomeActivity.this,Soft1614080902131Timer1Activity.class);
                startActivity(intent);
                break;

            case R.id.record_intent_text_view:
                intent=new Intent(Soft1614080902131HomeActivity.this,Soft1614080902131RecordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
