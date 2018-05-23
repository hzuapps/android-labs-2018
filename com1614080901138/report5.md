## 第五次实验

## 一、实验目的
掌握在Android App中存储数据

## 二、实验内容
将应用产生的数据保存到文件存储中；<br>
说明使用的文件存储方式：内部 or 外部；<br>
将运行结果截图。

## 三、实验步骤
1、首先用git工具将代码仓库复制到本地后进行修改。<br>
2、然后打开com1614080901138Activity.java，在这个文件下面增加了一个事件，让当点击确认下单这个操作时，将应用上的<br>
数据生成保存在data.xml文件中，这次保存数据是使用SharedPreferences存储，所以在.java文件上加了这写代码<br>
button9.setOnClickListener(new View.OnClickListener() {<br>
    @Override<br>
    public void onClick(View view) {<br>
        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();<br>
        editor.putString("第一条信息",textView.getText().toString());<br>
        editor.putString("第二条信息",textView1.getText().toString());<br>
        editor.apply();<br>
        editor.apply();}<br>
        );<br>

3.用git上传之前注意用git pull

 
 ## 四、实验截图
 *截图1<br>
 ![image](https://github.com/JuneLee1212/android-labs-2018/blob/master/com1614080901138/app/src/main/res/drawable-v24/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE1.png)<br>
 *截图2<br>
 ![image](https://github.com/JuneLee1212/android-labs-2018/blob/master/com1614080901138/app/src/main/res/drawable-v24/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE2.png)<br>
 ## 五、实验体会
     这次实验用了SharedPreferences存储，从网上的资料我发现SharedPreferences存储是不同于文件的存储方式，SharedPreferences本
     身是一个接口，它是使用键值对的方式来存储数据的。因为这种键值存与读的方式，在写这个存储方式的时候代码的实现也不难，所以我觉
     得这个是相对较容易掌握的存储方式。
