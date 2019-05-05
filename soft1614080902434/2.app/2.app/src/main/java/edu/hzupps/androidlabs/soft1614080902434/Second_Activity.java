package soft1614080902434.androidlabs.hzuapps.edu.soft1614080902434;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
   EditText ed;
   Button send,down;
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
        setContentView(R.layout.activity_second_);
        this.RegisterEcent();
    }
    public void RegisterEcent(){
        down = (Button)findViewById(R.id.Down);
        down.setOnClickListener(this);
        imageview=(ImageView) findViewById(R.id.image);
        text = (TextView)findViewById(R.id.address);
        ed = (EditText)findViewById(R.id.edit_text);
        send = (Button)findViewById(R.id.n_12);
        send.setOnClickListener(this);
        Log.d("dd","789");
    }


    public void save(String str){
        String data=str;
        FileOutputStream out=null;
        BufferedWriter writer=null;

        try{
            out =openFileOutput("wechat", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            Log.d("dd","456");
            writer.write(data);
        }   catch(IOException e){
            e.printStackTrace();
        }   finally {
                   if (writer !=null){
                       try {
                           writer.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
        }
    }
    @Override
    public void  onClick(View view){
        if(view==send) {
            String str = ed.getText().toString();
            this.save(str);
            Log.d("dd", "123");
        }
        if(view==down){
            new Thread(download).start();
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
                File file=new File(Environment.getExternalStorageDirectory()+"./DCIM/wechat.jpg");
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
