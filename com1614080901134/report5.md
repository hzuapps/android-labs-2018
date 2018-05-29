# 第五次实验

 ## 一、实验目的
 掌握在Android App中存储数据
 
 ## 二、实验内容
将应用产生的数据保存到文件存储中；<br>
说明使用的文件存储方式：内部 or 外部；<br>
将运行结果截图。
 
 ## 三、实验步骤
1、首先用git工具将代码仓库复制到本地后进行修改。

2、然后打开com16140809011342Activity.java，在这个文件下面增加了一个事件，让当点击确认下单这个操作时，将应用上的
数据生成保存在data.xml文件中，这次保存数据是使用SharedPreferences存储，所以在.java文件上加了这写代码
button9.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("低级蛋糕数量",textView.getText().toString());
        editor.putString("中级蛋糕数量",textView3.getText().toString());
        editor.putString("小蛋糕数量",textView4.getText().toString());
        editor.apply();

    }
});

3.实验运行成功后将文件git push 上传到本地仓库

 
 ## 四、实验截图
 *生成文件放目录<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/5.png)<br>
 *存储文件<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/6.png)<br>
  *打开文件内容<br>
 ![image](https://github.com/chenjiahui-xxz/android-labs-2018/blob/master/com1614080901134/datawenjian.png)<br>

 
 ## 五、实验体会
       在这次实验使用了SharedPreferences存储，在了解到安卓有多种存储方式上，我发现SharedPreferences存储是不同于文件的存储方式，
	它是使用键值对的方式来存储数据的。也就是说，当保存一条数据的时候，需要给这条数据提供一个对应的键，这样在读数据我们就可以通过这
	个键方便度数据。所以因为这种键值存与读的方式，感觉比使用文件方便了很多。在写这个存储方式的时候代码的实现也不难，所以觉得这个是
	最容易掌握的存储方式。
