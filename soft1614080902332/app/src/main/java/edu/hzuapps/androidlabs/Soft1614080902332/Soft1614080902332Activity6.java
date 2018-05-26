package edu.hzuapps.androidlabs.Soft1614080902332;

import android.os.Bundle;
import android.app.ListActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.widget.SimpleAdapter;

public class Soft1614080902332Activity6 extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.soft_1614080902332_activity4,
                new String[]{"tname","ttime","tplace","tphone","imageView"},
                new int[]{R.id.tname,R.id.ttime,R.id.tplace,R.id.tphone,R.id.imageView});
        setListAdapter(adapter);
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tname", "数据结构课本");
        map.put("ttime", "2018年5月21日");
        map.put("tplace","5-409");
        map.put("tphone","15217827325" );
        map.put("imageView", R.drawable.picture3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("tname", "汇编语言课本");
        map.put("ttime", "2018年5月17日");
        map.put("tplace","4-502");
        map.put("tphone","13729517639" );
        map.put("imageView", R.drawable.picture3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("tname", "计算机组成原理课本");
        map.put("ttime", "2018年5月14日");
        map.put("tplace","5-301");
        map.put("tphone","15217827325" );
        map.put("imageView", R.drawable.picture3);
        list.add(map);

        return list;
    }
}
