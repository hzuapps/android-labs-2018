package edu.hzuapps.androidlabs;

import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class AnalyseJSON {

    String name[]=new String[100];
    String description[]=new String[100];

    public void parseByGSON(String text) {
        Gson gson = new Gson();
        List<Info> infoList = gson.fromJson(text, new TypeToken<List<Info>>() {
        }.getType());
        for (int i = 0; i < infoList.size(); i++) {
            Info info = infoList.get(i);
            System.out.println("#"+(i+1)+info.getName()+"\t"+info.getDescription()+"\n");
            name[i]=info.getName();
            description[i]=info.getDescription();
        }
    }
}
