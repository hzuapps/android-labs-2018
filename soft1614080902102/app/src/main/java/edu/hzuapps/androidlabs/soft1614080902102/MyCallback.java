package edu.hzuapps.androidlabs.soft1614080902102;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

public abstract class MyCallback extends Callback<List<Roomate>> {
    @Override
    public List<Roomate> parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        List<Roomate> roomate = new Gson().fromJson(string, new TypeToken<List<Roomate>>(){}.getType());
        return roomate;
    }
}
