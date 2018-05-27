# 第四次实验报告

## 一.实验目的
### 1.根据选题要求设计界面布局及控件使用；
### 2.布局xml及界面控制操作代码提交并截图；
### 3.将应用运行结果截图。（不要做登录注册！）。

## 二.实验步骤
本实验做的是短信管理器（主界面为Activity），主要实现新建短信（Activity2）和搜索（Activity3）两个功能。

### 1. 首先打开先前做好的android工程，进入到Activity的design控件布局页面

### 2. 实验3实现的打开Activity2作为新建短信功能的实现，同样的，要弄一个打开Activity3以实现搜索功能
在Activity的design界面中拖入一个id为button的按钮（搜索）和一个输入文本框（请输入搜索关键词）并设好位置

### 3. 在Activity对应的java文件中加入对此按钮的监听以及事件，如下代码
   ~~~
   Button button2 = (Button)findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902314Activity.this,soft1614080902314Activity3.class);
                startActivity(intent);
   ~~~

### 4. 在Activity3的design界面拖入一个listview控件作为搜索的输出

### 5. 健全新建短信功能的界面
打开Activity2的design界面，拖入两个输入文本框（输入收件人，输入短信内容）作为短信的基本内容，由于能力不足，加入的两个按钮（通讯录，发送）仅作修饰作用
   
### 6. 在每个Activity控件布局界面加入约束布局条件

## 三.实验结果
![在Android SDK Manager中选择6.0库](https://github.com/Zhengmianjie/android-labs-2018/blob/master/soft1614080902314/4%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE.jpg?raw=true"配置教育网下载代理")

## 四.实验体会    
通过本次实验，了解到了如何在android控件布局界面加入各类控件，同时也明白布局结束后要将约束布局条件设置好，否则运行时控件的布局是乱的。
