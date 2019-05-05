package androidlabs.hzuapps.edu.soft1606081301318;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String[] imgList = {};
    private RollPagerView mRollViewPager;
    private TextView picTitle ;
    private String imgUrl_List[] = new String [5];
    public static MainActivity mInstance;
    public int idArr[] = new int[10];
    public String new_IdArr[] = new String[50];
    private String[] titleList = {"","","","",""};
    private RecyclerView mInfoList;
    private ArrayList<ItemBean> mDatas;
    private InfoListAdapter adapter;
    private int otherdate=0;
    private RequestQueue mQueue;
    private RequestQueue mNewsQueue;
    private dbHelper helper;
    private ItemBean ib;
    public static String DB_NAME="news";
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

        helper = new dbHelper(MainActivity.this,DB_NAME,null,1);

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();


        initNewsData();
        initNewsList();

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
        boolean Cached = checkCache("news_hot");
        if(Cached){
            Log.i("CACHED", "news_hot iscached ");
            mRollViewPager.setAdapter(new RVNormalAdapter(imgUrl_List));
            mRollViewPager.setHintView(new ColorPointHintView(mInstance, Color.BLACK,Color.WHITE));
            return;
        }
        OkHttpClient mOkHttpClient=new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder().url("https://news-at.zhihu.com/api/4/news/hot");
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= mOkHttpClient.newCall(request);

        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                String sbody;
                if (null != response.cacheResponse()) {
                } else {
                        sbody = response.body().string();
                        Gson gson_ = new Gson();
                        NewsGson g_data = gson_.fromJson(sbody, NewsGson.class);
                        List<NewsGson.RecentBean> dataList = g_data.getRecent();
                        for (int i = 0; i < 5; i++) {
                            NewsGson.RecentBean gr = dataList.get(i);
                            imgUrl_List[i] = gr.getThumbnail();
                            titleList[i] = gr.getTitle();
                            idArr[i] = gr.getNews_id();
                            helper.insert(""+ gr.getNews_id(), gr.getTitle(), gr.getThumbnail(),"https://news-at.zhihu.com/api/4/news/" + gr.getNews_id(),"news_hot");

                        }


                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRollViewPager.setAdapter(new RVNormalAdapter(imgUrl_List));
                        mRollViewPager.setHintView(new ColorPointHintView(mInstance, Color.BLACK,Color.WHITE));
                    }
                });
            }
        });

    }

    public void initNewsList(){

        mDatas=new ArrayList<>();
        getInfoFromNet();

        mInfoList= (RecyclerView) findViewById(R.id.infolist);
        mInfoList.setLayoutManager(new LinearLayoutManager(this));
        adapter=new InfoListAdapter(mDatas,MainActivity.this);
        adapter.setOnItemClickListener(new InfoListAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(mInstance,ContentActivity.class);
                intent.putExtra("NewsId",""+ new_IdArr[position]);
                startActivity(intent);
            }
        });
        mInfoList.setAdapter(adapter);

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
            view.setOnClickListener(new View.OnClickListener()
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



    private void getInfoFromNet(){
        boolean Cached = checkCache("news_list");
        if(Cached){
            Log.i("CACHED", "news_list iscached ");
            return;
        }
        mQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://news-at.zhihu.com/api/4/news/latest" , null, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                SQLiteDatabase db1 = helper.getWritableDatabase();
                try {
                    JSONArray list = null;
                    try {
                        list = response.getJSONArray("stories");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < list.length(); i++) {

                        JSONObject item = list.getJSONObject(i);
                        JSONArray images = item.getJSONArray("images");
                        ItemBean listItem = new ItemBean();
                        listItem.setTitle(item.getString("title"));
                        listItem.setImgurl(images.getString(0));
                        new_IdArr[i] = item.getString("id");

                        helper.insert(item.getString("id"), item.getString("title"), images.getString(0),"https://news-at.zhihu.com/api/4/news/" + item.getString("id"),"news_list");
                        mDatas.add(listItem);

                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(jsonObjectRequest);
    }

    private boolean checkCache(String tags){
        Cursor cursor = helper.select(tags);
        boolean isCache = false;
        int i = 0;
        if(cursor.moveToFirst()){
            do{
                String id=cursor.getString(cursor.getColumnIndex("news_id"));
                String title=cursor.getString(cursor.getColumnIndex("title"));
                String img_url=cursor.getString(cursor.getColumnIndex("thumbnail"));
                if(id !="" && title !="" && img_url !=""){
                    isCache = true;
                }
                if(i<5 && tags == "news_hot") {
                    imgUrl_List[i] = img_url;
                    titleList[i] = title;
                    idArr[i] = Integer.parseInt(id);
                }
                if(i<8 && tags == "news_list") {
                    new_IdArr[i] = id;
                    ib = new ItemBean();
                    ib.setTitle(title);
                    ib.setImgurl(img_url);
                    mDatas.add(ib);
                }
                i++;
            }while(cursor.moveToNext());
        }
        return isCache;
    }


}
