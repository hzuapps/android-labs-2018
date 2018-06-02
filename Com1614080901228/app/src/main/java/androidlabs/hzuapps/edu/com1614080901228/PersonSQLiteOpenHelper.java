package androidlabs.hzuapps.edu.com1614080901228;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by CY on 2018/6/1.
 */

public class PersonSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "PersonSQLiteOpenHelper";
    // 数据库的构造方法  用来定义数据库的名称 数据库查询的结果集 数据库的版本
    public PersonSQLiteOpenHelper(Context context) {
        super(context, "person.db", null, 3);
    }
    public void onCreate(SQLiteDatabase db) {
        //初始化数据库的表结构
        db.execSQL("create table person (id integer primary key autoincrement, name varchar(20), number varchar(20)) ");
    }
    // 当数据库的版本号发生变化的时候(增加的时候)调用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"数据库的版本变化了...");
    }
}

