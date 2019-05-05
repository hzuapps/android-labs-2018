package edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.adapter.ItemContentAdapter;
import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.db.WallpaperDB;
import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.entity.ItemContent;

public class WallpaperItemActivity extends AppCompatActivity {

    private ItemContent itemContent;
    private List<String> comments;
    private ItemContentAdapter adapter;
    private RecyclerView commentRV;
    private WallpaperDB wallpaperDB;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wallpaper_item_activity);
        initData();
        initView();
    }


    private void initData() {
        itemContent = (ItemContent) getIntent().getSerializableExtra("itemContent");
        comments = itemContent.getComnent();
    }

    private void initView() {
        TextView title = (TextView) findViewById(R.id.item_title);
        final EditText editText = findViewById(R.id.RV_item_edit);
        Button commentButton = (Button) findViewById(R.id.comment_button);
        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

        initRV();


        title.setText(itemContent.getTitle());
        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = editText.getText().toString();
                if (!"".equals(comment)) {
                    comments.add(comment);
                    adapter.notifyItemInserted(comments.size() - 1);
                    commentRV.scrollToPosition(comments.size() - 1); //定位到最后一行
                    editText.setText("");

                    //添加到数据库
                    wallpaperDB = new WallpaperDB(WallpaperItemActivity.this, "wallpaper.db", null, 1);
                    db = wallpaperDB.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("comment_id", itemContent.getId());
                    values.put("comment_text", comment);
                    db.insert("comment", null, values);
                    //使scrollView的焦点到最下
                    Handler handler = new Handler();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //设置ScrollView滚动到底部
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);


                        }
                    });

                }

            }
        });

    }

    private void initRV() {
        commentRV = findViewById(R.id.item_RV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        commentRV.setLayoutManager(layoutManager);
        adapter = new ItemContentAdapter(comments);
        commentRV.setAdapter(adapter);

    }
}
