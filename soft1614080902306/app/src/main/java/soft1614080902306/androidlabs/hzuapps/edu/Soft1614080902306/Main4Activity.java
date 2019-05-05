package soft1614080902306.androidlabs.hzuapps.edu.Soft1614080902306;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import soft1614080902306.androidlabs.hzuapps.edu.myapplication.R;

public class Main4Activity extends AppCompatActivity implements OnClickListener {

    Button content;
    ImageView image;
    Bitmap bitmap;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        content=(Button)findViewById(R.id.content);
        image=(ImageView)findViewById(R.id.image);

        content.setOnClickListener(this);;
        image.setOnClickListener(this);;
    }

    /**
     * 获取网络图片
     * @param imageurl 图片网络地址
     * @return Bitmap 返回位图
     */
    public Bitmap GetImageInputStream(String imageurl){
        URL url;
        HttpURLConnection connection=null;
        Bitmap bitmap=null;
        try {
            url = new URL(imageurl);
            connection=(HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(6000); //超时设置
            connection.setDoInput(true);
            connection.setUseCaches(false); //设置不使用缓存
            InputStream inputStream=connection.getInputStream();
            bitmap=BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.content:
                //加入网络图片地址
                new Task().execute("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=false&word=%E6%9E%97%E5%85%81%E5%84%BF&hs=0&pn=-1&spn=0&di=baikeimg&pi=&rn=1&tn=baiduimagedetail&is=&istype=&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=&lpn=0&ln=undefined&fr=&fmq=undefined&fm=undefined&ic=&s=&se=&sme=&tab=&width=&height=&face=&cg=star&bdtype=0&oriquery=&objurl=http%3A%2F%2Fc.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2Fd1a20cf431adcbefd4018f2ea1af2edda3cc9fe5.jpg&fromurl=https%3A%2F%2Fbaike.baidu.com%2Fitem%2F%E6%9E%97%E5%85%81%E5%84%BF%2F6062189&gsm=&islist=&querylist=");
                break;

            case R.id.image:
                //点击图片后将图片保存到SD卡跟目录下的Test文件夹内
                SavaImage(bitmap, Environment.getExternalStorageDirectory().getPath()+"/Test");
                Toast.makeText(getBaseContext(), "图片保存", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123){
                image.setImageBitmap(bitmap);
            }
        };
    };


    /**
     * 异步线程下载图片
     *
     */
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

    /**
     * 保存位图到本地
     * @param bitmap
     * @param path 本地路径
     * @return void
     */
    public void SavaImage(Bitmap bitmap, String path){
        File file=new File(path);
        FileOutputStream fileOutputStream=null;
        //文件夹不存在，则创建它
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

