package edu.hzuapps.androidlabs.soft1614080902326;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Soft1614080902326Activity extends Activity implements View.OnClickListener {

    private static final String IMAGE_FILE_NAME = "select_image.jpg";
    private static final int CODE_GALLERY_REQUEST = 0xa0;//本地
    private static final int CODE_CAMERA_REQUEST = 0xa1;//拍照
    private static final int CODE_RESULT_REQUEST = 0xa2;//最终裁剪后的结果

    private static int output_X = 600;
    private static int output_Y = 600;
    private ImageView selectImage = null;
    private View contentView;
    private PopupWindow mWindow;
    private TextView ivCamera;
    private TextView ivGallery;
    private TextView ivCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902326);

        initPopupWindow();
        initView();

        Button add =(Button) findViewById(R.id.add_Button);
        add.setOnClickListener(this);
        //打开收藏
        Button collect = (Button) findViewById(R.id.collectButton);
        Button save=(Button) findViewById(R.id.save);
        save.setOnClickListener(this);
        collect.setOnClickListener(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }


        });
}


    //从相册选取本地图片
    private void choseImageFromGallery(){
        Intent intentFromGallery=new Intent();
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
        //如果你想在Activity中得到新打开Activity关闭后返回的数据，
        //你需要使用系统提供的startActivityForResult(Intent intent,int requestCode)方法打开新的Activity
        startActivityForResult(intentFromGallery,CODE_GALLERY_REQUEST);

    }
    //从相机获取图片
    private void choseImageFromCamera() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                .fromFile(new File(Environment
                        .getExternalStorageDirectory(), IMAGE_FILE_NAME)));
        startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (resultCode == RESULT_CANCELED) {//取消
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (requestCode) {
            case CODE_GALLERY_REQUEST://本地
                cropRawPhoto(intent.getData());//直接裁剪图片
                break;
            case CODE_CAMERA_REQUEST:
                File tempFile = new File(
                        Environment.getExternalStorageDirectory(),
                        IMAGE_FILE_NAME);
                cropRawPhoto(Uri.fromFile(tempFile));
                break;
        }
        super.onActivityResult(requestCode, resultCode, intent);

    }
    public void cropRawPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
//把裁剪的数据填入里面
// 设置裁剪
        intent.putExtra("crop", "true");
// aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
// outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }
    /**
     * 提取保存裁剪之后的图片数据，并设置头像部分的View
     */
    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            selectImage.setImageBitmap(photo);
//新建文件夹 先选好路径 再调用mkdir函数 现在是根目录下面的Ask文件夹
            File nf = new File(Environment.getExternalStorageDirectory()+"/Ask");
            nf.mkdir();
//在根目录下面的ASk文件夹下 创建okkk.jpg文件
            File f = new File(Environment.getExternalStorageDirectory()+"/Ask", "okkk.jpg");
            FileOutputStream out = null;
            try {//打开输出流 将图片数据填入文件中
                out = new FileOutputStream(f);
                photo.compress(Bitmap.CompressFormat.PNG, 90, out);
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void showPopupMenu(View view) {
       PopupMenu popupMenu = new PopupMenu(Soft1614080902326Activity.this, view);
       // 获取布局文件
       popupMenu.getMenuInflater().inflate(R.menu.options, popupMenu.getMenu());
       popupMenu.show();
       // 显示菜单
       popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
           @Override
           public boolean onMenuItemClick(MenuItem item) {
               switch(item.getItemId()) {
                   case R.id.selectFromGallery:
                       choseImageFromGallery();
                       return true;
                   case R.id.selectFromCamera:
                       choseImageFromCamera();
                       return true;
                   case R.id.cancelButton:
                       return true;
               }
               return true;
           }
       });
       popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
           @Override
           public void onDismiss(PopupMenu menu) {
               // 控件消失时的事件
           }
       });

   }

    private void initPopupWindow() {
        contentView=getLayoutInflater().inflate(R.layout.popup_window,null);
        mWindow=new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mWindow.setOutsideTouchable(true);
        mWindow.setTouchable(true);
        mWindow.setFocusable(true);
        mWindow.setAnimationStyle(R.style.popwindow_anim_style);

        mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });


    }

    private void initView() {
        ivCamera = (TextView) contentView.findViewById(R.id.selectFromCamera);
        ivGallery = (TextView) contentView.findViewById(R.id.selectFromGallery);
        ivCancel = contentView.findViewById(R.id.cancelButton);
        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseImageFromCamera();
                mWindow.dismiss();
            }
        });
        ivGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choseImageFromGallery();
                mWindow.dismiss();
            }
        });
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWindow.dismiss();
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.add_Button:
                backgroundAlpha(0.8f);
                mWindow.showAtLocation(contentView,Gravity.BOTTOM,0,0);
                break;
            case R.id.collectButton:
                Intent intent = new Intent ();
                intent.setClass(Soft1614080902326Activity.this,collectActivity.class);
                startActivity(intent);
                break;
        }

    }
    ////退出程序
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                if(mWindow.isShowing()){
                    mWindow.dismiss();
                    return true;
                }else{

                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        if ((System.currentTimeMillis() - exitTime) > 2000) {
                            //弹出提示
                            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                            exitTime = System.currentTimeMillis();
                        } else {
                            finish();
                        }
                        return true;
                    }
                }

        }
        return super.onKeyDown(keyCode, event);
    }
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
}
