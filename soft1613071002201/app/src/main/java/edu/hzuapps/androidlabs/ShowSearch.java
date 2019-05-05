package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ShowSearch extends AppCompatActivity {

    MyDatabaseHelper dbHelper=new MyDatabaseHelper(ShowSearch.this,"cloth",null,1);
    String string1,string2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_search);

        Intent intent=getIntent();
        string1=intent.getStringExtra("name");
        string2=intent.getStringExtra("description");

        TextView textName=(TextView)findViewById(R.id.nameShow);
        textName.setText(string1);
        TextView textDescription=(TextView)findViewById(R.id.descriptionShow);
        textDescription.setText(string2);

        TextView btn2=(TextView) findViewById(R.id.textDelete);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db2=dbHelper.getWritableDatabase();
                db2.delete("textinfo","name=?",new String[]{string1});
                Toast.makeText(ShowSearch.this,"已删除名为"+string1+"的搭配",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
