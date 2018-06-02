package dl.soft1614080902201;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.*;
import android.graphics.*;
import android.os.Handler;
import android.os.Message;
import java.io.File;
import android.os.AsyncTask;
import android.os.Environment;

import dl.soft1614080902201.R;
import dl.soft1614080902201.*;

public class NetworkActivity extends Activity implements View.OnClickListener{

    public static final String TAG = NetworkActivity.class.getSimpleName();
    public static final String WEB = "http://www.bing.com";
    public static final String IMAGE_URL_PREFIX = "https://raw.githubusercontent.com/hzuapps/android-labs/master/app/src/main/res/drawable/";

    static String[] imageNames = {"image_bmp.png", "image_gif.png", "image_ico.png",
            "image_jpeg.png", "image_png.png", "image_tiff.png"};


    private Button mDownloadImageButton;
    private ImageView mImageshow;
    private TextView mNetworkText;
    private TextView mResultText;
    Bitmap bitmap;

    private boolean mConnected;
    private NetworkFileDownloader mFileDownloader;
    private File mPrivateRootDir;
    private File mImagesDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        mDownloadImageButton = (Button) findViewById(R.id.button_download_image);
        mImageshow =(ImageView)findViewById(R.id.text_show);
        mNetworkText = (TextView) findViewById(R.id.text_network);
        mResultText = (TextView) findViewById(R.id.text_result);
        mDownloadImageButton.setOnClickListener(this);
        mPrivateRootDir = getFilesDir();
        mImagesDir = new File(mPrivateRootDir, "images");
    }
    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.button_download_image) {
            downloadImages();
        }
    }

    private void downloadImages() {
        // 创建下载器
        mFileDownloader = new NetworkFileDownloader(new NetworkFileDownloader.OnImageDownloadListener() {
            @Override
            public void onError(String error) {
                Toast.makeText(NetworkActivity.this, error, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onProgressChange(int percent) {
                Log.i(TAG, "当前进度 = " + percent);
            }

            @Override
            public void onComplete(Bitmap bitmap, String imageUrl) {
                // 下载的图片格式为PNG
                final Bitmap.CompressFormat format = Bitmap.CompressFormat.PNG;
                // 解析出原始文件名
                String filename = imageUrl.replace(IMAGE_URL_PREFIX, "");
                final File imageFile = new File(mImagesDir, filename);
                // 将文件保存到磁盘中
                NetworkFileDownloader.writeToDisk(imageFile, bitmap, new NetworkFileDownloader.OnBitmapSaveListener() {
                    @Override
                    public void onBitmapSaved() {
                        Toast.makeText(NetworkActivity.this, "文件已保存: " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onBitmapSaveError(String error) {
                        Toast.makeText(NetworkActivity.this, error, Toast.LENGTH_LONG).show();
                    }
                }, format, false);
            }
        });

        // 下载所有文件
        for(String imageName :imageNames) {
            String imageUrl = IMAGE_URL_PREFIX + imageName;
            mFileDownloader.download(imageUrl, true);
        }
    }

    public Bitmap GetImageInputStream(String imageurl){
               URL url;
                HttpURLConnection connection=null;
                Bitmap bitmap=null;
                try {
                      url = new URL(imageurl);
                      connection=(HttpURLConnection)url.openConnection();
                       connection.setConnectTimeout(6000);
                       connection.setDoInput(true);
                       connection.setUseCaches(false);
                        InputStream inputStream=connection.getInputStream();
                       bitmap=BitmapFactory.decodeStream(inputStream);
                       inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
               return bitmap;
            }

    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
                        if(msg.what==0x123){
                                mImageshow.setImageBitmap(bitmap);
                            }
                    };
    };


            class Task extends AsyncTask<String, Integer, Void>{

                protected Void doInBackground(String... params) {
                        bitmap=GetImageInputStream((String)params[0]);
                        return null;
                    }

                protected void onPostExecute(Void result) {
                        super.onPostExecute(result);
                        Message message=new Message();
                        message.what=0x123;
                        handler.sendMessage(message);
                    }

            }

            public void SavaImage(Bitmap bitmap, String path){
                File file=new File(path);
                FileOutputStream fileOutputStream=null;
                if(!file.exists()){
                        file.mkdir();
                    }
                try {
                        fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".png");
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
}
