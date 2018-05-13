package edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import edu.hzuapps.androidlabs.com1614080901238.mostbeautifulwallpaper.adapter.WallpaperAdapter;

public class Com820238114Activity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.com820238114_activity);
        initData();
        initView();
    }


    private void initData() {
        context = getApplicationContext();
    }

    private void initView() {
        initRV();
    }

    private void initRV() {
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rv.setLayoutManager(layoutManager);
        WallpaperAdapter adapter = new WallpaperAdapter(context);
        rv.setAdapter(adapter);
    }
}
