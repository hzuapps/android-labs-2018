package edu.hzuapps.androidlabs.soft1614080902125;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

import static edu.hzuapps.androidlabs.soft1614080902125.RW_file_musiclist.readListFromSdCard;

public class locallist_Fragment extends Fragment {


    private ListView mMusiclist;                   //音乐列表
    private SimpleAdapter mAdapter;
    private List<HashMap<String, String>> mp3Infos;
    private HashMap<String, Object> map;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        //为ListView添加数据源


        return inflater.inflate(R.layout.main_locallist, container, false);

    }

    public void onStart() {
        super.onStart();

        if(!RW_file_musiclist.fileIsExists("list_localmusic")) {
            mMusiclist = getActivity().findViewById(R.id.list_music_local);

                mp3Infos = RW_file_musiclist.readListFromSdCard("list_localmusic");  //获取歌曲对象集合
                setListAdapter(mp3Infos);


        }
    }

    public void setListAdapter(List<HashMap<String, String>> mp3list) {


            mAdapter = new SimpleAdapter( this.getActivity().getApplicationContext(), mp3list,
                R.layout.music_item, new String[]{"number","title","check_music",
                "Artist", "music_menu"}, new int[]{R.id.number, R.id.music_title,
                R.id.music_Artist, R.id.music_menu});
                mMusiclist.setAdapter(mAdapter);
    }


}

