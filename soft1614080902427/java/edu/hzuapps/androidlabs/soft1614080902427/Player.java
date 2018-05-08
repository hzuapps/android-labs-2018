package edu.hzuapps.androidlabs.soft1614080902427;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;


public class Player extends Activity implements View.OnClickListener {
    private static final int READ_REQUEST_CODE = 42;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        this.setStatusBarTranslucent(true);

        ArrayList<SongItem> items = new ArrayList<>();

        items.add(new SongItem("后来", "刘若英"));
        items.add(new SongItem("无情的雨无情..", "齐秦"));
        items.add(new SongItem("伤心太平洋", "任贤齐"));
        items.add(new SongItem("灰姑娘", "郑钧"));
        items.add(new SongItem("当爱已成往事", "张国荣"));
        items.add(new SongItem("小芳", "李春波"));
        items.add(new SongItem("恋恋风尘", "老狼"));
        items.add(new SongItem("勇气", "梁静茹"));
        items.add(new SongItem("当爱已成往事", "林忆莲"));
        items.add(new SongItem("风雨无阻", "周华健"));

        listView = (ListView) findViewById(R.id.songList);
        final SongAdapter adapter = new SongAdapter(this, R.id.songList, items);
        //设置ListView的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Player.this, "click:" + id, Toast.LENGTH_LONG).show();
                view.setSelected(true); //被点击的 View 设置 selected 状态
            }
        });

        listView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {

    }

    //设置透明状态栏(沉浸式状态栏)
    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }


    class SongAdapter extends ArrayAdapter<SongItem> {//SongItem 与 ListView 的适配器
        private ArrayList<SongItem> items; //保存整个列表
        private SongViewHolder songItemHolder; //临时的holder

        //SongViewHolder，临时存放View
        private class SongViewHolder {
            TextView songName;
            TextView singerName;
        }

        //SongAdapter 简单的初始化
        public SongAdapter(Context context, int resource, ArrayList<SongItem> items) {
            super(context, resource, items);
            this.items = items;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {//?
            View v = convertView;

            if (v == null) {//如果特定位置的 view是null的，那么填充它，然后用songItemHolder进行关联
                LayoutInflater vi = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.song_list_item, null);

                songItemHolder = new SongViewHolder();
                songItemHolder.singerName = (TextView) v.findViewById(R.id.singer_name);
                songItemHolder.songName = (TextView) v.findViewById(R.id.song_name);

                //tag主要用来存放与View有关联的数据
                v.setTag(songItemHolder);

            } else {//直接用v.getTag()获取songItemHolder
                songItemHolder = (SongViewHolder) v.getTag();
            }

            //根据位置获取songItem
            SongItem songItem = items.get(pos);

            //对songItemHolder进行赋值，也就是给对应的TextView设置文本
            if (songItem != null) {
                songItemHolder.songName.setText(songItem.getSongName());
                songItemHolder.singerName.setText(songItem.getSingerName());
            }
            //返回被展示的View
            return v;
        }
    }
}


class SongItem {//歌曲 类

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    private String songName;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    private String singerName;

    public SongItem(String songName, String singerName) {
        this.songName = songName;
        this.singerName = singerName;
    }
}