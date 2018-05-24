# 第五次实验
## 1.实验目标
+ 掌握在Android App中的数据库存储
## 2.实验结果
先 创建一个数据库的连接类吧
```java
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
```
创建一个类，类似于数据库映射的思想，创建一个pojo类
```java
public class BianQian {
    private Integer id;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public BianQian(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```
然后初始化数据（即添加数据），再从数据库中读取出来
```java
    private void initDB() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        writableDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i = 1; i < 20; i++) {
            values.put("title", "标题" + i);
            values.put("content", "这是第" + i + "个美好的季节！");
            writableDatabase.insert("bianqian", null, values);
            values.clear();
        }

    }

    private void initData() {
        bianQianList = new ArrayList<>();
        listContent =  new ArrayList<>();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        writableDatabase = databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.query("bianqian", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                bianQian = new BianQian(id, title, content);
                bianQianList.add(bianQian);

            } while (cursor.moveToNext());
            cursor.close();
        }
        for (int i = 0; i < bianQianList.size(); i++) {

            listContent.add(bianQianList.get(i).getTitle());
        }
    }

}
```

![](https://github.com/MoxinHuoHuo/android-labs-2018/blob/master/com1614080901217/%E6%88%AA%E5%9B%BE/1527168567(1).png)
![](https://github.com/MoxinHuoHuo/android-labs-2018/blob/master/com1614080901217/%E6%88%AA%E5%9B%BE/1527168586(1).png)

## 3.实验体会
这次实验是连接数据库的实验，上网找了几篇博客，看了下之后，就对着敲代码就可以创建连接数据的类了，之后基于自己的便签应用，做了简单的对数据库的读取，然后
显示到activity上，点击跳转后，再把title对应的content传到另一个activity的textView中显示出来。能力有限吧，就做成这个样子就好了，其他的功能，还是要慢慢的学习吧。
