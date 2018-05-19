# 第5次实验

## 1.实验目标
掌握在Android App中存储数据

## 2.实验内容
应用数据存储可采用数据库存储。

1.将应用产生的数据存储到数据库中；

2.使用UML类图描述表结构；

3.将应用运行结果截图。

## 3.实验步骤
#### 1.打开Soft1614080902332Activity3.java，添加如下代码：

package edu.hzuapps.androidlabs.Soft1614080902332;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Soft1614080902332Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity3);

        final Soft1614080902332Activity3 thisActivity = this;

        final Button btn3 = (Button) findViewById(R.id.button3);
        final Button btn2 = (Button) findViewById(R.id.button2);
        //final Button btn = (Button) findViewById(R.id.button);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btn3)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity1.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

        // 保存失物信息
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btn2)) {
                    thisActivity.saveObject();
                }
            }
        });

    }

    // 保存失物信息
    private void saveObject(){
        String name = ((EditText) findViewById(R.id.editText1)).getText().toString();
        String time = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String place = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String phone = ((EditText) findViewById(R.id.editText4)).getText().toString();

        // 插入新记录
        ContentValues lostObject = new ContentValues();

        lostObject.put(Soft1614080902332Activity4.NAME, name);
        lostObject.put(Soft1614080902332Activity4.TIME, time);
        lostObject.put(Soft1614080902332Activity4.PLACE, place);
        lostObject.put(Soft1614080902332Activity4.PHONE, phone);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(Soft1614080902332Activity4.CONTENT_URI, lostObject);

        Toast.makeText(getBaseContext(),
                "上传成功！ \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showObjectInfo("", "", "", ""); // 清除内容
    }

    private void showObjectInfo(String name, String time, String place, String phone) {
        ((EditText) findViewById(R.id.editText1)).setText(name);
        ((EditText) findViewById(R.id.editText2)).setText(time);
        ((EditText) findViewById(R.id.editText3)).setText(place);
        ((EditText) findViewById(R.id.editText4)).setText(phone);
    }

}



#### 2.新建Soft1614080902332Activity4.java，添加如下代码：

package edu.hzuapps.androidlabs.Soft1614080902332;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashMap;

public class Soft1614080902332Activity4 extends ContentProvider {

    static final String PROVIDER_NAME = "edu.hzuapps.androidlabs.Soft1614080902332";
    static final String URL = "content://" + PROVIDER_NAME + "/objects";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String NAME = "name";
    static final String TIME = "time";
    static final String PLACE = "place";
    static final String PHONE = "phone";

    static final int OBJECTS = 1;
    static final int OBJECT_ID = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "objects", OBJECTS);
        uriMatcher.addURI(PROVIDER_NAME, "objects/#", OBJECT_ID);
    }

    // 数据库相关操作
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "LostObjects";
    static final String TABLE_OBJECTS = "objects";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_OBJECTS +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " time TEXT NOT NULL," +
                    " place TEXT NOT NULL," +
                    " phone TEXT NOT NULL);";

    /**
     * 用于创建数据库的帮助类
     */
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_OBJECTS);
            onCreate(db);
        }
    }

    private static HashMap<String, String> OBJECTS_PROJECTION_MAP;

    public Soft1614080902332Activity4() {
    }

    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case OBJECTS:
            return "vnd.android.cursor.dir/objects";
        case OBJECT_ID:
            return "vnd.android.cursor.item/objects";

        default:
            throw new IllegalArgumentException("Unsupported URI: " + uri);
    }
    }

    // 插入|保存一条记录
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_OBJECTS, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("无法插入数据 " + uri);
    }

    // 初始化内容提供器
    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        // 创建可写的数据库（如果没有则新建）
        db = dbHelper.getWritableDatabase();
        return (db == null) ? false : true;
    }

    // 查询记录
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(TABLE_OBJECTS);

        switch (uriMatcher.match(uri)) {
            case OBJECTS:
                qb.setProjectionMap(OBJECTS_PROJECTION_MAP);
                break;

            case OBJECT_ID:
                qb.appendWhere(_ID + "=" + uri.getPathSegments().get(1));
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        if (sortOrder == null || sortOrder == "") {
            sortOrder = NAME;
        }
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case OBJECTS:
                count = db.update(TABLE_OBJECTS, values, selection, selectionArgs);
                break;

            case OBJECT_ID:
                count = db.update(TABLE_OBJECTS, values, _ID + " = " + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case OBJECTS:
                count = db.delete(TABLE_OBJECTS, selection, selectionArgs);
                break;

            case OBJECT_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_OBJECTS, _ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}



#### 3.运行测试。

## 4.实验结果
UML类图：

![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/008.png)

运行结果：

![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/006.png)
![image](https://github.com/QFJay/android-labs-2018/blob/master/soft1614080902332/007.png)

## 5.实验体会
本次实验对我来说是难度很大的一次实验，花了整整一天时间完成这次实验，实验过程中学到不少。


