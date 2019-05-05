package com.example.intelligentcooker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.intelligentcooker.R;
import com.example.intelligentcooker.adapter.MealCardViewAdapter;
import com.example.intelligentcooker.bean.Event;
import com.example.intelligentcooker.bean.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author henyiwu
 * @date 2017/11/18
 */

public class Page2Fragment extends Fragment {

    List<Event> mRouList = new ArrayList<>();
    List<Event> mPaiGuList = new ArrayList<>();
    List<Event> mNiuWanList = new ArrayList<>();

    private static final String TAG = "Page2Fragment";
    private View mView;
    private MealCardViewAdapter mAdapter;
    private List<Meal> mList = new ArrayList<>();
    String url = "http://img.blog.csdn.net" +
            "/20170512092440718?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvVFNfbGVhcm5lcg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center";
    private Meal mAlbum;
    private Meal mMeal;
    private Meal mMeal2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.page2_layout, container, false);
        initAlbum();
        initStep();
        initStep2();
        initStep3();
        mAdapter = new MealCardViewAdapter(mList);
        RecyclerView recyclerView = mView.findViewById(R.id.recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);
        setFooterView(recyclerView);
        return mView;
    }

    private void initStep() {
        Event event = new Event(1 ,Integer.toString(1), "先准备带点肥的排骨（我觉得全瘦的没这好吃），想吃多少就准备多少，可叫卖肉师傅替你剁好；排骨宰成4厘米的段，姜切片, 葱洗净去头拴成一结(3根左右)");
        mRouList.add(event);
        Event event1 = new Event(15, Integer.toString(2), "排骨加水加适量盐煮至八成熟，时间充足的话可用电饭堡煮。");
        mRouList.add(event1);
        Event event2 = new Event(13, Integer.toString(3), "捞出排骨（汤备用），沥干后放入油锅, 待油还是冷的时候同时放入白糖(要多, 大概一份糖, 2.5或3份油), 小火慢慢把糖炒化。");
        mRouList.add(event2);
        Event event3 = new Event(18, Integer.toString(4), " 待糖水开始变成棕红色, 且开始冒棕红色的泡沫时, 马上把排骨倒入锅中炒匀,（不要太多油了，因为炸排骨还会出油的）翻炒，先倒入黄酒炒出酒香，再加酱油炒出酱香，然后往锅里浇汤，一次不要浇太多，再炒，多浇炒几次。");
        mRouList.add(event3);
        Event event4 = new Event(5, Integer.toString(5), "接着放入姜片, 花椒和香料, 炒出香味后倒入少许料酒和酱油上色, 掺入清水, 加入盐和葱结, 大火烧开后转至小火慢慢烧至排骨粑软, 然后夹去锅里的葱和大块头的香料, 大火收汁, 待汤汁变浓时, 加入味精起锅即成。");
        mRouList.add(event4);
    }

    private void initStep2() {
        Event event = new Event(2 ,Integer.toString(1), "猪肋排洗净，用刀斩成麻将块大小。煮锅里倒入清水，放入肋排小火煮开。煮5分钟后，捞出肋排，用清水冲洗。");
        mPaiGuList.add(event);
        Event event1 = new Event(5, Integer.toString(2), "把肋排再次倒入煮锅，小火煮5分钟。煮好的肋排捞出，浸泡在清水里，这样处理过的肋排清淡，口感发脆。");
        mPaiGuList.add(event1);
        Event event2 = new Event(7, Integer.toString(3), "锅里倒入油，热后放入生姜爆香，放入八角桂皮。调入老抽，翻炒排骨上色。");
        mPaiGuList.add(event2);
        Event event3 = new Event(3, Integer.toString(4), "倒入足量的清水，大火煮开后改小火煮30分钟。");
        mPaiGuList.add(event3);
        Event event4 = new Event(8, Integer.toString(5), "西红柿洗净后切块。把西红柿倒入锅里，调入精盐，煮10分钟。");
        mPaiGuList.add(event4);
    }

    private void initStep3() {
        Event event = new Event(2 ,Integer.toString(1), "准备用料：\n" +
                "白萝卜半个（切片）、牛肉丸500克、生菜1棵、盐一勺、油适量、大蒜5瓣（捣碎）");
        mNiuWanList.add(event);
        Event event1 = new Event(10, Integer.toString(2), "锅内倒入适量油，小火，放入蒜末，煸至金黄");
        mNiuWanList.add(event1);
        Event event2 = new Event(10, Integer.toString(3), "倒入3碗白开水，一勺盐，倒入牛肉丸煮沸");
        mNiuWanList.add(event2);
        Event event3 = new Event(5, Integer.toString(4), "加入萝卜，继续煮。");
        mNiuWanList.add(event3);
        Event event4 = new Event(2, Integer.toString(5), "加入生菜。");
        mNiuWanList.add(event4);
        Event event5 = new Event(0, Integer.toString(6), "关火，收锅。");
        mNiuWanList.add(event5);
    }

    private void initAlbum() {
        mAlbum = new Meal(mRouList, "红烧肉", R.drawable.hongshaorou);
        mMeal = new Meal(mPaiGuList, "红烧排骨", R.drawable.hongshaopaigu);
        mMeal2 = new Meal(mNiuWanList, "清汤牛丸", R.drawable.qingtangriuwan);
//        mList.clear();
        for (int i = 0; i < 1; i++) {
            mList.add(mAlbum);
            mList.add(mMeal);
            mList.add(mMeal2);
        }
    }

    private void setFooterView(RecyclerView view){
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.rv_footer, view, false);
        mAdapter.setFootView(footer);
    }

}
