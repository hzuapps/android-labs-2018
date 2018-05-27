package com.example.wjk.edu.hzuapps.androidlabs.soft1614080902135;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class Soft1614080902135Activity2 extends AppCompatActivity {
    private ImageView iv;
    private Bitmap baseBitmap;
    private Canvas canvas;
    private Paint paint;
    private Button newButton1;
    private Button newButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft16140809021352);


        newButton2 = (Button) findViewById(R.id.button_2);
        newButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1=new Intent(Soft1614080902135Activity2.this,Soft1614080902135Activity3.class);
                startActivity(intent1);
            }
        });


        newButton1 = (Button) findViewById(R.id.button_3);
        newButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save();
            }
        });



        this.iv = (ImageView) this.findViewById(R.id.iv);
        // 创建一张空白图片
        baseBitmap = Bitmap.createBitmap(1200, 1600, Bitmap.Config.ARGB_8888);
        // 创建一张画布
        canvas = new Canvas(baseBitmap);
        // 画布背景为白色
        canvas.drawColor(Color.WHITE);
        // 创建画笔
        paint = new Paint();
        // 画笔颜色为黑色
        paint.setColor(Color.BLACK);
        // 宽度5个像素
        paint.setStrokeWidth(10);
        // 先将白色背景画上
        canvas.drawBitmap(baseBitmap, new Matrix(), paint);
        iv.setImageBitmap(baseBitmap);

        iv.setOnTouchListener(new View.OnTouchListener() {
            int startX;
            int startY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 获取手按下时的坐标
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 获取手移动后的坐标
                        int stopX = (int) event.getX();
                        int stopY = (int) event.getY();
                        // 在开始和结束坐标间画一条线
                        canvas.drawLine(startX, startY, stopX, stopY, paint);
                        // 实时更新开始坐标
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        iv.setImageBitmap(baseBitmap);
                        break;
                }
                return true;
            }
        });
    }

    public void save() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(),
                    System.currentTimeMillis() + ".jpg");
            OutputStream stream = new FileOutputStream(file);
            baseBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.close();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
            intent.setData(Uri.fromFile(Environment
                    .getExternalStorageDirectory()));
            sendBroadcast(intent);
        } catch (Exception e) {
            Toast.makeText(Soft1614080902135Activity2.this, "保存图片成功", Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }
    }
}

