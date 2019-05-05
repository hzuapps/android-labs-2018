# 第五次实验 

## 1.实验目标
掌握在Android App中存储数据
###实验内容
根据选题要求使用文件存储  
将应用产生的数据保存到文件存储中；  
说明使用的文件存储方式：内部 or 外部；  
将运行结果截图。
## 2. 实验步骤
1、使用的储存方式是内部储存。   
在activity_zuozhe.xml中加入一个button，名为保存。

    <Button
        android:id="@+id/tv_11"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/tv_10"
        android:text="保存"
        android:textSize="25sp"
        />
2、在zuozheActivity中加入以下代码：

    private Button tv_11;       声明button
    private EditText tv_2;      声明姓名edittext
    
        tv_11 = (Button)findViewById(R.id.tv_11);           找到button
        tv_2 = (EditText)findViewById(R.id.tv_2);           找到姓名edittext
        tv_11.setOnClickListener(new Suibian());            监听button
        
    
    private class Suibian implements View.OnClickListener{  实现保存数据到data.txt中
        @Override
        public void onClick(View v) {
            EditText tv_3 = (EditText)findViewById(R.id.tv_3);  声明并找到性别edittext
            String content;
            String filename = "data.txt";
            content = "name:"+tv_2.getText().toString()+"gender:"+tv_3.getText().toString();
            FileOutputStream fos;
            try{
                fos = openFileOutput(filename,MODE_PRIVATE);
                fos.write(content.getBytes());
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
## 3. 实验结果

![在Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/%235.1.png)

![在Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/%235.2.png)


## 4. 实验体会
Android studio 3.1版本删除了DDMS，导致要找到data.txt非常困难，百度了许久之后选择先完成实验6再搞实验5，最后是通过cmd去查找到的结果
希望老师以后教学的时候建议安装3.0版本以下的Android studio，或者教一下他们怎么找到app生成的文件。  
**加粗**常规
