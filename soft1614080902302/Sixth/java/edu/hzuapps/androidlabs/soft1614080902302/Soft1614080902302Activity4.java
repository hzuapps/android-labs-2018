package edu.hzuapps.androidlabs.soft1614080902302;

 import android.os.Bundle;
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
 import android.app.Activity;
 import android.content.Intent;
 import android.graphics.Bitmap;
 import android.graphics.BitmapFactory;
 import android.os.Bundle;
 import android.os.Environment;
 import android.os.Handler;
 import android.os.Message;
 import android.view.View;
 import android.view.View.OnClickListener;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.ImageView;

 public class Soft1614080902302Activity4 extends AppCompatActivity {
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
 
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_soft16140809023053);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         setContentView(R.layout.activity_soft16140809023053);
         editText = (EditText) findViewById(R.id.imagepath);
         button = (Button) findViewById(R.id.upload);
         imageView = (ImageView) findViewById(R.id.imageView);
         button.setOnClickListener(new OnClickListener() {
             public void onClick(View arg0) {
                 new Thread(t).start();
             }
         });
     }
 
     //Ϊ������ͼƬ���߳�
     Thread t=new Thread(){
         public void run() {
             //����ͼƬ��·��
             String iPath=editText.getText().toString();
             try {
                 //����Դ����
                 URL url=new URL(iPath);
                 //��������
                 InputStream inputStream=url.openStream();
                 //��������Դ��������ת��λͼͼƬ
                bitmap=BitmapFactory.decodeStream(inputStream);
                h.sendEmptyMessage(111);
                inputStream.close();
 
                 //��һ�δ�
                 inputStream=url.openStream();
                 File file=new File(Environment.getExternalStorageDirectoy()+"/DCIM/");
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
 