package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity {
    //private ScoreDataBase scoreDataBase;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ScoreDataBase scoreDataBase = new ScoreDataBase(this,"database",4);

        SQLiteDatabase dbread = scoreDataBase.getWritableDatabase();
        //scoreDataBase.onCreate(dbread);
        Cursor cursor=dbread.rawQuery("select* from score order by playscore desc",null);
        String PlayName;//得到玩家名
        int PlayScore;//得到玩家得分
        int TopTen=1;//玩家排名
        cursor.moveToFirst();
        TextView showup=findViewById(R.id.showText);
        String Tmp="\t";
        do{
            PlayName=cursor.getString(cursor.getColumnIndex("playername"));
            PlayScore=cursor.getInt(cursor.getColumnIndex("playscore"));
            Tmp=Tmp+TopTen+"\t\t\t"+PlayName+"\t\t\t\t"+PlayScore+"\n\t";
            TopTen++;
        }while(cursor.moveToNext());
        showup.setText(Tmp);
        showup.setTextSize(40);
        cursor.close();
        //dbread.execSQL("drop table score");
        dbread.close();

        button = findViewById(R.id.Return);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
