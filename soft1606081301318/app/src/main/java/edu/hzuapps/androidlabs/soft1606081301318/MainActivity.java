package androidlabs.hzuapps.edu.soft1606081301318;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String[] imgList = {};
    private RollPagerView mRollViewPager;
    private TextView picTitle ;
    private String imgUrl_List[] = new String [5];
    public static MainActivity mInstance;
    public int idArr[] = new int[10];
    private String[] titleList = {"","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        picTitle = (TextView)findViewById(R.id.text);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);
        mRollViewPager.setPlayDelay(2000);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new RVNormalAdapter(imgList));
        mRollViewPager.setHintView(new ColorPointHintView(mInstance, Color.BLACK,Color.WHITE));

        initNewsData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initNewsData() {

        OkHttpClient mOkHttpClient=new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder().url("https://news-at.zhihu.com/api/3/news/hot");
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= mOkHttpClient.newCall(request);

        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String sbody;
                if (null != response.cacheResponse()) {
                } else {
                    sbody = response.body().string();
                    Gson gson_ = new Gson();
                    NewsGson g_data = gson_.fromJson(sbody,NewsGson.class);
                    List<NewsGson.RecentBean> dataList = g_data.getRecent();
                    for (int i = 0; i < 5; i++) {
                        NewsGson.RecentBean gr = dataList.get(i);
                        imgUrl_List[i] = gr.getThumbnail();
                        titleList[i] = gr.getTitle();
                        idArr[i] = gr.getNews_id();
                    }
                    mRollViewPager.setAdapter(new RVNormalAdapter(imgUrl_List));
                    mRollViewPager.setHintView(new ColorPointHintView(mInstance, Color.BLACK,Color.WHITE));
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });

    }

    public void setRVTitle(int cur){

        switch (cur){
            case 1:
                picTitle.setText(titleList[0]);
                break;
            case 2:
                picTitle.setText(titleList[1]);
                break;
            case 3:
                picTitle.setText(titleList[2]);
                break;
            case 4:
                picTitle.setText(titleList[3]);
                break;
            case 5:
                picTitle.setText(titleList[4]);
                break;

        }
    }

    private class RVNormalAdapter extends StaticPagerAdapter {
        private String[] imgs = {
        };

        public RVNormalAdapter(String[] img_list){

            this.imgs = img_list;
        }


        @Override
        public View getView(ViewGroup container, final int position) {

            final  int picNo = position+1;
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(R.drawable.loading);
            AddbBitmapToView addbBitmapToView=new AddbBitmapToView(view);
            addbBitmapToView.execute(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setOnClickListener(new View.OnClickListener()      // 点击事件
            {
                @Override
                public void onClick(View v)
                {

                    Intent intent = new Intent(mInstance,ContentActivity.class);

                   intent.putExtra("NewsId",""+ idArr[position]);
                    startActivity(intent);


                }

            });
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
