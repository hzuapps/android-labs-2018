package androidlabs.hzuapps.edu.soft1606081301318;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbHelper extends SQLiteOpenHelper {

    private final static String TABLE  =
            " CREATE TABLE news" +
            " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " news_id CHAR(20) NOT NULL," +
            " title CHAR(100) NOT NULL, " +
            " thumbnail CHAR(100) NOT NULL DEFAULT \"http://s6.sinaimg.cn/mw690/003x41sogy6Nk0BvdSl35&690\", " +
            " news_url CHAR(100) NOT NULL, " +
            " tags TEXT NOT NULL);";

    public dbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "DROP TABLE IF EXISTS news;";
        db.execSQL(sql);
        db.execSQL(TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String id, String title,String thumbnail,String news_url,String tag){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv =new ContentValues();
        cv.put("news_id",id);
        cv.put("title",title);
        cv.put("thumbnail",thumbnail);
        cv.put("news_url",news_url);
        cv.put("tags",tag);
        db.insert("news", null, cv);
    }

    public Cursor select(String tags) {
        SQLiteDatabase db = this.getReadableDatabase();
        String limitNum;
        if(tags == "news_hot"){
            limitNum = null;
        }else{
            limitNum = null;
        }
        String[] selectionArgs = { tags };
        Cursor cursor = db
                .query("news", null, "tags=?", selectionArgs, null, null, limitNum);
        return cursor;
    }



}