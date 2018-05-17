package edu.hzuapps.androidlabs.soft1614080902326;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_collect);
        /*返回按钮
            点击返回主界面*/
        Button back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ();
                intent.setClass(CollectActivity.this,Soft1614080902326Activity.class);
                startActivity(intent);
                finish();    //退出当前Activity

            }
        });
//        添加颜色列表
        ListView colorList=(ListView)findViewById(R.id.list_color);//绑定Layout里面的ListView
        //生成动态数组，加入数据
        ArrayList<HashMap<String,Object>> listItem=new ArrayList<HashMap<String,Object>>();
        for(int i=0;i<30;i++)
        {
            HashMap<String,Object> map =new HashMap<String,Object>();
            map.put("ItemImage", R.mipmap.ic_launcher);//图像资源的ID
            map.put("timeItem", "21:30");
            map.put("dateItem", "2018-4-9");
            listItem.add(map);
        }
        //生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源
                R.layout.list_item_layout,//ListItem的XML实现
                //动态数组与ImageItem对应的子项
                new String[] {"ItemImage","timeItem", "dateItem"},
                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[] {R.id.ItemImage,R.id.timeItem,R.id.dateItem}
        );

        //添加并且显示
        colorList.setAdapter(listItemAdapter);

        //添加点击
        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //showPopupWindow();
                //setTitle("点击第"+arg2+"个项目");
            }
        });
        /*Button about = (Button) findViewById(R.id.aboutButton);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ();
                intent.setClass(CollectActivity.this,aboutActivity.class);
                startActivity(intent);

            }
        });*/
    }
}
