package soft1614080902408.androidlabs.hzuapps.edu.soft1614080902408_zhangyoubao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Soft1614080902408_zhangyoubao extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    public static final String FILENAME = "file_demo.txt";
    private ListView listView = null;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_soft1614080902408_zhangyoubao);

        Button loginBtn = (Button) findViewById(R.id.owbutton);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent();

                intent.setClass(Soft1614080902408_zhangyoubao.this, Soft1614080902408_LoginActivity.class);

                startActivity(intent);

            }

        });
        Button loginBtn1 = (Button) findViewById(R.id.undoButton);

        loginBtn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
            //读取新闻的监听器
                Intent intent = new Intent();

                intent.setClass(Soft1614080902408_zhangyoubao.this, new_item.class);

                startActivity(intent);
            }

        });
    creatList();
    }



    public void creatList(){

        ArrayList<NewsItem> items = new ArrayList<>();
        items.add(new NewsItem("半藏重做后对天梯的影响", "新闻"));
        items.add(new NewsItem("源氏被削", "蓝贴"));
        items.add(new NewsItem("阿三秩序之光重做", "蓝贴"));
        items.add(new NewsItem("天使出粉红丝带皮肤，为了公益", "新闻"));
        items.add(new NewsItem("姐夫又出来了", "蓝贴"));
        items.add(new NewsItem("守望新角色", "新闻"));
        items.add(new NewsItem("姐夫直播发呆", "视频"));
        items.add(new NewsItem("源氏4000分段教学", "攻略"));
        items.add(new NewsItem("布里吉塔盾猛使用", "攻略"));
        items.add(new NewsItem("白虎一键召唤，神装满地爆，比渣渣辉更加666", "广告"));

        listView = (ListView) findViewById(R.id.newsList);
        final NewsAdapter adapter = new NewsAdapter(this, R.id.newsList, items);
        //设置ListView的点击监听器
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Soft1614080902408_zhangyoubao.this, "click:" + id, Toast.LENGTH_LONG).show();
                view.setSelected(true); //被点击的 View 设置 selected 状态
            }
        });

        listView.setAdapter(adapter);
    }

    public void onClick(View v) {

    }

    class NewsAdapter extends ArrayAdapter<NewsItem> {//newsItems与ListView的适配器
        private ArrayList<NewsItem> items;//保存整个列表

        //NewsAdaper的简单初始化
        public NewsAdapter(Context context, int resource, ArrayList<NewsItem> items) {
            super(context, resource, items);
            this.items = items;
        }

        @Override

        public View getView(int pos, View convertView, ViewGroup parent) {//?
            View v = convertView;
            if (v == null) {//如果特定位置的 view是null的，那么填充它，然后用songItemHolder进行关联
                LayoutInflater vi = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.news_list_item, null);
            }
            TextView title = v.findViewById(R.id.title_name);
            title.setText(items.get(pos).title);
            TextView fenlei = v.findViewById(R.id.fenlei_name);
            fenlei.setText(items.get(pos).fenlei);

            //返回被展示的View
            return v;
        }
    }

    class NewsItem {//新建新闻分类，标题
        private String title;
        private String fenlei;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFenlei() {
            return fenlei;
        }

        public void setFenlei(String fenlei) {
            this.fenlei = fenlei;
        }

        public NewsItem(String title, String fenlei) {
            this.title = title;
            this.fenlei = fenlei;
        }
    }

}
