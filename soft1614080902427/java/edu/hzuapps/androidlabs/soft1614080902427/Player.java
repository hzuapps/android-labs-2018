package edu.hzuapps.androidlabs.soft1614080902427;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Player extends Activity implements View.OnClickListener {
    private final String TAG = this.getClass().getSimpleName();
    private final static String Host = "https://raw.githubusercontent.com/harytfw/android-labs-2018/master/soft1614080902427";
    private final static String songListURL = Host+"/song.json";


    private ListView listView = null;
    private LocalStorage localStorage;
    private SettingHolder mySetting;
    private FileScanner scanner = new FileScanner();
    private Gson gson = new Gson();
    private int downloadCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        this.setStatusBarTranslucent(true);

        localStorage = new LocalStorage(this);
        listView = (ListView) findViewById(R.id.songList);
        readSetting();
    }


    @Override
    public void onClick(View v) {

    }

    //读取设置
    public void readSetting() {

        mySetting = (SettingHolder) localStorage.readFromJsonFile("data.json", SettingHolder.class);
        if (mySetting == null) {
            mySetting = new SettingHolder();//读取默认设置
        }

        final SongAdapter adapter = new SongAdapter(this, R.id.songList, mySetting.items);
        //设置ListView的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Player.this, "click:" + id, Toast.LENGTH_SHORT).show();
                view.setSelected(true); //被点击的 View 设置 selected 状态
            }
        });
        listView.setAdapter(adapter);

    }

    //保存设置到 data.json
    public void saveSetting() {
        Log.i(TAG, "保存设置到data.json");
        localStorage.writeToJsonFile("data.json", mySetting);
        Toast.makeText(this, "设置已保存", Toast.LENGTH_SHORT).show();
    }

    //创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.simple_menu, menu);
        return true;
    }

    //选项菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_scan:
                mySetting.items = scanner.scan();
                Toast.makeText(this, "扫描完成！", Toast.LENGTH_SHORT).show();
                SongAdapter adapter = (SongAdapter) listView.getAdapter();
                //刷新原有的数据
                adapter.items.clear();
                adapter.items.addAll(mySetting.items);
                adapter.notifyDataSetChanged();
                saveSetting();
                break;
            case R.id.menu_item_setting:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_back:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                break;
            case R.id.menu_item_syncSong:
                this.syncSongList();
                break;
        }
        return true;
    }

    protected void syncSongList() {
        if(!checkNetwork()){
            return;
        }
        makeToast("开始同步歌单");
        Downloader dl =new Downloader(new DownloaderListener() {
            @Override
            public void onError(String url) {
                super.onError(url);
                Log.i(TAG,url+ " 下载失败失败");
                makeToast("url 下载失败失败");
            }

            @Override
            public void onDone(String url, ByteArrayOutputStream out) {
                String json = null;
                try {
                    json = out.toString("utf-8");
                } catch (UnsupportedEncodingException e) {
                    Log.e(TAG,e.toString());
                    json = null;
                }

                if(json==null){
                    makeToast("同步失败");
                    return;
                }

                Log.i(TAG,"歌单JSON："+json);
                makeToast("同步完成，开始解析并下载歌曲文件");

                if(mySetting==null){
                    makeToast("解析歌单信息失败");
                    return;
                }

                mySetting = gson.fromJson(json, SettingHolder.class);
                SongAdapter adapter = (SongAdapter) listView.getAdapter();
                adapter.items.clear();
                adapter.items.addAll(mySetting.items);
                adapter.notifyDataSetChanged();
                saveSetting();

                syncSongFile();
            }
        });
        dl.createTask(this.songListURL);
    }

    protected void syncSongFile(){
        this.downloadCount = mySetting.items.size();
        if(this.downloadCount != 0){
            this.setTitle("文件还在下载...");
        }
        for (SongItem item : mySetting.items) {
            Downloader dl = new Downloader(new DownloaderListener() {
                @Override
                public void onError(String url) {
                    downloadCount--;
                    if(downloadCount==0){
                        setTitle("文件下载完成");
                    }
                    makeToast(url + " 下载出现错误！");
                }
                @Override
                public void onDone(String url, ByteArrayOutputStream baos) {
                    String fileName = url.substring( url.lastIndexOf('/')+1, url.length() );
                    fileName = Uri.decode(fileName);
                    if(baos==null){
                        makeToast(fileName + "下载失败！");
                    }
                    else if(localStorage.writeFile(fileName,baos)) {
                        makeToast(fileName + "下载完成！");
                    }
                    downloadCount--;
                    if(downloadCount==0){
                        setTitle("文件下载完成");
                    }
                }
            });

            String url = Uri.encode(item.getMp3());
            url = this.Host +"/"+ url;
            Log.i(TAG,"开始下载: "+url);
            dl.createTask(url);
        }
    }
    //设置透明状态栏(沉浸式状态栏)
    protected void setStatusBarTranslucent(boolean makeTranslucent) {
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected boolean checkNetwork(){
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // 检查当前激的网络
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean mConnected;
        if (networkInfo != null && networkInfo.isConnected()) {
            mConnected = true;
        } else {
            mConnected = false;
        }

        if(!mConnected){
            makeToast("网络未连接");
            return false;
        }
        else{
            return true;
        }
    }

    class SongAdapter extends ArrayAdapter<SongItem> {//SongItem 与 ListView 的适配器
        private List<SongItem> items; //保存整个列表
        private SongViewHolder songItemHolder; //临时的holder

        //SongViewHolder，临时存放View
        private class SongViewHolder {
            TextView songName;
            TextView singerName;
        }

        //SongAdapter 简单的初始化
        public SongAdapter(Context context, int resource, List<SongItem> items) {
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




    private void makeToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
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
        this(songName, singerName, "");
    }

    private String mp3;

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public SongItem(String songName, String singerName, String mp3) {
        this.songName = songName;
        this.singerName = singerName;
        this.mp3 = mp3;
    }
}

class SettingHolder {
    public List<SongItem> items = null;

    public SettingHolder() {
        items = new ArrayList<>();
    }
}

//模拟的文件扫描类
class FileScanner {
    private List<SongItem> items;

    public FileScanner() {
        items = new ArrayList<SongItem>();
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

    }

    public List<SongItem> scan() {
        List<SongItem> temp = new ArrayList<>();
        temp.addAll(items);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {//随机删除5首歌
            temp.remove(random.nextInt(temp.size()));
        }
        return temp;
    }
}

class LocalStorage {

    private final String TAG = LocalStorage.class.getSimpleName();
    private final Gson gson = new Gson();

    private Context mContext;

    public LocalStorage(Context mContext) {
        this.mContext = mContext;

    }

    public boolean writeToJsonFile(String filename, Object obj) {
        File dir = getPrivateExtStorageDir("");
        File file = new File(dir, filename);
        String json = gson.toJson(obj);
        try {

            FileWriter writer = new FileWriter(file);
            Log.i(TAG, "写入数据: " + file.getAbsolutePath());
            writer.write(json);
            writer.flush();
            writer.close();
            return true;
        } catch (IOException exception) {
            Log.e(TAG, exception.toString());
            return false;
        }
    }

    public Object readFromJsonFile(String filename, Class classType) {
        if (!isExternalStorageReadable()) {
            Log.e(TAG, "外部存储不可读!");
            return false;
        }

        File dir = getPrivateExtStorageDir("");
        File file = new File(dir, filename);
        if (!file.exists()) {
            return null;
        }

        StringBuffer json = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = br.readLine()) != null) {
                json.append(temp);
            }
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            return null;
        }

        Object obj = gson.fromJson(json.toString(), classType);
        return obj;

    }

    public boolean writeFile(String filename,ByteArrayOutputStream baos) {
        return this.writeFile(filename,baos.toByteArray());
    }

    public boolean writeFile(String filename,byte[] data){
        return this.writeFile(filename,data,false);
    }

    public boolean writeFile(String filename,byte[] data,boolean overwrite){
        if (!isExternalStorageWritable()) {
            Log.e(TAG, "外部存储不可写!");
            return false;
        }

        File dir = getPrivateExtStorageDir("");
        File file = new File(dir, filename);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                Log.e( TAG,filename + "创建失败");
            }
        }
        else if(!overwrite){
            return true;
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            return true;
        } catch (FileNotFoundException e) {
            Log.e( TAG,filename + "文件不存在");
            return false;
        }catch (IOException e ){
            Log.e(TAG,filename + "写入失败");
            return false;
        }
    }

    /* Checks if external storage is available for read and write */
    private boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private File getPrivateExtStorageDir(String dirName) {
        File file = new File(mContext.getExternalFilesDir(null), dirName);
        if (!file.exists() && !file.mkdirs()) {
            Log.e(TAG, "目录无法创建!");
        }
        return file;
    }
}
