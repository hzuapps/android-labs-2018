package edu.hzuapps.androidlabs.soft1614080902326;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class Soft1614080902326Activity extends Activity implements View.OnClickListener,TextWatcher ,View.OnTouchListener {

    private static final int CODE_GALLERY_REQUEST = 0xa0;//本地
    private static final int CODE_CAMERA_REQUEST = 0xa1;//拍照
    private String path = Environment.getExternalStorageDirectory() +
            File.separator + Environment.DIRECTORY_DCIM + File.separator;
    private ImageView selectImage = null;
    private View contentView;
    private PopupWindow mWindow;
    private TextView ivCamera;
    private TextView ivGallery;
    private TextView ivCancel;
    public String hc,value;
    public String sV,rV,gV,bV;
    private ImageView select_Image;
    public TextView colorShow;
    public String cS;
    Uri photoUri;
    public static final String FILENAME = "color_list.txt";

    private TextView tvTouchShowStart;
    private TextView tvTouchShow;
    private ImageView iv;
    private Bitmap bitmap;

    private EditText hex;
    private EditText s;
    private EditText r;
    private EditText g;
    private EditText b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902326);

        init();

        initPopupWindow();
        initView();

        select_Image = (ImageView) findViewById(R.id.selectImage);
        //初始化图片
        select_Image.setImageResource(R.drawable.default_pic);
        //预览颜色
        colorShow=(TextView)findViewById(R.id.colorShow);
        Button add =(Button) findViewById(R.id.add_Button);
        add.setOnClickListener(this);
        //打开收藏
        final Button collect = (Button) findViewById(R.id.collectButton);
        collect.setOnClickListener(this);

        hex=(EditText)findViewById(R.id.hexCode) ;
        s=(EditText)findViewById(R.id.sValue) ;
        r=(EditText)findViewById(R.id.rValue) ;
        g=(EditText)findViewById(R.id.gValue) ;
        b=(EditText)findViewById(R.id.bValue) ;

        //保存
        Button save=(Button) findViewById(R.id.save);
        //save.setOnClickListener(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                hc = ((EditText)findViewById(R.id.hexCode)).getText().toString();
                sV = ((EditText)findViewById(R.id.sValue)).getText().toString();
                rV = ((EditText)findViewById(R.id.rValue)).getText().toString();
                gV = ((EditText)findViewById(R.id.gValue)).getText().toString();
                bV = ((EditText)findViewById(R.id.bValue)).getText().toString();
                Change2File c2f=new Change2File();
                value=c2f.change(hc,sV,rV,gV,bV);
                saveTextIntoInternalStorage(value);
            }
        });
        Button preView_btn=(Button)findViewById(R.id.preview_btn);
        preView_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sV=((EditText)findViewById(R.id.sValue)).getText().toString();
                rV = ((EditText)findViewById(R.id.rValue)).getText().toString();
                gV = ((EditText)findViewById(R.id.gValue)).getText().toString();
                bV = ((EditText)findViewById(R.id.bValue)).getText().toString();

                colorShow.setBackgroundColor(Color.argb(Integer.parseInt(sV),Integer.parseInt(rV),Integer.parseInt(gV),Integer.parseInt(bV)));
                /*hc = ((EditText)findViewById(R.id.hexCode)).getText().toString();
                cS="#"+hc;
                colorShow=(TextView)findViewById(R.id.colorShow);
                    colorShow.setBackgroundColor(Color.parseColor(cS));*/
            }
        });

        EditText hexCode=(EditText)findViewById(R.id.hexCode);
        hexCode.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String hc = ((EditText)findViewById(R.id.hexCode)).getText().toString();
                cS="#"+hc;
                colorShow=(TextView)findViewById(R.id.colorShow);
                if(cS.length()==9||cS.length()==7)
                    colorShow.setBackgroundColor(Color.parseColor(cS));


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        final EditText sValue=(EditText)findViewById(R.id.sValue);
        sValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //sValue.setText(sV);


            }
        });
        final EditText rValue=(EditText)findViewById(R.id.rValue);
        rValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*rV=rValue.getText().toString();
                rValue.setText(rV);*/

            }

            @Override
            public void afterTextChanged(Editable s) {
                /*rV=rValue.getText().toString();
                rValue.setText(rV);
*/
            }
        });
        final EditText gValue=(EditText)findViewById(R.id.gValue);
        gValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*gV=gValue.getText().toString();
                gValue.setText(gV);*/
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final EditText bValue=(EditText)findViewById(R.id.bValue);
        bValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                /*bV=bValue.getText().toString();
                bValue.setText(bV);*/
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

}

    private void saveTextIntoInternalStorage(String s) {
        cS="#"+hc;
        colorShow=(TextView)findViewById(R.id.colorShow);
            colorShow.setBackgroundColor(Color.parseColor(cS));

        File dir = this.getFilesDir();
        File file = new File(dir, FILENAME);
        if (file.exists()) { // 判断文件是否存在
            Log.i(TAG, file.getAbsolutePath());
            Log.i(TAG, file.length() + ""); // bytes*1024=kb *1024 MB
            Log.i(TAG, file.isFile() + "");
            file.canRead();
            file.canWrite();
            file.canExecute();

            file.getFreeSpace();
            file.getTotalSpace();
        }

        FileOutputStream fos = null;
        try { // 使用API打开输出流
            fos = openFileOutput(FILENAME, MODE_APPEND);//MODE_APPEND增量方式写入已存在文件，默认使用覆盖私有模式即MODE_PRIVATE
            //FileOutputStream fos = new FileOutputStream(file);
            fos.write('#');
            fos.write(s.getBytes());
            fos.write('\n');
            // 写入内容
            Toast.makeText(getApplicationContext(), "已添加颜色"+"#"+hc+"    "+sV+rV+gV+bV, Toast.LENGTH_SHORT).show();
            fos.close(); // 关闭流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileReader reader = null; // char
        String r,g,b;

        try {
            StringBuffer sb = new StringBuffer();
            reader = new FileReader(file.getAbsoluteFile());
            BufferedReader bReader = new BufferedReader(reader);
            String line = bReader.readLine();
            Log.i(TAG, "从文件读取的内容: " + line);
            sb.append(line);
            bReader.close();
            reader.close();
            ((TextView)findViewById(R.id.text1)).setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 显示结果
        showResult(file.getAbsolutePath());


        // 删除文件
        // file.delete();
        // deleteFile(FILENAME);

    }
    private void showResult(String result) {
        ((TextView) findViewById(R.id.text)) //
                .setText(result.toCharArray(), 0, result.length());
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
        /*Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                .fromFile(new File(Environment
                        .getExternalStorageDirectory(), IMAGE_FILE_NAME)));
        startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);*/
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            String fileName = getPhotoFileName() + ".jpg";
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            photoUri = Uri.fromFile(new File(path + fileName));
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
            startActivityForResult(intent, CODE_CAMERA_REQUEST);
        }
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
                setImageToView(requestCode,resultCode,intent);
                break;
            case CODE_CAMERA_REQUEST://相机
                Log.d(TAG, "开始回调");
                Uri uri = null;
                if (intent != null && intent.getData() != null) {
                    uri = intent.getData();
                }
                if (uri == null) {
                    if (photoUri != null) {
                        uri = photoUri;
                    }
                }
                select_Image.setImageURI(uri);


                }

        super.onActivityResult(requestCode, resultCode, intent);

    }
    private String getImagePath(Uri uri, String seletion){
        String path = null;
        Cursor cursor = getContentResolver().query(uri,null,seletion,null,null);
        if (cursor != null){
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
    private void setImageToView(int requestCode, int resultCode, Intent intent) {

        if (intent != null) {
            Uri uri = intent.getData();// 获取图片的路径
            select_Image.setImageURI(uri);
        }
        super.onActivityResult(requestCode, resultCode, intent);
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
        mWindow.setOutsideTouchable(false);
        mWindow.setBackgroundDrawable(new ColorDrawable());
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
                backgroundAlpha(0.7f);
                mWindow.showAtLocation(contentView,Gravity.BOTTOM,0,0);
                break;
            case R.id.collectButton:
                Intent intent = new Intent ();
                intent.setClass(Soft1614080902326Activity.this,CollectActivity.class);
                startActivity(intent);
                break;
        }

    }
   //设置背景透明度
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return "IMG_" + dateFormat.format(date);
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


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    private void init() {
        tvTouchShowStart = (TextView) findViewById(R.id.touch_show_start);
        tvTouchShow = (TextView) findViewById(R.id.touch_show);
        iv=(ImageView)findViewById(R.id.selectImage);
        iv.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            /**
             * 点击的开始位置
             */
            case MotionEvent.ACTION_DOWN:
                tvTouchShowStart.setText("起始:" + (int)event.getX() + "," + (int)event.getY());
                break;
            /**
             * 触屏实时位置
             */
            case MotionEvent.ACTION_MOVE:
                tvTouchShow.setText("实时:" + (int)event.getX() + "," + (int)event.getY());
                //colorShow.setBackgroundColor(Color.parseColor("#ff000000"));
                bitmap = ((BitmapDrawable)select_Image.getDrawable()).getBitmap();
                int pixel = bitmap.getPixel((int)event.getX(),(int)event.getY());
                //获取颜色
                int redValue = Color.red(pixel);
                int blueValue = Color.blue(pixel);
                int greenValue = Color.green(pixel);
                colorShow.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));
                ColorValueCalculation cc=new ColorValueCalculation();
                String hexValue=cc.SRGB2HEX(redValue,greenValue,blueValue);
                hex.setText(hexValue);
                s.setText("255");
                /*r.setText(redValue);
                g.setText(greenValue);
                b.setText(blueValue);*/

                break;
            /**
             * 离开屏幕的位置
             */
            case MotionEvent.ACTION_UP:
                tvTouchShow.setText("结束:" + (int)event.getX() + "," + (int)event.getY());
                break;
            default:
                break;
        }
        return true;
    }

}
