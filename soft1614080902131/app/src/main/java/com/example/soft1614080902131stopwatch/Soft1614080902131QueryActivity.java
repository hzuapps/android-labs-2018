package com.example.soft1614080902131stopwatch;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.service.autofill.Dataset;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Soft1614080902131QueryActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView informationTextView;
    private ImageView pictureImageView;
    private RecyclerView recyclerView;
    private int currId;
    List<Timer1Record> timer1RecordList=new ArrayList<>();
    DateRecord currDateRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902131_query);
        init();
    }

    private void init(){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        setTitle("");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        informationTextView=(TextView)findViewById(R.id.query_information_text_view);
        pictureImageView=(ImageView)findViewById(R.id.query_picture_image_view);
        recyclerView=(RecyclerView)findViewById(R.id.query_recycler_view);

        Intent intent=getIntent();
        currId=intent.getIntExtra("currId",123);
        currDateRecord=DataSupport.find(DateRecord.class,currId);
        informationTextView.setText("日期:"+currDateRecord.getDate()+"\n时间:"+currDateRecord.getTime()
                +"\n备注:"+currDateRecord.getRemark()+"\n记录次数:"+currDateRecord.getRecordN()
        +"\n是否有照片:"+currDateRecord.isHavePicture());



        String mFilePath = Environment.getExternalStorageDirectory().getPath();// 获取SD卡路径
        mFilePath = mFilePath + "/aPicture/" + "p" + currId + ".jpg";// 指定路径
        Uri photoUri = Uri.fromFile(new File(mFilePath));

        Glide.with(this)
                .load(photoUri)
                .into(pictureImageView);

        timer1RecordList= DataSupport.where("number = ?",currId+"").find(Timer1Record.class);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerAdaptTimer1 adaptTimer1=new RecyclerAdaptTimer1(timer1RecordList);
        recyclerView.setAdapter(adaptTimer1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
        }
        return true;
    }
}
