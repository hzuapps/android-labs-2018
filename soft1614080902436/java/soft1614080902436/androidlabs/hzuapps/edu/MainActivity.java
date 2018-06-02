package soft1614080902436.androidlabs.hzuapps.edu.app;

import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{
    private Button submit;
    private Button readtext;
    private EditText phone;
    private EditText name;
    private Button downloadphoto;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //页面初始化
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //submit添加监听
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //获取文本
                phone = (EditText) findViewById(R.id.editphone);
                name = (EditText) findViewById(R.id.editname);

                if(phone.getText().length() == 0 ||name.getText().length() == 0 )
                {
                    //空值操作
                    Toast tot = Toast.makeText(
                            MainActivity.this,
                            "姓名与联系方式不可为空",
                            Toast.LENGTH_LONG);
                    tot.show();
                }
                //非空值操作
                else
                {
                    save(name.getText() + ":" + phone.getText());
                    name.setText("");
                    phone.setText("");
                }
            }

        });

        //读取键初始化及添加监听
        readtext = (Button) findViewById(R.id.read);
        readtext.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(
                        MainActivity.this,
                        read(),
                        Toast.LENGTH_LONG).show();
            }
        });

        downloadphoto = (Button) findViewById(R.id.downloadphoto);
        downloadphoto.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                iv = (ImageView)findViewById(R.id.photo);
                iv.setImageResource(R.drawable.list);

                String url = "https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=logo&step_word=&hs=0&pn=137&spn=0&di=28599681680&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1947969815%2C3457429257&os=775224440%2C3910388818&simid=2026134571%2C818708110&adpicid=0&lpn=0&ln=1981&fr=&fmq=1527926221510_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=13&oriquery=&objurl=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa9d3fd1f4134970adb749a089ecad1c8a7865d96.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Frwtxtg_z%26e3Bv54AzdH3Fri5p5v5ry6t2ipAzdH3F8nl8n8bba&gsm=5a&rpstart=0&rpnum=0&islist=&querylist=";
                loadRmoteImage(url);
            }
        });


    }

    private void loadRmoteImage(String imgUrl) {
        URL fileURL = null;
        Bitmap bitmap = null;
        try
        {
            fileURL = new URL(imgUrl);
        } catch (MalformedURLException err) {
            err.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) fileURL
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            int length = (int) conn.getContentLength();
            if (length != -1) {
                byte[] imgData = new byte[length];
                byte[] buffer = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(buffer)) > 0) {
                    System.arraycopy(buffer, 0, imgData, destPos, readLen);
                    destPos += readLen;
                }
                bitmap = BitmapFactory.decodeByteArray(imgData, 0,
                        imgData.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        iv.setImageBitmap(bitmap);
    }

    public void save(String text)
    {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try
        {
            out = openFileOutput("new.txt", ContextWrapper.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
            Toast.makeText(MainActivity.this, "存储成功", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "存储失败", Toast.LENGTH_SHORT).show();
        }
        finally
        {
            try
            {
                if (writer != null)
                {
                    writer.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "存储失败", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public String read()
    {
        String content = "";
        try
        {
            FileInputStream fis = openFileInput("new.txt");
            if (fis == null)
            {
                return null;
            }
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            content = new String(buffer);

            //清空文件
            File file = new File("new.txt");
            file.delete();

            fis.close();
            //Toast.makeText(MainActivity.this, "读取成功", Toast.LENGTH_SHORT).show();
            return content;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "读取失败", Toast.LENGTH_SHORT).show();
            return null;
        }
    }
}
