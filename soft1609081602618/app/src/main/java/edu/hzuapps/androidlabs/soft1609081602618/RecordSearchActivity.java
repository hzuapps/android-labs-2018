package com.example.administrator.hzulife;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hzulife.util.RecordDBHelper;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/1
 *     desc   : 历史搜索功能描述
 *     version: 1.0
 * </pre>
 */
public class RecordSearchActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView mSearch;
    private Context mContext;
    private RecordDBHelper rdb=new RecordDBHelper(this,"hzu");//初始化数据库
    private SQLiteDatabase db;
    private EditText et_search;
    private BaseAdapter adapter;
    private TextView tv_tip;
    private TextView tv_clear;
    private ImageView mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_search);
        init();
    }
    //初始化
    private void init(){
        et_search=findViewById(R.id.et_search);
        tv_tip=findViewById(R.id.tv_tip);
        mContext=RecordSearchActivity.this;
        mSearch=findViewById(R.id.lv_search);
        tv_clear=findViewById(R.id.tv_clear);
        mBack=findViewById(R.id.search_back);
        mBack.setOnClickListener(this);
        tv_clear.setOnClickListener(this);
        et_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //实现字符串的自动匹配-模糊查询
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().trim().length() == 0) {
                    tv_tip.setText("搜索历史");
                } else {
                    tv_tip.setText("搜索结果");
                }
                String tempName = et_search.getText().toString();
                // 根据tempName去模糊查询数据库中有没有数据
                queryData(tempName);
            }
        });
        et_search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {//回车发生事件
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
                            getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    boolean ishave =isHave(et_search.getText().toString().trim());
                    if(ishave){//如果数据存在的话
                        //将数据发送到服务器并进行显示,跳转
                    }else{
                        insertData(et_search.getText().toString().trim());
                    }
                }
                return false;
            }
        });
        //设置listview点击事件
        mSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Android.R.id.text1是在安卓SDK中预定义的布局文件中的控件
                TextView tv=findViewById(android.R.id.text1);
                String data=tv.getText().toString().trim();
                et_search.setText(data);
            }
        });
    }
    //模糊查询
    private  void queryData(String tempName) {
        Cursor cursors = rdb.getReadableDatabase().rawQuery(
                "select id as _id,rName from record where rName like "+" '%" + tempName + "%' " +"order by id desc ", null);
        // 设置适配器
        adapter = new SimpleCursorAdapter(RecordSearchActivity.this, android.R.layout.simple_list_item_1, cursors, new String[] { "rName" },
                new int[] { android.R.id.text1 }, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        mSearch.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    //查找数据是否存在
    private boolean isHave(String name){
        db=rdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM record WHERE rName=?",new String[]{name});
        return cursor.moveToNext();
    }
    /**
     * 清空数据
     */
    private void deleteData() {
        db = rdb.getWritableDatabase();
        db.execSQL("delete from record");
        db.close();
    }
    /**
     * 插入数据
     */
    private void insertData(String rname){
        db=rdb.getWritableDatabase();
        db.execSQL("INSERT INTO record(rName) VALUES (?) ",new String[]{rname});
        db.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_back:
                finish();
                break;
            case R.id.tv_clear:
                //清空历史记录
                deleteData();
                queryData("");
                break;
        }
    }
}
