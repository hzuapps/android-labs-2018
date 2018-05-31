package com.example.luoji;

import java.util.ArrayList;

import com.example.beans.Cuns;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/*
 * 专门用来数据库操作的类，这个类的建立是非常正确的，把所有的数据库操作都放到了这里来，其他直接调用就好了。
 * 数据的增，删，改，查，都在这里实现
 */
public class MyDataBase {
	Context context;
	MyOpenHelper myHelper;
	SQLiteDatabase myDatabase;
	/*
	 * 别的类实例化这个类的同时，创建数据库
	 */
	public MyDataBase(Context con){
		this.context=con;
		myHelper=new MyOpenHelper(context);
	}
	/*
	 * 得到填充ListView用的array数据，从数据库里查找后解析。第一个界面调用
	 */
	public ArrayList<Cuns> getArray(){
		ArrayList<Cuns> array=new ArrayList<Cuns>();
		ArrayList<Cuns> array1=new ArrayList<Cuns>();
		myDatabase=myHelper.getWritableDatabase();
		Cursor cursor=myDatabase.rawQuery("select ids,title,times from mybook" , null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			int id=cursor.getInt(cursor.getColumnIndex("ids"));
			String title=cursor.getString(cursor.getColumnIndex("title"));
			String times=cursor.getString(cursor.getColumnIndex("times"));
			Cuns cun=new Cuns(id, title, times);
			array.add(cun);
			cursor.moveToNext();
		}
		myDatabase.close();
		for (int i = array.size(); i >0; i--) {
			array1.add(array.get(i-1));
		}
		return array1;		
	}
	
	/*
	 * 返回可能要修改的数据，第二个界面调用。
	 */
	public Cuns getTiandCon(int id){
		myDatabase=myHelper.getWritableDatabase();
		Cursor cursor=myDatabase.rawQuery("select title,content from mybook where ids='"+id+"'" , null);
		cursor.moveToFirst();
		String title=cursor.getString(cursor.getColumnIndex("title"));
		String content=cursor.getString(cursor.getColumnIndex("content"));
		Cuns cun=new Cuns(title,content);
		myDatabase.close();
		return cun;
	}
	/*
	 * 第二个界面调用，用来修改日记
	 */
	public void toUpdate(Cuns cun){
		myDatabase=myHelper.getWritableDatabase();
		myDatabase.execSQL("update mybook set title='"+ cun.getTitle()+"',times='"+cun.getTimes()+"',content='"+cun.getContent() +"' where ids='"+ cun.getIds()+"'");
		myDatabase.close();
	}
	/*
	 *第二个界面调用，用来增加新的日记
	 */
	public void toInsert(Cuns cun){
		myDatabase=myHelper.getWritableDatabase();
		myDatabase.execSQL("insert into mybook(title,content,times)values('"+ cun.getTitle()+"','"+cun.getContent()+"','"+cun.getTimes()+"')");
		myDatabase.close();
	}
	/*
	 * 第一个界面调用，长按点击后选择删除日记
	 */
	public void toDelete(int ids){
		myDatabase=myHelper.getWritableDatabase();
		myDatabase.execSQL("delete  from mybook where ids="+ids+"");
		myDatabase.close();
	}
}
