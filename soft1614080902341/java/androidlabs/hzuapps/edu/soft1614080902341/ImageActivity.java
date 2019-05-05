package androidlabs.hzuapps.edu.soft1614080902341;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageActivity extends ActionBarActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageActivity.this,"图片开始下载",Toast.LENGTH_SHORT).show();
                new Thread() { //开启子线程专门用于联网，防止与主线程一起造成无网络或连接延时造成的假死状态，增加用户体验
                    @Override
                    public void run() {
                        String path = "https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92" +
                                "%2C5%2C5%2C92%2C30/sign=94e5e15713d5ad6ebef46cb8e0a252be/21a4462309f79052dedc9dad04f3d7ca7acbd566.jpg";
                        try {
                            URL url = new URL(path);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET");
                            connection.setConnectTimeout(10000);
                            int code = connection.getResponseCode();
                            if (code == 200) {//判断状态码
                                InputStream is = connection.getInputStream();
                                Bitmap btImage = BitmapFactory.decodeStream(is);
                                File file = new File(Environment.getExternalStorageDirectory(), "惠州学院.jpg");
                                FileOutputStream out;
                                try {
                                    out = new FileOutputStream(file);
                                    btImage.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                    out.flush();
                                    out.close();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                Toast.makeText(ImageActivity.this, "图片保存成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
