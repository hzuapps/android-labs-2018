package com.example.administrator.hzulife.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.hzulife.R;
import com.example.administrator.hzulife.model.bean.LostBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 *     author : 蔡文豪
 *     e-mail : 1261654234@qq.com
 *     time   : 2018/5/1
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */
//设置数据适配器
public class LostAdapter extends BaseAdapter {
    private List<LostBean>list;
    private Context context;
    public LostAdapter(Context context,List<LostBean> list){
       this.list=list;
       this.context=context;

    }
    @Override
    public int getCount() {
            return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null){
            //创建新的view对象
            view= View.inflate(context, R.layout.item_lost,null);
        }else{
            //复用历史缓存对象
            view=convertView;
        }
        TextView lost_thing=view.findViewById(R.id.tv_lost_things);
        TextView lost_title=view.findViewById(R.id.tv_lost_title);
        TextView lost_where=view.findViewById(R.id.tv_lost_where);
        TextView lost_time=view.findViewById(R.id.tv_lost_time);
        ImageView lost_img=view.findViewById(R.id.iv_lost_pic);
        lost_thing.setText(list.get(position).getThing());
        lost_title.setText(list.get(position).getTitle());
        lost_where.setText(list.get(position).getWhere());
        Date date=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");//获取系统当前时间
        lost_time.setText(df.format(date).toString());
        Glide.with(context).load(list.get(position).getPic1()).into(lost_img);//缓存图片
        return view;
    }
}