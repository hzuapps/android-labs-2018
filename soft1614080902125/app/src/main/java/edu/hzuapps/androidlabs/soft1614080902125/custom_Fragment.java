
package edu.hzuapps.androidlabs.soft1614080902125;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import edu.hzuapps.androidlabs.soft1614080902125.R;

public class custom_Fragment extends Fragment {

    private ListView mMusiclist;                   //音乐列表
    private SimpleAdapter mAdapter;
    private List<HashMap<String, String>> mp3Infos;
    private HashMap<String, Object> map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_custom, container, false);
    }

    public void onStart() {
        super.onStart();

        }
    }



