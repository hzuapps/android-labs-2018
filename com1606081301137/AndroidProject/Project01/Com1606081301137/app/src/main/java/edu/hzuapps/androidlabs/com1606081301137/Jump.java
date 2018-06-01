package edu.hzuapps.androidlabs.com1606081301137;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;



public class Jump extends AppCompatActivity{
    private ImageView imageView;
    //获取图片
    public Bitmap getPicture(String wu){
        Bitmap yu=null;
        try{
            URL url=new URL(wu);
            URLConnection connection=url.openConnection();
            connection.connect();
            InputStream inputStream=connection.getInputStream();
            yu= BitmapFactory.decodeStream(inputStream);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  yu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jump);
        imageView = (ImageView) findViewById(R.id.add_image);
        TextView txtUserName=(TextView) findViewById(R.id.txt_User);
        SharedPreferences sharedPreferences = getSharedPreferences("jnc", Context.MODE_PRIVATE); //创建SharedPreferences对象
        final String userName=sharedPreferences.getString("username","");//根据key获取对应的数据
        txtUserName.setText(userName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap=getPicture(userName);
                //final Bitmap bitmap=getPicture("http://pic36.photophoto.cn/20150704/0017029369483757_b.jpg");
                try {
                    Thread.sleep(1997);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }
}
