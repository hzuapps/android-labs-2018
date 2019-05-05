package edu.hzuapps.androidlabs.soft1614080902221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public class Activity5 extends AppCompatActivity {

    private List<PlayerData> playerDataList = new ArrayList<PlayerData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        String address = "https://raw.githubusercontent.com/yangyangyang2017/android-labs-2018/master/soft1614080902221/网络排行榜.json";
        //发送请求
        HttpUtil.sendOkHttpRequest(address, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("排行榜","网络异常");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //获取的json数据
                String responseData = response.body().string();
                try {
                    //解析json
                    JSONArray jsonArray = new JSONArray(responseData);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String strPlayerName = jsonObject.getString("playerName");
                        String strSex = jsonObject.getString("sex");
                        String strGameCharacters = jsonObject.getString("gameCharacters");
                        int intTime = jsonObject.getInt("time");
                        PlayerData playerData = new PlayerData(strPlayerName, strSex, strGameCharacters, intTime);
                        playerDataList.add(playerData);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //更新UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //通过id找到RecyclerView2组件对象
                        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view2);
                        //创建一个LinearLayoutManager对象
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Activity5.this);
                        //设置recyclerView的布局方式为LinearLayout
                        recyclerView.setLayoutManager(linearLayoutManager);
                        //创建适配器，并将playerDataList传入PlayerDataAdapter的构造函数中
                        PlayerDataAdapter playerDataAdapter = new PlayerDataAdapter(playerDataList);
                        //给recyclerView设置适配器
                        recyclerView.setAdapter(playerDataAdapter);
                    }
                });


            }
        });


    }
}
