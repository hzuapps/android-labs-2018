package com.example.soft1614080902227activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UserDBHelper extends SQLiteOpenHelper {
    private static final String DB_name = "mydata.db";
    private static final int version = 1;
    private static final String TABLE_NAME = "user_ino";

    public UserDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sql ="create table user_ino(name varchar(50),number int)";
        db.execSQL(create_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
