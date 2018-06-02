package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



//显示玩家最高分数，并且只能显示十个分数，其它的全部删除
public class ScoreDataBase extends SQLiteOpenHelper{
    static final  String CREATE_TABLE = "create table score("+
            //玩家名字为主键
            "playername text primary key,"+
            "playscore integer)";
    //static final int version = 1;
    public ScoreDataBase(Context context,String dbname,int version){
        super(context,dbname,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists score");
        onCreate(db);
    }

}
