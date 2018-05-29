package edu.hzuapps.androidlabs.Com1614080901208;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;


import com.example.cnt.textapplication.R;
import com.example.cnt.textapplication.VM.ImageViewBean;
import com.example.cnt.textapplication.databinding.ActivityMainBinding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Com1614080901208Activity extends AppCompatActivity {
    private int pictureSrc = R.drawable.mainactivitybackground;
    public static final String  SPKEY= "bookContext";

    List<RVBean> list;
    List<String> bookName;
    List<String> imageList;
    List<String> textList;
    MainRVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initImageListData();
        initBookName();
        initTextListData();
        initListData();
        rvAdapter = new MainRVAdapter(list);
        rvAdapter.setOnItemClickListener(new MainRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(Com1614080901208Activity.this, SecondActivity.class);
                intent.setType(imageList.get(position));
                intent.putExtra("bookname",bookName.get(position));
                startActivity(intent);
                overridePendingTransition(R.anim.enteracitivity,R.anim.enteracitivity);
            }
        });
        binding.mainRecyclerview.setAdapter(rvAdapter);
        binding.mainRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearlayout);

        //将下载下来的图片设置背景图片
        new mythread("http://pic.qiantucdn.com/58pic/11/62/97/41S58PICNCu.jpg",linearLayout,new Handler()).start();

    }


    private void initListData() {
        list = new ArrayList<>();
        if (imageList != null) {
            RVBean rvBean1 = new RVBean("动物世界",imageList.get(0) );
            list.add(rvBean1);
            RVBean rvBean2 = new RVBean("第一行代码", imageList.get(1));
            list.add(rvBean2);
            RVBean rvBean3 = new RVBean("中国鱼类图鉴",imageList.get(2) );
            list.add(rvBean3);

        }

    }
    private void initBookName(){
        bookName = new ArrayList<>();
        bookName.add("DWSJ");
        bookName.add("DYHDM");
        bookName.add("ZGZM");

    }

    private void initImageListData() {
        imageList = new ArrayList<>();
        imageList.add("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=bb3e47ed522c11dfcadcb771024e09b5/ae51f3deb48f8c544d0945213f292df5e1fe7fe2.jpg");
        imageList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526124151771&di=0f954e32afbe2f5cb6ad80c9a0554465&imgtype=0&src=http%3A%2F%2Fimg3x6.ddimg.cn%2F46%2F1%2F24144166-1_w_23081.jpg");
        imageList.add("https://img3.doubanio.com/view/subject/l/public/s28480882.jpg");


    }
    private void initTextListData(){
        textList = new ArrayList<>();
        textList.add("      《动物世界》是2010年4月1日航空工业出版社出版的图书，作者是郭漫。该书介绍了生物界形形色色的各种有趣动物，以全新的视角及准确、生动的文字带你进入动物的世界。");
        textList.add("      第一行代码——Android》是Android初学者的最佳入门书。全书由浅入深、系统全面地讲解了Android软件开发的方方面面。第1章带领你搭建Android开发环境，完成你的第一个Android程序。第2章至第13章完整地讲解了Android开发中的各种基本知识和关键技术，包括四大组件、UI、碎片、广播机制、数据存储、服务、多媒体、网络、定位服务、传感器，以及分布式版本控制系统Git的使用等等。第14章和第15章则将带领你编写一个完整的项目，教会你如何打包、上架、嵌入广告并获得盈利。《第一行代码——Android》内容通俗易懂，既适合初学者循序渐进地阅读，也可作为一本参考手册，随时查阅。");
        textList.add("      中国之美——自然科普图鉴”是一套专为展现中国独有的自然生态之美而策划出版的大型系列丛书，包括《中国昆虫图鉴》《中国鱼类图鉴》《中国野菜图鉴》《中国野花图鉴》《中国观赏花卉图鉴》《中国恐龙图鉴》《中国鸟类图鉴》《中国蝴蝶与蛾类图鉴》《中国田野作物图鉴》《中国古动物化石图鉴》，共计10册，其内容涵盖了从植物界到动物界，从古生物到现代生物的广泛而丰富的内容，图文并茂地呈现了中国生命科学的研究新成果，是国内首部大型词典型自然科普图鉴。");

        saveText(bookName.get(0),textList.get(0));
        saveText(bookName.get(1),textList.get(1));
        saveText(bookName.get(2),textList.get(2));


    }
    private void saveText(String name,String text){
        SharedPreferences.Editor editor = getSharedPreferences(SPKEY,MODE_PRIVATE).edit();
        editor.putString(name,text);
        editor.apply();
    }
}
