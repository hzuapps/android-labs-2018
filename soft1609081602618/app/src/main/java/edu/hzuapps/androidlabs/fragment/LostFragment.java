package com.example.administrator.hzulife.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.administrator.hzulife.LostActivity;
import com.example.administrator.hzulife.R;
import com.example.administrator.hzulife.RecordSearchActivity;
import com.example.administrator.hzulife.adapter.LostAdapter;
import com.example.administrator.hzulife.model.bean.LostBean;
import com.example.administrator.hzulife.util.OkHttpUtils;
import com.example.administrator.hzulife.util.RecordDBHelper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/11
 *     desc   : 失物招领页面
 *     version: 1.0
 * </pre>
 */
public class LostFragment extends Fragment {
    private Boolean isAdd=false;
    private List<LostBean>list;
    private static  final String URL_PATH="http://111.230.49.54:8080/SSS/LoginServlet";
    private RelativeLayout fb_pop;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initList();
        View view=inflater.inflate(R.layout.activity_lost,null);
        initView(view);
        return view;
    }
    //初始化list
    private void initList(){
        list=new ArrayList<>();
        LostBean lb=new LostBean();
        lb.setThing("钥匙");
        lb.setTitle("丢失的物品");
        lb.setWhere("图书馆");
        list.add(lb);
    }
    //初始化view
    private void initView(View view){
        //利用view获取控件id
        ListView lv=view.findViewById(R.id.lv_lost);
        lv.setAdapter(new LostAdapter(getActivity(),list));
        lv.setOnItemClickListener(new LostOnItemClickListener());
        //获取FloatingActionButton点击事件
        com.github.clans.fab.FloatingActionButton my=view.findViewById(R.id.fb_personal);
        com.github.clans.fab.FloatingActionButton search=view.findViewById(R.id.fb_search);
        com.github.clans.fab.FloatingActionButton fb=view.findViewById(R.id.fb);
        fb.setOnClickListener(new FBClickListener());
        search.setOnClickListener(new FBClickListener());
        my.setOnClickListener(new FBClickListener());

    }
    //浮动按钮监听事件
    private class FBClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            switch (v.getId()){

                case R.id.fb_personal:

                    break;
                case R.id.fb_search:
                    intent.setClass(getActivity(), RecordSearchActivity.class);
                    startActivity(intent);
                    break;
                case R.id.fb:
                    intent.setClass(getActivity(), LostActivity.class);
                    startActivity(intent);
                    break;
                    default:
                        break;
            }
        }
    }
    //连接服务器
    private void urlConnection(){
        OkHttpUtils.getDataAsync(URL_PATH).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "服务器繁忙", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
             getActivity().runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     Gson gson = new Gson();
                     //获取json数据
                     LostBean lb=gson.fromJson(response.body().charStream(),LostBean.class);
                     list.add(lb);
                 }
             });
            }
        });
    }

    //设置listView事件监听
    private class LostOnItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }


}
