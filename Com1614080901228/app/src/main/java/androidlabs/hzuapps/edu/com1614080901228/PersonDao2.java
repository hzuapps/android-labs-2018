package androidlabs.hzuapps.edu.com1614080901228;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CY on 2018/6/1.
 */

public class PersonDao2 {
    private PersonSQLiteOpenHelper helper;
    //在构造方法里面 完成 helper的初始化
    public PersonDao2(Context context){
        helper = new PersonSQLiteOpenHelper(context);
    }
    //添加一条记录到数据库
    public long add(String name,String number,int money){
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("number", number);
        long id = db.insert("person", null, values);
        db.close();
        return id;
    }
}

