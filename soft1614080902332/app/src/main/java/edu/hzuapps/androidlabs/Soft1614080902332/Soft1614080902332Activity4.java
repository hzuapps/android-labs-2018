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
