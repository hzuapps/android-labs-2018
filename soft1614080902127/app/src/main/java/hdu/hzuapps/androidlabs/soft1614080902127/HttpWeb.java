package edu.hzuapps.androidlabs.soft1614080902127;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class HttpWeb {
    private static  final String URL_PATH="http://127.0.0.1:8080/SSS/LoginServlet";

    public static Call postDataAsync(Map<String,String> parameterMap) {
        OkHttpClient client = new OkHttpClient();//创建OkHttpClient对象。
        FormBody.Builder formBody = new FormBody.Builder();//创建表单请求体
        Set<Map.Entry<String,String>> set=parameterMap.entrySet();//获取映射的Set视图
        Iterator<Map.Entry<String,String>>iterator=set.iterator();//获取迭代器
        while (iterator.hasNext()){
            Map.Entry mapEntry=(Map.Entry)iterator.next();
            formBody.add((String)mapEntry.getKey(),(String)mapEntry.getValue());
        }
//        formBody.add("username","zhangsan");//传递键值对参数
        Request request = new Request.Builder()//创建Request 对象。
                .url(URL_PATH)
                .post(formBody.build())//传递请求体
                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
        return client.newCall(request);//返回请求对象
    }
    public static Call getDataAsync(String path) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(path)
                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//            }
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if(response.isSuccessful()){//回调的方法执行在子线程。
//
//                }
//            }
//        });
        return client.newCall(request);
    }
}
