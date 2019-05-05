package edu.hzuapps.androidlabs.soft1614080902324;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {
    String s=null;
    String s1=null;
    String s2=null;
};

public class Soft1614080902324Activity3 extends ListActivity {
    Result S=new Result();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String s3=null;
        s3=getContent();
        int i=Integer.parseInt(s3);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(i),R.layout.activity3_soft1614080902324,
                new String[]{"title","info"},
                new int[]{R.id.title,R.id.info});
        setListAdapter(adapter);
    }

    private List<Map<String, Object>> getData(int i) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        for (int j = 1; j <= i; j++) {
            S = getContent(j, S);
            if (S.s1.indexOf(S.s) != -1||S.s2.indexOf(S.s) != -1) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title", S.s1);
                map.put("info", S.s2);
                list.add(map);
                continue;
            }
        }
        return list;
    }
    private Result getContent(int i, Result result) {
        String s=null;
        String s1=null;
        String s2=null;
        FileInputStream fis = null;
        try {
            fis = this.openFileInput("search.txt");
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s = new String(buf, 0, len, "UTF-8");
            }
            fis = this.openFileInput("name"+i+".txt");
            len = 0;
            buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s1 = new String(buf, 0, len, "UTF-8");
            }
            fis = this.openFileInput("message"+i+".txt");
            len = 0;
            buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s2 = new String(buf, 0, len, "UTF-8");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        result.s=s;
        result.s1=s1;
        result.s2=s2;
        return  result;
    }
    private String getContent() {
        String s=null;
        FileInputStream fis = null;
        try {
            fis = this.openFileInput("amount.txt");
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s = new String(buf, 0, len, "UTF-8");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }
}
