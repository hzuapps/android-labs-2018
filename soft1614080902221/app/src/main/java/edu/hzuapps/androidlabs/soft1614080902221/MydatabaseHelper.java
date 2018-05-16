package edu.hzuapps.androidlabs.soft1614080902221;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MydatabaseHelper extends SQLiteOpenHelper {

    //sql创建表语句
    public static final String CREATE_PLAYER = "create table player ("
            + "id integer primary key autoincrement,"
            + "playerName text,"
            + "sex text,"
            + "gameCharacters text,"
            + "time integer)";
    private Context mContext;

    public MydatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建一个player表
        db.execSQL(CREATE_PLAYER);
        //提示创建表成功
        Toast.makeText(mContext, "Create succeed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}