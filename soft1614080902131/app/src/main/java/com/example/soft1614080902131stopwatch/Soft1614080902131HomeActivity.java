package com.example.soft1614080902131stopwatch;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.litepal.tablemanager.Connector;
import org.w3c.dom.Text;

import java.nio.channels.NonReadableChannelException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class Soft1614080902131HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView timer1TextView;
    private TextView recordTextView;
    private TextView changeBackgroundTextView;
    private ImageView backgroundImageView;
    private boolean isOldBackgroundFlag=true;

    private android.os.Handler handler=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    Glide.with(Soft1614080902131HomeActivity.this)
                            .load("http://sjbz.fd.zol-img.com.cn/t_s1080x1920c/g5/M00/00/02/ChMkJ1fJVDOIaq8OAAdmrY1k4PQAAU9vgKneYMAB2bF789.jpg")
                            .centerCrop()
                            .into(backgroundImageView);

                    break;
                case 2:
                    Glide.with(Soft1614080902131HomeActivity.this)
                            .load("http://sjbz.fd.zol-img.com.cn/t_s1080x1920c/g5/M00/05/0D/ChMkJ1myURyIcWL0AAXIZtwWvIEAAgSQQJ3DjUABch-255.jpg")
                            .centerCrop()
                            .into(backgroundImageView);
                    break;
            }
        }
    };

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
        changeBackgroundTextView=(TextView)findViewById(R.id.change_background_text_view);
        backgroundImageView=(ImageView)findViewById(R.id.home_background_image_view);

        timer1TextView.setOnClickListener(this);
        recordTextView.setOnClickListener(this);
        changeBackgroundTextView.setOnClickListener(this);

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

            case R.id.change_background_text_view:
                if (isOldBackgroundFlag==true){
                    Message message=new Message();
                    message.what=1;
                    handler.sendMessage(message);
                    isOldBackgroundFlag=false;
                }
                else{
                    Message message=new Message();
                    message.what=2;
                    handler.sendMessage(message);
                    isOldBackgroundFlag=true;
                }
                break;
        }
    }
}
