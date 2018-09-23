package com.example.administrator.ocrtools;

import android.Manifest;
import android.annotation.SuppressLint;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import android.content.Intent;
import android.provider.MediaStore;
import android.net.Uri;

import java.io.ByteArrayOutputStream;
import java.io.File;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.os.Environment;

import android.app.Activity;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.json.JSONException;
import org.json.JSONObject;


public class Soft1614080902403DefaultActivity extends AppCompatActivity  {

    public BottomNavigationBar mBottomNavigationBar;
    private Fragment frag1;
    private Fragment frag2;
    private LoadingDialog load;
    private TextView textView1;
    private View View;
    private String Result;
    private SQLiteDatabase db;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
          if(msg.what == 2){
                load.hide();
            }else if(msg.what == 3){
                load.show(2,"未识别到文字");
                //load.show();
          }else if(msg.what == 4){
              Intent intent =new Intent(Soft1614080902403DefaultActivity.this,Content.class);
              Bundle bundle = new Bundle();
              bundle.putString("content",Result);
              intent.putExtras(bundle);
              ContentValues cValue = new ContentValues();
              cValue.put("content",Result);
              cValue.put("pic","");
              db.insert("History",null,cValue);
              startActivity(intent);
          }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);
        DBHelper helper = new DBHelper(Soft1614080902403DefaultActivity.this,"history.db");
        db = helper.getWritableDatabase();
        db.execSQL("create table if not exists History(_id integer primary key autoincrement,content text, pic text)");



        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        setDefaultFragment();


        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.shouye, "识图"))
                .addItem(new BottomNavigationItem(R.drawable.ren, "我的"))
                .setFirstSelectedPosition(0).setActiveColor("#3599FC").setBarBackgroundColor("#000000")
                .initialise();
        mBottomNavigationBar.setTabSelectedListener(new TabSelect());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 2000);
        load = new LoadingDialog(this);
        load.show(3,"loading测试");
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回数据
            if (requestCode == 0xa1) {
                FileInputStream fis;
                try {
                    Fragment2 fragtemp = (Fragment2)getSupportFragmentManager().findFragmentByTag("f2");
                    fis = new FileInputStream(fragtemp.mFilePath); // 根据路径获取数据
                    Bitmap bitmap = BitmapFactory.decodeStream(fis);
                    fis.close();
                    load = new LoadingDialog(this);
                    load.show(1,"加载中");
                    new Upload(bitmap).start();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if(requestCode == 0xa0){
                Uri selectedImage = data.getData();
                String[] filePathColumns = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePathColumns[0]);
                String imagePath = c.getString(columnIndex);
                c.close();
                load = new LoadingDialog(this);
                load.show(1,"加载中");
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                new Upload(bitmap).start();
            }
        }
    }

    private class Upload extends Thread {
        public Bitmap bistmap;

        public Upload(Bitmap bitmap) {
            bistmap = bitmap;
        }

        public void run() {
            Map<String, String> params = new HashMap<String, String>();
            params.put("base64img", Bitmap2StrByBase64(bistmap));
            String rs = HttpUtils.submitPostData("http://39.108.239.85/ocr.php", params, "utf-8");
            handler.sendEmptyMessage(2);
            try {
                JSONObject jsonObject = new JSONObject(rs);
                if (jsonObject.optString("status").equals("1")) {
                    Result = jsonObject.optString("words");
                    handler.sendEmptyMessage(4);
                } else if (jsonObject.optString("status") == "-1") {
                        handler.sendEmptyMessage(3);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String Bitmap2StrByBase64(Bitmap bit){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bit.compress(Bitmap.CompressFormat.JPEG, 40, bos);//参数100表示不压缩
        byte[] bytes=bos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private void setDefaultFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame_layout, Fragment3.newInstance("dasdas","dasdsa"),"f3");
        transaction.replace(R.id.main_frame_layout, Fragment2.newInstance("dasdas","dasdsa"),"f2");
        transaction.commit();
    }

    private class TabSelect implements BottomNavigationBar.OnTabSelectedListener {
       @Override
       public void onTabSelected(int position) {
           FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
           switch (position) {
               case 0:
                   if (frag1 == null) {
                       frag1 = Fragment2.newInstance("1","2");
                   }
                   transaction.replace(R.id.main_frame_layout, frag1,"f2");
                   break;
               case 1:
                   if (frag2 == null) {
                       frag2 = Fragment3.newInstance("Second Fragment","dasd");
                   }
                   transaction.replace(R.id.main_frame_layout, frag2,"f3");
                   break;
           }
           transaction.commit();

       }

       @Override
       public void onTabUnselected(int position) {

       }

       @Override
       public void onTabReselected(int position) {

       }
   }




}
