# 第4次实验
 
## 1.实验目标
* 实现ListView显示密码Item
* 加入新增按钮
 
## 2.实验步骤
### 1. 设置ListView，获取ListView,通过适配器进行对象循环使用，通过监听每一个Item的获取对应的position，为数据存储做基础

* 设置ListView
``` xml
<ListView
	android:id="@+id/pass_list"
	android:layout_width="match_parent"
	android:layout_height="match_parent"/>
```

* 获取ListView
``` java
ListView LvPassList = findViewById(R.id.pass_list);
```

* 适配器设置
``` java
private class passAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 50; //返回50个Item作为测试
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
        TextView tvMsg;
        if(convertView == null){ //判断缓存是否为空
            tvMsg = new TextView(soft1614080902329RecordActivity.this);
        }else {
            tvMsg = (TextView) convertView;
        }
        tvMsg.setText((position + 1) + "  QQ密码");
        tvMsg.setTextSize(32);
        tvMsg.setPadding(50,50,0,50);
        return tvMsg;
    }
}
```

* 为ListView设置适配器
``` java
LvPassList.setAdapter(new passAdapter());
```


* 为ListView的Item设置监听
``` java
LvPassList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    Toast.makeText(soft1614080902329RecordActivity.this,position + "ok",Toast.LENGTH_SHORT).show();
	}
	});
```


### 2. 添加按钮，实现监听，用土司检测功能完整性，为数据存储做准备

* 添加按钮
``` xml
<Button
    android:id="@+id/new_pass"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_alignParentBottom="true"
    android:textColor="#4edc50"
    android:background="#303f9f"
    android:text="+"
    android:textSize="38dp" />
```

* 获取Button
``` java
Button newPass = findViewById(R.id.new_pass);
```

* 为Button设置监听
``` java
newPass.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View v) {
	    Toast.makeText(soft1614080902329RecordActivity.this,"newPass",Toast.LENGTH_SHORT).show();
	//                Intent intent = new Intent();
	//                intent.setClass(soft1614080902329RecordActivity.this, soft1614080902329RecordActivity.class);
	//                soft1614080902329RecordActivity.this.startActivity(intent);
	}
	});
```

 
## 3.实验结果
* 实验截图
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab4.png)

## 4.实验体会 
* 通过不断的百度搜索，百度搜索，学到了许多的知识，了解了Android的许多知识，学会了使用listview的皮毛，
和button的皮毛。
* 其中ListView的适配器中，通过缓存判断一个界面是否有空闲Item，通过这个机制可以实现Item的复用，减少了内存的使用和实现了大量Item浏览的可能
* 使用setOnItemClickListener为每个ListView的Item设置监听，通过onItemClick的参数可以获得许多有用信息，如position，可为以后数据存储作为ID使用。
* 百度是万能的，一个百度不行，那就再来一个谷歌
