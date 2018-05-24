package edu.hzuapps.androidlabs.soft1614080902102;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;
import okhttp3.Request;

public class Main3Activity extends AppCompatActivity {
    private String floor;
    private String dorm;
    private String roommateA;
    private String roommateB;
    private String roommateC;
    private String roommateD;
    private TextView GithubResponse;
    private Handler handler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        handler = new Handler();
        GithubResponse = (TextView) findViewById(R.id.json_info);
        sendRequest();
    }

    private void sendRequest() {
        new Thread(){
            @Override
            public void run() {
                try {
//                    OkHttpClient client = new OkHttpClient();
//                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse("https://github.com/1614080902102/android-labs-2018/soft1614080902102/app/src/main/java/edu/hzuapps/androidlabs/soft1614080902102/Soft1614080902102json.json"));//目标地址
//                    Response response;
//                    response = client.newCall(request).execute();
//                    String responseData = response.body().string();
//                    ParseJson(responseData);
                    String url = "https://raw.githubusercontent.com/1614080902102/android-labs-2018/master/soft1614080902102/app/src/main/java/edu/hzuapps/androidlabs/soft1614080902102/Soft1614080902102b.json";
                    OkHttpUtils
                            .get()
                            .url(url)
                            .build()
                            .execute(new MyCallback() {
                                @Override
                                public void onError(Call call, Exception e, int id) {
                                    Log.e("111", e.getMessage());
                                }

                                @Override
                                public void onResponse(List<Roomate> response, int id) {
                                    floor = response.get(0).getFloor();
                                    dorm = response.get(0).getDorm();
                                    roommateA = response.get(0).getRoommateA();
                                    roommateB = response.get(0).getRoommateB();
                                    roommateC = response.get(0).getRoommateC();
                                    roommateD = response.get(0).getRoommateD();
                                    handler.post(runnableUi);
                                }

                            });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.start();
    }

    /*解析json文件*/
//    private void ParseJson(String jsonData) {
//        try {
//            JSONArray jsonArray = new JSONArray(jsonData);
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                floor= jsonObject.getString("floor");
//                dorm= jsonObject.getString("dorm");
//                roommateA= jsonObject.getString("roommateA");
//                roommateB= jsonObject.getString("roommateB");
//                roommateC= jsonObject.getString("roommateC");
//                roommateD= jsonObject.getString("roommateD");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /*更新UI*/
    Runnable runnableUi = new Runnable() {
        public void run() {
            GithubResponse.setText("宿舍楼号: " + floor + "\n" + "\n" + "宿舍号: " + dorm + "\n" + "\n" + "舍友A: " + roommateA + "\n" + "\n"+ "舍友B: " + roommateB + "\n" + "\n"+ "舍友C: " + roommateC + "\n" + "\n"+"舍友D:"+roommateD+"\n"+"\n"

            );//显示解析结果
        }
    };
}