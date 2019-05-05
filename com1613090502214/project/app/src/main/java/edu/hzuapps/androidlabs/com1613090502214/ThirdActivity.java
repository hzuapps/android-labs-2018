package edu.hzuapps.androidlabs.com1613090502214;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


public class ThirdActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_CODE_SAVE_IMG = 10;
    private static final String TAG = "MainActivity";
    private Context mContext;
    private EditText editText;
    private Button button;
    private Button button1;
    private ImageView imageView;
    private Bitmap bitmap;
    //手柄更新的作用
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //初始化组件
        editText=(EditText) findViewById(R.id.editText2);
        button=(Button) findViewById(R.id.download);
        button1=(Button)findViewById(R.id.save) ;
        imageView=(ImageView) findViewById(R.id.imageView);

        mContext = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(t).start();

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });
    }

    //为了下载图片资源，开辟一个新的子线程
    Thread t=new Thread() {
        public void run() {
            //下载图片的路径
            String iPath = editText.getText().toString();
            try {
                //对资源链接
                URL url = new URL(iPath);
                //打开输入流
                InputStream inputStream = url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap = BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();
            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    };
    /**
             * 请求读取sd卡的权限
             */
                private void requestPermission() {
                    if (Build.VERSION.SDK_INT >= 23) {
                        //读取sd卡的权限
                        String[] mPermissionList = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        if (EasyPermissions.hasPermissions(mContext, mPermissionList)) {
                //已经同意过
                saveImage(bitmap);
            } else {
                //未同意过,或者说是拒绝了，再次申请权限
                EasyPermissions.requestPermissions(
                        this,  //上下文
                        "保存图片需要读取sd卡的权限", //提示文言
                        REQUEST_CODE_SAVE_IMG, //请求码
                        mPermissionList //权限列表
                );
            }
        } else {
            saveImage(bitmap);
        }
    }


    //保存图片
    private void saveImage(Bitmap bitmap) {

        boolean isSaveSuccess = ImgUtils.saveImageToGallery(mContext, bitmap);
        if (isSaveSuccess) {
            Toast.makeText(mContext, "保存图片成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "保存图片失败，请稍后重试", Toast.LENGTH_SHORT).show();
        }
    }

    //授权结果，分发下去
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        //跳转到onPermissionsGranted或者onPermissionsDenied去回调授权结果
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    //同意授权
    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        Log.i(TAG, "onPermissionsGranted:" + requestCode + ":" + list.size());
        saveImage(bitmap);
    }

    //拒绝授权
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.i(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            //打开系统设置，手动授权
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            //拒绝授权后，从系统设置了授权后，返回APP进行相应的操作
            Log.i(TAG, "onPermissionsDenied:------>自定义设置授权后返回APP");
            saveImage(bitmap);
        }
    }
}
