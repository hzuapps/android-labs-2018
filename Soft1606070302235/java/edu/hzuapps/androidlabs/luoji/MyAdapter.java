package com.example.luoji;

import java.util.ArrayList;

import com.example.beans.Cuns;
import com.example.ibook.R;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/*
 * 用来填充ListView,这次成功把这个类从主页面分离，只要传过来两个值，inflater ,和数据ArrayList<>;
 */
public class MyAdapter extends BaseAdapter{

	LayoutInflater inflater;
	ArrayList<Cuns> array;
	 public MyAdapter(LayoutInflater inf,ArrayList<Cuns> arry){
		this.inflater=inf;
		this.array=arry;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return array.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return array.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh;
		if(convertView==null){
			vh=new ViewHolder();
			convertView=inflater.inflate(R.layout.adapter_listview, null);//注意导包，别导系统包
			vh.tv1=(TextView) convertView.findViewById(R.id.textView1);
			vh.tv2=(TextView) convertView.findViewById(R.id.textView2);
			convertView.setTag(vh);
		}
		vh=(ViewHolder) convertView.getTag();
		vh.tv1.setText(array.get(position).getTitle());
		vh.tv2.setText(array.get(position).getTimes());		
		return convertView;
	}
	class ViewHolder{
		TextView tv1,tv2;
	}
}
