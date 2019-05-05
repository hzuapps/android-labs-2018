package com.example.admin.com1614080901217;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2018/5/24.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String name = "count.db";

    private static final int version = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists bianqian(id integer primary key autoincrement," +
                "title text,content text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
