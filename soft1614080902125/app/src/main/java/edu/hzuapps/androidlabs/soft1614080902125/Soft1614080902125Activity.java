package edu.hzuapps.androidlabs.soft1614080902125;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import edu.hzuapps.androidlabs.soft1614080902125.R;

public class Soft1614080902125Activity extends AppCompatActivity {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

   private TabLayout.Tab one;
    private TabLayout.Tab two;
    /*private ListView mMusiclist;                   //音乐列表
    private SimpleAdapter mAdapter;
    private List<HashMap<String, String>> mp3Infos;
    private HashMap<String, Object> map;
**/

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        setContentView(R.layout.activity_soft1614080902125);
        ImageView imageView = new ImageView(this);
        ImageView add_view = findViewById(R.id.imageView_add);
        ImageView seek_view = findViewById(R.id.imageView_seek);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        imageView.setPadding(5,5,5,5);
        super.onCreate(savedInstanceState);
       //ViewPager pager = findViewById(R.id.viewPager);
        //mMusiclist = pager.findViewById(R.id.list_music_local);

        /*if(!RW_file_musiclist.fileIsExists("list_localmusic")) {
            mp3Infos = RW_file_musiclist.readListFromSdCard("list_localmusic");  //获取歌曲对象集合
            setListAdapter(mp3Infos);
        }*/

        add_view.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, add_music.class);
                thisActivity.startActivity(intent);

            }
        });

        seek_view.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, seek_music.class);
                thisActivity.startActivity(intent);

            }
        });

        initViews();
    }

    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);




    }

    /*public void setListAdapter(List<HashMap<String, String>> mp3list) {


        mAdapter = new SimpleAdapter(this, mp3list,
                R.layout.music_item, new String[]{"number","title","check_music",
                "Artist", "music_menu"}, new int[]{R.id.number, R.id.music_title,
                R.id.music_Artist, R.id.music_menu});
        mMusiclist.setAdapter(mAdapter);
    }*/


}