package com.example.administrator.hzulife.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/1
 *     desc   : 失物招领数据库，将图片的URI保存在数据库中，使用Smartimage获取图片
 *     version: 1.0
 * </pre>
 */
public class RecordDBHelper extends SQLiteOpenHelper {
    //参数说明
    //context:上下文对象
    //name:数据库名称
    //param:factory
    //version:当前数据库的版本，值必须是整数并且是递增的状态
    private static int version=1;
    public RecordDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public RecordDBHelper(Context context, String name, int version)
    {
        this(context,name,null,version);
    }


    public RecordDBHelper(Context context, String name)
    {
        this(context, name, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table record(id integer primary key autoincrement,rName TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
