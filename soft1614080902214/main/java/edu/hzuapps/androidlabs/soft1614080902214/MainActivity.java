package edu.hzuapps.androidlabs.soft1614080902214;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private ImageView imageView;
    private Bitmap bitmap;

    Handler h;

    {
        h= new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 111) {
                    imageView.setImageBitmap(bitmap);
                }
            }

            ;
        };
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.imagepath);
        button = (Button) findViewById(R.id.upload);
        imageView = (ImageView) findViewById(R.id.imageView);

    }

    public void click3(View v) {
        new Thread(t).start();
    }

    Thread t=new Thread(){
        public void run() {
            //下载图片的路径
            String iPath=editText.getText().toString();
            try {
                //对资源链接
                URL url=new URL(iPath);
                //打开输入流
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap=BitmapFactory.decodeStream(inputStream);
                h.sendEmptyMessage(111);
                inputStream.close();

                //再一次打开
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/DCIM/");
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                int hasRead=0;
                while((hasRead=inputStream.read())!=-1){
                    fileOutputStream.write(hasRead);
                }
                fileOutputStream.close();
                inputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    };

}
