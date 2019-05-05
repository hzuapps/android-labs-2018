package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.List;

public class analyseData {
    private String pn[]=new String[10];
    private int ps[]=new int[10];
    public void parseJson(String text){
        Gson gson=new Gson();
        List<Player> playerList;
        playerList=gson.fromJson(text,new TypeToken<List<Player>>(){}.getType());
        System.out.println("Size"+playerList.size());
        for(int i=0;i<playerList.size();i++){
            Player player=playerList.get(i);
            System.out.println(player.getPlayername()+"||"+player.getPlayscore());
            pn[i]=player.getPlayername();
            ps[i]=player.getPlayscore();
        }
    }
    public String getPn(int i){
        return pn[i];
    }
    public int getPs(int i){
        return ps[i];
    }
}
