package edu.hzuapps.androidlabs.soft1614080902326;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AboutActivity extends Activity {

    public static final String TAG = AboutActivity.class.getSimpleName();
    private List<String> list=new ArrayList<String>();
    private ListView listView;
    public static final String WEB = "http://www.bing.com";
    public static final String IMAGE_URL_PREFIX = "https://raw.githubusercontent.com/hzuapps/android-labs/master/app/src/main/res/drawable/";

    static String[] imageNames = {"image_bmp.png", "image_gif.png", "image_ico.png",
            "image_jpeg.png", "image_png.png", "image_tiff.png"};

    // App的内部存储目录
    private File mPrivateRootDir;
    // “images”子目录
    private File mImagesDir;
    private ArrayAdapter<String> adapter;
    static String pictureUrl="http://img.zcool.cn/community/01626057ff29a1a84a0d304f3b5991.jpg@1280w_1l_2o_100sh.jpg";
    public String text=null;
    private TextView jsonid;
    private TextView jsonname;

    private boolean mConnected;
    private NetworkFileDownloader mFileDownloader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        /*jsonid=(TextView)findViewById(R.id.id);
        jsonname=(TextView)findViewById(R.id.name);*/
        checkNetworkState();
        listView=(ListView)findViewById(R.id.list_color) ;
        getJson();
        //downloadImages();

        //getHttpBitmap(pictureUrl);
        //savePicture(getHttpBitmap(pictureUrl));
        /*String result = getJson("province.txt");

        try {
            JSONArray json = new JSONArray(result);
            for(int i=0;i<json.length();i++)
            {
                JSONObject jb=json.getJSONObject(i);
                Log.d("AAA", jb.getString("name"));
                Log.d("AAA",String.valueOf(json.length()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

    }
    public void getJson(){
        new Thread(){
            @Override
            public void run() {
                try {
                    String jsonUrl="https://raw.githubusercontent.com/JWL1ang/android-labs-2018/master/soft1614080902326/list.json";
                    URL url=new URL(jsonUrl);
                    HttpURLConnection conn=(HttpURLConnection)url.openConnection();
                    conn.connect();
                    InputStream in = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(in);
                    BufferedReader buffer = new BufferedReader(input);
                    if(conn.getResponseCode()==200){//请求成功
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        parseJson();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter = new ArrayAdapter<String>(
                                AboutActivity.this, android.R.layout.simple_list_item_1, list);
                        listView.setAdapter(adapter);
                    }
                });
            }
        }.start();


    }
    public void parseJson() {
        try{
            JSONArray jsonArray = new JSONArray(text);
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject person = jsonArray.getJSONObject(i);
                String id = person.getString("id");
                String hex = person.getString("hex");
                String r=person.getString("r");
                String g=person.getString("g");
                String b=person.getString("b");

                /*jsonid.setText(id);
                jsonname.setText(name);*/
                String item=id+"     "+"HEX "+hex+"    "+"R "+r+"    "+"G "+g+"    "+"B "+b+"    ";
                list.add(item);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String getJson2(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = AboutActivity.this.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
                Log.d("AAA", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public Bitmap getHttpBitmap(String url){
        Bitmap bitmap = null;
        try {
            URL picUrl=new URL(url);
            HttpURLConnection conn = (HttpURLConnection) picUrl.openConnection();
            InputStream in = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
            }
            return  bitmap;
    }
    public void savePicture(Bitmap bitmap)
    {
        String pictureName = "/mnt/sdcard/" + "pic"+".jpg";
        File file = new File(pictureName);
        FileOutputStream out;
        try
        {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void checkNetworkState() {
        // 取得连接管理器
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // 检查当前激的网络
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            mConnected = true;
        } else {
            mConnected = false;
        }

        String types = "";

        // 检查Wi-Fi
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = networkInfo != null && networkInfo.isConnected();
        types += isWifiConn ? "Wi-Fi" : "";

        // 检查数据网络
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = networkInfo != null && networkInfo.isConnected();
        types += isMobileConn ? "流量" : "";

        // 检查蓝牙
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH);
        boolean isBluetoothConn = networkInfo != null && networkInfo.isConnected();
        types += isBluetoothConn ? ", 蓝牙" : "";

            Toast.makeText(getApplicationContext(),mConnected ? "网络正常 (" +types + ")" : "网络未连接!",Toast.LENGTH_SHORT).show();

    }
    private void downloadImages() {
        // 创建下载器
        mFileDownloader = new NetworkFileDownloader(new NetworkFileDownloader.OnImageDownloadListener() {
            @Override
            public void onError(String error) {
                Toast.makeText(AboutActivity.this, error, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onProgressChange(int percent) {
                Log.i(TAG, "当前进度 = " + percent);
            }

            @Override
            public void onComplete(Bitmap bitmap, String imageUrl) {
                // 下载的图片格式为PNG
                final Bitmap.CompressFormat format = Bitmap.CompressFormat.PNG;
                // 解析出原始文件名
                String filename = imageUrl.replace(IMAGE_URL_PREFIX, "");
                final File imageFile = new File(mImagesDir, filename);
                // 将文件保存到磁盘中
                NetworkFileDownloader.writeToDisk(imageFile, bitmap, new NetworkFileDownloader.OnBitmapSaveListener() {
                    @Override
                    public void onBitmapSaved() {
                        Toast.makeText(AboutActivity.this, "文件已保存: " + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onBitmapSaveError(String error) {
                        Toast.makeText(AboutActivity.this, error, Toast.LENGTH_LONG).show();
                    }
                }, format, false);
            }
        });

        // 下载所有文件
        for(String imageName : imageNames) {
            String imageUrl = IMAGE_URL_PREFIX + imageName;
            mFileDownloader.download(imageUrl, true);
        }
    }


}
