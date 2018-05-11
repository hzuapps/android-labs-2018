package edu.hzuapps.androidlabs.com1614080901137.com1614080901137activity;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static edu.hzuapps.androidlabs.com1614080901137.com1614080901137activity.R.id.fuxiBtn;

public class com1614080901137Activity extends AppCompatActivity {
//    private TextView timeText,dateText,wordText,englishText;
//    private ImageView playVioce;
//    private String mMonth,mDay,mHours,mMinute;
//    private SpeechSynthesizer speechSynthesizer;
//    private KeyguardManager km;
//    private KeyguardManager.KeyguardLock k1;
//    private RadioGroup radioGroup;
//    private RadioButton radioOne,radioTwo,radioThree;
//    private SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor = null;
//    int j = 0;
//    List<Integer> list;
//    List<CET4Entity> datas;
//    int k;
//    float x1 = 0;
//    float y1 = 0;
//    float x2 = 0;
//    float y2 = 0;
//    private SQLiteDatabase db;
//    private DaoMaster mDaomaster,dbMaster;
//    private DaoSession mDaoSession,dbSession;
//    private CET4EntityDao quetionDao,dbDao;
//    public com1614080901137Activity() {
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901137);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

    final Activity thisActivity = this;
            Button btnHome = (Button)findViewById(R.id.fuxiBtn);
            btnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(thisActivity, second_Activity.class);
                    thisActivity.startActivity(intent);

                }
            });

}
}

