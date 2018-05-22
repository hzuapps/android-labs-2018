package edu.hzuapps.androidlabs.soft1614080902221;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    //当前玩家的名称，性别和角色
    String strPlayerName = null;
    String strSex = null;
    String strGameCharacters = null;
    //中间1-9个Button组件
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;
    private Button button6 = null;
    private Button button7 = null;
    private Button button8 = null;
    private Button button9 = null;
    //排行榜Button组件
    private Button rankListButton = null;
    //当前玩家信息TextView组件
    private TextView currentPlayerText = null;
    //计时控件TextView
    private TextView timer = null;
    //统计玩家完成游戏的时间
    private int countSec = 0;
    //计时处理Handler和runnable
    private Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            countSec++;
            timer.setText("" + countSec + " S");
            handler.postDelayed(this, 1000);

        }
    };

    //SQLite数据库帮助对象
    private MydatabaseHelper dbHelper = new MydatabaseHelper(Activity3.this, "PlayerStore.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        initCurrentPlayerTextView();                      //在左上角当前显示玩家的信息
        initButton();                                     //实现中间1-9个Button功能
        timer = (TextView) findViewById(R.id.timer);     //获取计时控件
        handler.postDelayed(runnable, 1000);              //实现右上角计时功能
        rankList();                                       //实现本地排行榜Button功能
        networkListButton();
    }


    //显示当前玩家信息
    private void initCurrentPlayerTextView() {
        Intent recIntent = getIntent();//获取Activity2传递过来的玩家信息

        strPlayerName = recIntent.getStringExtra("playerName");
        strSex = recIntent.getStringExtra("sex");
        strGameCharacters = recIntent.getStringExtra("gameCharacters");

        currentPlayerText = findViewById(R.id.currentPlayerText);
        currentPlayerText.setText("玩家：" + strPlayerName + "\n" +
                "性别：" + strSex + "\n" +
                "角色：" + strGameCharacters);


    }

    //9个Button的初始化，并绑定到同一个监听器buttonMonitor
    void initButton() {
        timer = (TextView) findViewById(R.id.timer);
        ButtonMonitor buttonMonitor = new ButtonMonitor();

        button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(buttonMonitor);
        button1.setTag(1);

        button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(buttonMonitor);
        button2.setTag(2);

        button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(buttonMonitor);
        button3.setTag(3);

        button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(buttonMonitor);
        button4.setTag(4);

        button5 = (Button) findViewById(R.id.button_5);
        button5.setOnClickListener(buttonMonitor);
        button5.setTag(5);

        button6 = (Button) findViewById(R.id.button_6);
        button6.setOnClickListener(buttonMonitor);
        button6.setTag(6);

        button7 = (Button) findViewById(R.id.button_7);
        button7.setOnClickListener(buttonMonitor);
        button7.setTag(7);

        button8 = (Button) findViewById(R.id.button_8);
        button8.setOnClickListener(buttonMonitor);
        button8.setTag(8);

        button9 = (Button) findViewById(R.id.button_9);
        button9.setOnClickListener(buttonMonitor);
        button9.setTag(9);


    }

    //实现排行榜功能：跳转到下一个Activity4
    private void rankList() {
        rankListButton = (Button) findViewById(R.id.rankListButton);
        rankListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpIntent = new Intent(Activity3.this, Activity4.class);
                startActivity(jumpIntent);
            }
        });

    }

    private void networkListButton() {
        Button networkListButton = (Button)findViewById(R.id.NetworkListButton);
        networkListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpIntent = new Intent(Activity3.this, Activity5.class);
                startActivity(jumpIntent);
            }
        });
    }

    //强制玩家必须按1-9的数字顺序点击，否则不能消去
    class ButtonMonitor implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int tag = (Integer) v.getTag();

            switch (tag) {
                case 1:
                    button1.setVisibility(View.INVISIBLE);//将Button设为不可见，实现消去功能，下面Button同理
                    break;
                case 2:
                    if (button1.getVisibility() == View.INVISIBLE) { //检测前一个Button是否不可见了（消去），
                        button2.setVisibility(View.INVISIBLE);     //若消去了，才可以消去当前Button
                    } else {

                    }
                    break;
                case 3:
                    if (button2.getVisibility() == View.INVISIBLE) {
                        button3.setVisibility(View.INVISIBLE);
                    } else {

                    }
                    break;
                case 4:
                    if (button3.getVisibility() == View.INVISIBLE) {
                        button4.setVisibility(View.INVISIBLE);
                    } else {

                    }
                    break;
                case 5:
                    if (button4.getVisibility() == View.INVISIBLE) {
                        button5.setVisibility(View.INVISIBLE);
                    } else {

                    }
                    break;
                case 6:
                    if (button5.getVisibility() == View.INVISIBLE) {
                        button6.setVisibility(View.INVISIBLE);
                    } else {

                    }
                    break;
                case 7:
                    if (button6.getVisibility() == View.INVISIBLE) {
                        button7.setVisibility(View.INVISIBLE);
                    } else {

                    }
                    break;
                case 8:
                    if (button7.getVisibility() == View.INVISIBLE) {
                        button8.setVisibility(View.INVISIBLE);
                    } else {
                    }
                    break;
                case 9:
                    if (button8.getVisibility() == View.INVISIBLE) {
                        button9.setVisibility(View.INVISIBLE);
                        //最后一个Button被点击，完成游戏，停止计时
                        handler.removeCallbacks(runnable);
                        //创建名称为PlayerStore.db的数据库
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        //完成游戏后把当前玩家信息和完成游戏用的时间加入数据库
                        db.execSQL("insert into player(playerName,sex,gameCharacters,time) values(?,?,?,?)",
                                new Object[]{strPlayerName, strSex, strGameCharacters, countSec});
                        //提示加入排行榜，也可以说加入数据库
                        Toast.makeText(Activity3.this, "已加入排行榜", Toast.LENGTH_SHORT).show();

                    } else {

                    }
                    break;

            }
        }
    }

}
