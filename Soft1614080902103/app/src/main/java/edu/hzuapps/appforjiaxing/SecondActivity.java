
package edu.hzuapps.appforjiaxing;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.ArrayAdapter;


import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class SecondActivity extends AppCompatActivity {

    private final String TAG = SecondActivity.class.getSimpleName();
    private Context mContext;

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //根据id找到事先声明好的listview
        ListView listView = (ListView) findViewById(R.id.lvSongs );

        //定义一个数组，存放列表的项
        String[] names={"张三","李四","王五","赵六","田七"};

        //定义adapter (适配器), 搭建listview和数据的通路
        //第一个参数是当前的activity，第二个参数是列表项的布局，android.R.layout.simple_list_item_1 是android自带的一个简单的布局，只有一个文本框，这里直接拿来使用
        //第三个参数是含有数据的数组，用来填充列表项的布局
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);

        //为listview设置adapter
        listView.setAdapter(arrayAdapter);

        saveData(names);

        String[] anotherNames = readData();
        // do something
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public void saveData(String[] data){
        // 获取需要写入的文件
        File f = new File("/mnt/sdcard","data.txt");
        try{
            FileWriter writer = new FileWriter(f);
            for(int i=0;i<data.length;i++){
                writer.write(data[i]);
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }catch (IOException e){
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    public String[] readData(){
        LinkedList<String> list = new LinkedList<>();
        File f = new File("/mnt/sdcard","data.txt");
        try{
            FileReader reader = new FileReader(f);
            BufferedReader br = new BufferedReader(reader);
            String temp;
            while( (temp=br.readLine())!=null){
                list.add(temp);
            }
        }catch (IOException e){
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
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

    @RequiresApi(api = Build.VERSION_CODES.FROYO)
    private File getPrivateExtStorageDir(String dirName) {
        File file = new File(mContext.getExternalFilesDir(null), dirName);
        if (!file.mkdirs()) {
            Log.e(TAG, "目录无法创建!");
        }
        return file;
    }
}