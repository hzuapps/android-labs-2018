package ezu.hzuapps.androidlabs.Com1614080901231;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by BA on 2018/5/20 0020.
 */

public class ResultVM extends BaseObservable {
    private static final String TAG = "ResultVM";
    private String result;
    private SharedPreferences sp;

    public ResultVM(Context context){
        sp=(context).getSharedPreferences("data",Context.MODE_PRIVATE);
        if ("".equals(getHistory())){
            Log.d(TAG, "ResultVM: 没有历史记录");
            setResult("10086");
            setHistory();
        }else {
            Log.d(TAG, "取出历史记录: ");
            result=getHistory();
        }
    }

    @Bindable
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getHistory(){
        result= sp.getString("result","");
        return result;
    }

    public void setHistory(){
        SharedPreferences.Editor e;
        e= sp.edit();//获取实例
        e.putString("result",result);
        e.apply();//将数据保存
    }
}
