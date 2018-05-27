package edu.soft1614080902329.password_record;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class soft1614080902329RecordActivity extends AppCompatActivity {
    private SQLiteDatabase DB;
    private int itemCount = 0;
    private String itemMsg;
    private ArrayList msgList = null;
    private ListView LvPassList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902329_record);

        DB = SQLiteDatabase.openOrCreateDatabase(getFilesDir() + "/pass_record_info.db", null);

        LvPassList = findViewById(R.id.pass_list);

        Button newPass = findViewById(R.id.new_pass);
        newPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(soft1614080902329RecordActivity.this, soft1614080902329NewPassActivity.class);
                soft1614080902329RecordActivity.this.startActivity(intent);
            }
        });
        showListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("life","onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("life","onStop");
    }

    @Override
    protected void onPause () {
        super.onPause();
        Log.v("life","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showListView();
        Log.v("life","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("life","onDestroy");
        DB.close();
    }

    public void createTable() {
        String createSql = "create table pass (Pmsg varchar(20),Pusername varchar(20),Ppassword varchar(20))";
        DB.execSQL(createSql);
    }

    private void showListView() {
        msgList = new ArrayList();
        String sql = "select * from pass";
        Cursor cursor;
        try{
            cursor = DB.rawQuery(sql, null);
        }catch (Exception e){
            createTable();
            cursor = DB.rawQuery(sql, null);
        }
        itemCount = cursor.getCount();
        while (cursor.moveToNext()){
            String pmsg = cursor.getString(cursor.getColumnIndex("Pmsg"));
            Log.v("sys",pmsg);
            msgList.add(pmsg);
        }

        LvPassList.setAdapter(new passAdapter());

        LvPassList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView msg = (TextView)view;
                final String strMsg = msg.getText().toString().trim();

                if(!strMsg.isEmpty()){

                    String sql = "select * from pass where Pmsg = ?";
                    Cursor cursor = DB.rawQuery(sql, new String[] {strMsg});
                    cursor.moveToNext();
                    String pUsername = cursor.getString(cursor.getColumnIndex("Pusername"));
                    String pPassword = cursor.getString(cursor.getColumnIndex("Ppassword"));

                    AlertDialog dialog = new AlertDialog.Builder(soft1614080902329RecordActivity.this)
                            .setTitle(strMsg)//设置对话框的标题
                            .setMessage("\n\n" + "用户名:    " + pUsername + "\n\n" + "密    码:    " + pPassword)
                            .setNegativeButton("修改", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setNeutralButton("删除",new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String sql = "delete from pass where Pmsg = ?";
                                    DB.execSQL(sql,new String[] {strMsg});
                                    Toast.makeText(soft1614080902329RecordActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                                    showListView();
                                    dialog.dismiss();
                                }
                            }).create();
                    dialog.show();
                }

            }
        });
    }

    private class passAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemCount + 1;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tvMsg;
            if(convertView == null){
                tvMsg = new TextView(soft1614080902329RecordActivity.this);
            }else {
                tvMsg = (TextView) convertView;
            }
            if(position < itemCount){
                itemMsg = (String) msgList.get(position);
            }else{
                itemMsg = "";
            }
            tvMsg.setText(itemMsg);
            tvMsg.setTextSize(24);
            tvMsg.setPadding(50,20,0,20);
            return tvMsg;
        }
    }

}
