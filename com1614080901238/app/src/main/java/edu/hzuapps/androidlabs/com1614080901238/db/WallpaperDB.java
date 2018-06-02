package edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 陈梓聪 on 2018/5/19.
 */

public class WallpaperDB extends SQLiteOpenHelper {

    private static final String CREATE_WALLPAPER = "create table wallpaper_content (" +
            "id integer primary key autoincrement," +
            "title text," +
            "comment_id  integer)";
    private static final String CREATE_COMMENT = "create table comment (" +
            "id integer primary key autoincrement," +
            "comment_id integer," +
            "comment_text text)";
    private Context mContext;

    public WallpaperDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_WALLPAPER);
        db.execSQL(CREATE_COMMENT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
