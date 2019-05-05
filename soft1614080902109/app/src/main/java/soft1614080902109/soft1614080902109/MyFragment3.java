package soft1614080902109.soft1614080902109;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hasee on 2018/5/22.
 */

public class MyFragment3 extends Fragment implements View.OnClickListener{

    private String content;

    private EditText editText;
    private Button button;
    private ImageView imageView;

    private Bitmap bitmap;
    //手柄更新的作用
    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        };
    };

    public MyFragment3() {
    }


    public MyFragment3 newInstance(int content) {
        this.content = content+"";
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fg_3,container,false);

        //初始化组件
        editText=(EditText) view.findViewById(R.id.imagepath);
        button=(Button) view.findViewById(R.id.upload);
        imageView=(ImageView) view.findViewById(R.id.imageView);

        //给下载按钮添加一个监听
        button.setOnClickListener(this);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onClick(View v) {
        if(v == button)new Thread(t).start();
    }
    Thread t=new Thread(){
        public void run() {
            //下载图片的路径
            String iPath=editText.getText().toString();
            try {
                //对资源链接
                URL url=new URL(iPath);
                System.out.println(url.toString());
                //打开输入流
                InputStream inputStream=url.openStream();
                //对网上资源进行下载转换位图图片
                bitmap= BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();

                //再一次打开
                inputStream=url.openStream();
                File file=new File(Environment.getExternalStorageDirectory()+"/haha.gif");
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
