package com.example.soft1614080902131stopwatch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Soft1614080902131SaveActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText remarkEditText;
    private ImageButton cameraImageButton;
    private ImageView pictureImageView;
    private String mFilePath;
    private boolean isHavePicture = false;
    private Button saveButton;
    Activity activity = this;
    DateRecord currDateRecord = DataSupport.findLast(DateRecord.class);
    private DateRecord dateRecord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902131_save);
        init();
    }

    public void init() {
        remarkEditText = (EditText) findViewById(R.id.remark_edit_text);
        cameraImageButton = (ImageButton) findViewById(R.id.camera_image_button);
        pictureImageView = (ImageView) findViewById(R.id.picture_image_view);
        saveButton = (Button) findViewById(R.id.save_button);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        setTitle("");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        saveButton.setOnClickListener(this);
        cameraImageButton.setOnClickListener(this);
        dateRecord = new DateRecord();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_image_button:
                takePhoto();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// 启动系统相机
                Uri photoUri = Uri.fromFile(new File(mFilePath)); // 传递路径
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);// 更改系统默认存储路径
                startActivityForResult(intent, 1);
                isHavePicture=true;
                dateRecord.setHavePicture(true);
                break;

            case R.id.save_button:
                dateRecord.setRemark(remarkEditText.getText().toString());
                dateRecord.update(currDateRecord.getId());
                Intent intent1 = new Intent();
                setResult(1, intent1);
                activity.finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(mFilePath); // 根据路径获取数据
            Bitmap bitmap = BitmapFactory.decodeStream(fis);
            pictureImageView.setImageBitmap(bitmap);// 显示图片
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();// 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void takePhoto(){
        mFilePath = Environment.getExternalStorageDirectory().getPath();// 获取SD卡路径
        File filePackage = new File(mFilePath + "/aPicture");
        if (filePackage.exists() == false) {
            filePackage.mkdirs();
        }
        mFilePath = mFilePath + "/aPicture/" + "p" + currDateRecord.getId() + ".jpg";// 指定路径
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent1 = new Intent();
                setResult(1, intent1);
                this.finish();
                break;
        }
        return true;
    }
}
