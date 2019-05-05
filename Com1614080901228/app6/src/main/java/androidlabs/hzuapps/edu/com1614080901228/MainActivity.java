package androidlabs.hzuapps.edu.com1614080901228;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
//    private final static String ALBUM_PATH
//            = Environment.getExternalStorageDirectory() + "/";
    private final static String ALBUM_PATH
        = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/";
    private ImageView mImageView;
    private Button mBtnSave;
    private ProgressDialog mSaveDialog = null;
    private Bitmap mBitmap;
    private String mFileName;
    private String mSaveMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView)findViewById(R.id.imgSource);
        mBtnSave = (Button)findViewById(R.id.btnSave);

        new Thread(connectNet).start();

        // 下载图片
        mBtnSave.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                mSaveDialog = ProgressDialog.show(MainActivity.this, "保存图片", "图片正在保存中，请稍等...", true);
                new Thread(saveFileRunnable).start();
            }
        });
    }

    public byte[] getImage(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return readStream(inStream);
        }
        return null;
    }

    public InputStream getImageStream(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return conn.getInputStream();
        }
        return null;
    }

    public static byte[] readStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    public void saveFile(Bitmap bm, String fileName) throws IOException {
        File dirFile = new File(ALBUM_PATH);
        if(!dirFile.exists()){
            dirFile.mkdir();
        }
        File myCaptureFile = new File(ALBUM_PATH + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
    }

    private Runnable saveFileRunnable = new Runnable(){
        @Override
        public void run() {
            try {
                saveFile(mBitmap, mFileName);
                mSaveMessage = "图片保存成功！";
            } catch (IOException e) {
                mSaveMessage = "图片保存失败！";
                e.printStackTrace();
            }
            messageHandler.sendMessage(messageHandler.obtainMessage());
        }

    };

    private Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSaveDialog.dismiss();
            Log.d(TAG, mSaveMessage);
            Toast.makeText(MainActivity.this, mSaveMessage, Toast.LENGTH_SHORT).show();
        }
    };

    private Runnable connectNet = new Runnable(){
        @Override
        public void run() {
            try {
                String filePath = "http://pic35.photophoto.cn/20150516/0005018639255973_b.jpg";
                mFileName = "b.jpg";

                //以下是取得图片的两种方法
                //////////////// 方法1：取得的是byte数组, 从byte数组生成bitmap
                byte[] data = getImage(filePath);
                if(data!=null){
                    mBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);// bitmap
                }else{
                    Toast.makeText(MainActivity.this, "Image error!", 1).show();
                }
                ////////////////////////////////////////////////////////

                //******** 方法2：取得的是InputStream，直接从InputStream生成bitmap ***********/
                mBitmap = BitmapFactory.decodeStream(getImageStream(filePath));
                //********************************************************************/

                // 发送消息，通知handler在主线程中更新UI
                connectHanlder.sendEmptyMessage(0);
                Log.d(TAG, "set image ...");
            } catch (Exception e) {
                Toast.makeText(MainActivity.this,"无法链接网络！", 1).show();
                e.printStackTrace();
            }

        }

    };

    private Handler connectHanlder = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "display image");
            // 更新UI，显示图片
            if (mBitmap != null) {
                mImageView.setImageBitmap(mBitmap);// display image
            }
        }
    };
}
