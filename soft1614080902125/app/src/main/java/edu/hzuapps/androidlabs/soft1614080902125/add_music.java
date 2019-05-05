package edu.hzuapps.androidlabs.soft1614080902125;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import android.os.Handler;

public class add_music extends AppCompatActivity {


    private EditText editText;
    private Button button02;
    private Bitmap bitmap;
    private ImageView imageView;
    private URL url = null;

    public List<Song> getLocalMusic(Context context) {
        List<Song> list_local = new ArrayList<>();
        //isGrantExternalRW((Activity) context);
        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        //System.out.println("i");
        if(cursor!=null) {

            for (int i = 0; i < cursor.getCount(); i++) {
                Song song = new Song();
                cursor.moveToNext();
                System.out.println(i);
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
                String title = cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));
                String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));

                if (isMusic != 0 && duration / (1000 * 60) >= 1) {
                    song.setId(id);
                    song.setTitle(title);
                    song.setArtist(artist);
                    song.setDuration(duration);
                    song.setSize(size);
                    song.setUrl(url);
                    list_local.add(song);
                }

            }
            cursor.close();
        }
        return list_local;
    }

    public static List<HashMap<String, String>> getMusicMaps(
            List<Song> mp3Infos) {
        List<HashMap<String, String>> mp3list = new ArrayList<HashMap<String, String>>();
        int i = 0;
        for (Iterator iterator = mp3Infos.iterator(); iterator.hasNext();) {
            i++;
            Song mp3Info = (Song) iterator.next();
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("number",String.valueOf(i));
            map.put("id",String.valueOf(mp3Info.getId()));
            map.put("title", mp3Info.getTitle());
            map.put("Artist", mp3Info.getArtist());
            map.put("duration", formatTime(mp3Info.getDuration()));
            map.put("size", String.valueOf(mp3Info.getSize()));
            map.put("url", mp3Info.getUrl());
            mp3list.add(map);
        }
        return mp3list;
    }

    public static String formatTime(long time) {
        String min = time / (1000 * 60) + "";
        String sec = time % (1000 * 60) + "";
        if (min.length() < 2) {
            min = "0" + time / (1000 * 60) + "";
        } else {
            min = time / (1000 * 60) + "";
        }
        if (sec.length() == 4) {
            sec = "0" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 3) {
            sec = "00" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 2) {
            sec = "000" + (time % (1000 * 60)) + "";
        } else if (sec.length() == 1) {
            sec = "0000" + (time % (1000 * 60)) + "";
        }
        return min + ":" + sec.trim().substring(0, 2);
    }

    public static boolean isGrantExternalRW(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity.checkSelfPermission(
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            activity.requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 1);

            return false;
        }

        return true;
    }



    /*public String  getFileByUrl(String baseUrl) {
        try {
            URL url = new URL(baseUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setDoInput(true);        //设置输入流采用字节流
            urlConn.setDoOutput(true);        //设置输出流采用字节流
            urlConn.setRequestMethod("POST");
            urlConn.setUseCaches(false);    //设置缓存
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConn.setRequestProperty("Charset", "utf-8");
            urlConn.connect();

            DataOutputStream dos = new DataOutputStream(urlConn.getOutputStream());
            dos.writeBytes("tqpadmac=" + URLEncoder.encode("B407F9D67C80", "utf-8"));
            dos.writeBytes("tqpadver=" + URLEncoder.encode("1", "utf-8"));
            dos.flush();
            dos.close();

            //这句：new InputStreamReader(urlConn.getInputStream(), "gbk")  设置编码
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "gbk"));
            String line = "";
            String result = "";
            while (null != (line = br.readLine())) {
                result += line;
            }
            Log.d("chenzhu","chenzhu--->get data byurl接到的数据: " + result);
            br.close();
            urlConn.disconnect();
            return result;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return "";
    }*/

    Handler handler=new Handler(){
        public void handleMessage(Message msg) {
            if(msg.what==111){
                imageView.setImageBitmap(bitmap);
            }
        };
    };

    Thread t=new Thread(){
        public void run() {
            String iPath=editText.getText().toString();
            try {
                URL url=new URL(iPath);
                InputStream inputStream=url.openStream();
                bitmap=BitmapFactory.decodeStream(inputStream);
                handler.sendEmptyMessage(111);
                inputStream.close();
                inputStream=url.openStream();
                File sdCardDir = Environment.getExternalStorageDirectory();//获取sd卡目录
                File file = new File(sdCardDir,"p1.png");
                //File file=new File(Environment.getExternalStorageDirectory()+"/DCIM/");
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_music);
        editText = findViewById(R.id.editText);
        button02 = findViewById(R.id.button02);
        imageView=(ImageView) findViewById(R.id.imageView);
        ImageView back_view_add = findViewById(R.id.imageView_back_add);
        Button button_add = findViewById(R.id.button);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(add_music.this, "����ͨ��makeText������������Ϣ��ʾ��", Toast.LENGTH_SHORT).show();
                List<Song> list_local = getLocalMusic(getApplicationContext());
                List<HashMap<String, String>> local_music =getMusicMaps(list_local);
                RW_file_musiclist.writeListIntoSDcard("list_localmusic",local_music);

            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                new Thread(t).start();

            }
        });

        back_view_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

    }


}
