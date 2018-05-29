package androidlabs.hzuapps.edu.soft1614080902335;

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


public class UserInformationProvider extends ContentProvider {

    static final String PROVIDER_NAME = "androidlabs.hzuapps.edu.user";
    static final String URL = "content://" + PROVIDER_NAME + "/user";
    static final Uri CONTENT_URI = Uri.parse(URL);

    static final String _ID = "_id";
    static final String Area="area";
    static final String NAME = "name";
    static final String Sex= "sex";

    static final int USER = 1;
    static final int USER_ID = 2;

    static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "user", USER);
        uriMatcher.addURI(PROVIDER_NAME, "user/#", USER_ID);
    }

    // 数据库相关操作
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "User";
    static final String TABLE_USER = "UserInformation";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + TABLE_USER +
                    " (_id TEXT PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " sex TEXT NOT NULL, " +
                    " area TEXT NOT NULL);";

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
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            onCreate(db);
        }
    }

    private static HashMap<String, String> USER_NAME_MAP;

    public UserInformationProvider() {
    }

    @Override
    public String getType(Uri uri) {switch (uriMatcher.match(uri)){
        case USER:
            return "vnd.android.cursor.dir/user";
        case USER_ID:
            return "vnd.android.cursor.item/user";

        default:
            throw new IllegalArgumentException("Unsupported URI: " + uri);
    }
    }

    // 插入|保存一条记录
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(TABLE_USER, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("无法插入数据 " + uri);
    }

    //更新数据

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
        qb.setTables(TABLE_USER);

        switch (uriMatcher.match(uri)) {
            case USER:
                qb.setProjectionMap(USER_NAME_MAP);
                break;

            case USER_ID:
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

    //更新数据
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case USER:
                count = db.update(TABLE_USER, values, selection, selectionArgs);
                break;

            case USER_ID:
                count = db.update(TABLE_USER, values, _ID + " = " + uri.getPathSegments().get(1) +
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
            case USER:
                count = db.delete(TABLE_USER, selection, selectionArgs);
                break;

            case USER_ID:
                String id = uri.getPathSegments().get(1);
                count = db.delete(TABLE_USER, _ID + " = " + id +
                        (!TextUtils.isEmpty(selection) ? " AND (" + selection + ')' : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}
