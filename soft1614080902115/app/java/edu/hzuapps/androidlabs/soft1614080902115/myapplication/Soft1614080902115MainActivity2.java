package edu.hzuapps.androidlabs.soft1614080902115.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Soft1614080902115MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImageView;
    private ImageButton btnStartCameraThumb,btnStartCameraFull;
    private File photoFile;
    //requestCode
    private static final int REQUEST_IMAGE_CAPTURE_THUMB = 1;
    private static final int REQUEST_IMAGE_CAPTURE_FULL = 2;

    private static final String JPEG_FILE_PREFIX = "IMG_";
    private static final String JPEG_FILE_SUFFIX = ".jpg";

    private static final String CAMERA_DIR = "/手机存储/DCIM/Camera/";
    private static final String albumName ="CameraSample";

    //获得ImageView的width height
    private int targetW ;
    private int targetH ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902115_main2);

        initView();

        try {
            photoFile = createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获得文件路径,这里以public为例

    private File getPhotoDir(){
        File storDirPublic = null;

        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){


            //public 所有应用均可访问
            storDirPublic = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    albumName);

            if (storDirPublic != null) {
                if (! storDirPublic.mkdirs()) {
                    if (! storDirPublic.exists()){
                        Log.d("CameraSample", "failed to create directory");
                        return null;
                    }
                }
            }
        }else {
            Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
        }

        return storDirPublic;

    }

    private File createFile() throws IOException {
        photoFile = null;

        String fileName;
        //通过时间戳区别文件名
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        fileName = JPEG_FILE_PREFIX+timeStamp+"_";

        photoFile = File.createTempFile(fileName,JPEG_FILE_SUFFIX,getPhotoDir());

        return photoFile;
    }


    //获得控件
    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        btnStartCameraThumb = (ImageButton) findViewById(R.id.StartCameraThumb);
        btnStartCameraFull = (ImageButton) findViewById(R.id.StartCameraFull);

        targetW = mImageView.getWidth();
        targetH = mImageView.getHeight();


        btnStartCameraFull.setOnClickListener(this);
        btnStartCameraThumb.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        switch (v.getId()){
            case R.id.StartCameraThumb:
                startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE_THUMB);
                break;
            case R.id.StartCameraFull:
                //传入File的uri
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE_FULL);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mImageView.setImageBitmap(null);

        switch (requestCode){
            case REQUEST_IMAGE_CAPTURE_THUMB:
                if(resultCode == RESULT_OK){
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");

                    mImageView.setImageBitmap(imageBitmap);
                }

                break;
            case REQUEST_IMAGE_CAPTURE_FULL:
                if(resultCode == RESULT_OK){
                    setPic();
                    galleryAddPic();
                }

                break;

        }

    }


    private void setPic() {

        //获得图像的尺寸
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoFile.getAbsolutePath(),bmOptions);

        int photoW = bmOptions.outWidth;
        int photoH =bmOptions.outHeight;

        //计算缩放
        int scaleFactor = 1;
        if((targetW>0)||(targetH>0)){
            scaleFactor = Math.min(photoW/targetW,photoH/targetH);
        }

        //将保存的文件解码
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;


        Bitmap bitmap = BitmapFactory.decodeFile(photoFile.getAbsolutePath(), bmOptions);


        mImageView.setImageBitmap(bitmap);
    }


    //将图片文件添加至相册（便于浏览）
    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(photoFile);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }
}
