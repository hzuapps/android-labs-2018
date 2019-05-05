package edu.soft1614080902329.password_record;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class soft1614080902329NetWorkActivity extends AppCompatActivity {

    private Button authorSeeButtom = null;
    private ImageView authorImageView = null;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bm = (Bitmap) msg.obj;
            authorImageView.setImageBitmap(bm);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902329_net_work);

        authorSeeButtom = findViewById(R.id.see);
        authorImageView = findViewById(R.id.pic);
        authorSeeButtom.setOnClickListener(new authorSeeButtomListerner());
    }

    private class authorSeeButtomListerner implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            new Thread(){
                @Override
                public void run() {
                    String path = "https://raw.githubusercontent.com/OrangeHap/android-labs-2018/master/soft1614080902329/lab6_author.png";
                    try{
                        URL url = new URL(path);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(10000);
                        int code = connection.getResponseCode();
                        if(code == 200){
                            InputStream inputStream = connection.getInputStream();
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            Message msg = Message.obtain();
                            msg.obj = bitmap;
                            handler.sendMessage(msg);
                            Log.v("code","ok");
                        }
                        Log.v("code","pass");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }
}
