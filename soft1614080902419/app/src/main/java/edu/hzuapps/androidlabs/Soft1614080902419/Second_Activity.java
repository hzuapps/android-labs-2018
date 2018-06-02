package edu.hzuapps.androidlabs.Soft1614080902419;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class Second_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView t[] = new TextView[18];
    TextView counting,result;

    public TextView text;
    private ImageView imageview;
    private Bitmap bitmap;
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==123){
                imageview.setImageBitmap(bitmap);
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        this.RegisterEvent();
    }
    public void RegisterEvent(){
        imageview=(ImageView) findViewById(R.id.image);
        text = (TextView)findViewById(R.id.address);
        counting = (TextView) findViewById(R.id.counting);
        result = (TextView) findViewById(R.id.result);
        String str = "R.id.n_0";
        t[0] = (TextView) findViewById(R.id.n_0);
        t[1] = (TextView) findViewById(R.id.n_1);
        t[2] = (TextView) findViewById(R.id.n_2);
        t[3] = (TextView) findViewById(R.id.n_3);
        t[4] = (TextView) findViewById(R.id.n_4);
        t[5] = (TextView) findViewById(R.id.n_5);
        t[6] = (TextView) findViewById(R.id.n_6);
        t[7] = (TextView) findViewById(R.id.n_7);
        t[8] = (TextView) findViewById(R.id.n_8);
        t[9] = (TextView) findViewById(R.id.n_9);
        t[10] = (TextView) findViewById(R.id.n_10);
        t[11] = (TextView) findViewById(R.id.n_11);
        t[12] = (TextView) findViewById(R.id.n_12);
        t[13] = (TextView) findViewById(R.id.n_13);
        t[14] = (TextView) findViewById(R.id.n_14);
        t[15] = (TextView) findViewById(R.id.n_15);
        t[16] = (TextView) findViewById(R.id.n_16);
        t[17] = (TextView) findViewById(R.id.n_17);
        for(int i=0;i<18;i++){
            t[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        for(int i=0;i<18;i++){
            if(t[i]==view&&i==14){            //点击等号
                String str = t[i].getText().toString(),str1="10";
                this.save(str,str1);
                String s = counting.getText().toString();
                result.setText(s);
                counting.setText(str1);
                new Thread(download).start();
            }
            else if(t[i]==view){
                String str = t[i].getText().toString();
                counting.append(str);
            }
        }
    }
    public void save(String str,String str1){
        String data = str,data1 = str1;
        FileOutputStream out = null;
        FileOutputStream out1 = null;
        BufferedWriter writer1 = null;
        BufferedWriter writer2 = null;
        try{
            out = openFileOutput("counting.txt", Context.MODE_PRIVATE);
            writer1 = new BufferedWriter(new OutputStreamWriter(out));
            writer1.write(data);
            out1 = openFileOutput("result.txt", Context.MODE_PRIVATE);
            writer2 = new BufferedWriter(new OutputStreamWriter(out1));
            writer2.write(data1);
        }catch (IOException e){
        }finally {
            try {
                writer1.close();
                writer2.close();
            } catch (IOException e) {
            }
        }
    }
    Thread download = new Thread(){
        public void run() {
            String Path=text.getText().toString();//下载图片的路径
            try {
                URL url=new URL(Path);//对资源链接
                InputStream inputStream=url.openStream();
                bitmap= BitmapFactory.decodeStream(inputStream);//转换成位图图片
                handler.sendEmptyMessage(123);
                inputStream.close();
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"./DCIM/t1.jpg");
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
        }
    };
}
