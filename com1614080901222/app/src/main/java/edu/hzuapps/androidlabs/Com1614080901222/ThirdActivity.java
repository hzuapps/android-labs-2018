package edu.hzuapps.androidlabs.Com1614080901222;

import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imagic.com1614080901222.R;

public class ThirdActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    final Handler h;

    {
        h= new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 1) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        };
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        verifyStoragePermissions(ThirdActivity.this);

        setContentView(R.layout.activity_third);
        editText =  findViewById(R.id.urlTextView);
        button =  findViewById(R.id.download);
        imageView = findViewById(R.id.imageView);

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                //新开一个线程，用来缓存图片
                new Thread(){
                    public void run() {
                        String path=editText.getText().toString();
                        try {
                            URL url=new URL(path);
                            InputStream inputStream=url.openStream();
                            bitmap=BitmapFactory.decodeStream(inputStream);
                            h.sendEmptyMessage(1);
                            saveImageToGallery(bitmap);
                            inputStream.close();
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
    public static boolean saveImageToGallery( Bitmap bmp) {
        // 首先保存图片
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "DCIM";
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片
            boolean isSuccess = bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos);
            fos.flush();
            fos.close();
            if (isSuccess) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void verifyStoragePermissions(Activity activity) {

        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
