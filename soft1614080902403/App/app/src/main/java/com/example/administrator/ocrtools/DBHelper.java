package com.example.administrator.ocrtools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/9/17.
 */
public class DBHelper  extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,name, factory, version);
    }

    public DBHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    public DBHelper(Context context, String name) {
        this(context,name,1);
    }

    //数据库创建（初始化的时候被调用）
    @Override
    public void onCreate(SQLiteDatabase db) {
        //执行语句创建表
        String createTable ="create table personTest(id int,name varchar(10))";
        db.execSQL(createTable);
    }

    //数据库更新的时候被调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}