package edu.hzuapps.androidlabs.soft1614080902221;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Activity4 extends AppCompatActivity {

    //用ArrayList存放所有玩家数据，作为数据源
    private List<PlayerData> playerDataList = new ArrayList<PlayerData>();
    //SQLite数据库帮助对象
    private MydatabaseHelper dbHelper = new MydatabaseHelper(Activity4.this, "PlayerStore.db", null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        //查询数据库并初始化数据源playerDataList
        sqlPlayerData();
        //通过id找到RecyclerView组件对象
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //创建一个LinearLayoutManager对象
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置recyclerView的布局方式为LinearLayout
        recyclerView.setLayoutManager(linearLayoutManager);
        //创建适配器，并将playerDataList传入PlayerDataAdapter的构造函数中
        PlayerDataAdapter playerDataAdapter = new PlayerDataAdapter(playerDataList);
        //给recyclerView设置适配器
        recyclerView.setAdapter(playerDataAdapter);

    }

    private void sqlPlayerData() {
        //打开名称为PlayerStore.db的数据库
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //SQL查询：按时间升序查询所有玩家记录
        Cursor cursor = db.rawQuery("select * from player order by time asc", null);
        if (cursor.moveToFirst()) {
            do {
                String strPlayerName = cursor.getString(cursor.getColumnIndex("playerName"));
                String strSex = cursor.getString(cursor.getColumnIndex("sex"));
                String strGameCharacters = cursor.getString(cursor.getColumnIndex("gameCharacters"));
                int intTime = cursor.getInt(cursor.getColumnIndex("time"));
                //把查询的每一条玩家数据建一个PlayerData对象
                PlayerData playerData = new PlayerData(strPlayerName, strSex, strGameCharacters, intTime);
                //把新建的PlayerData对象存进List中
                playerDataList.add(playerData);


            } while (cursor.moveToNext());


        }
        cursor.close();

    }
}
