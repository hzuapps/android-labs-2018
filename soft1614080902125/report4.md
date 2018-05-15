# 第四次实验

Android界面设计编程

## 1.实验目标

1.根据选题要求设计界面布局及控件使用；

2.布局xml及界面控制操作代码提交并截图；

3.将应用运行结果截图。

## 2.实验内容

1.使用一种布局方式，设计所选题目的界面：

2.通过控件ID获取界面对象，执行相关操作：

3.实现界面控件的事件处理，例如点击按钮：

## 3.实验步骤

1.应用的主页面为activity_soft1614080902117.xml，我采用ConstraintLayout实现它的布局，其中该页面布局我分为导航栏和标题栏两部分。
导航栏我使用TabLayout+ViewPager+Fragment实现，这两个Fragment分别是本地列表和自定义列表，在本地列表这个Fragment即main_locallist.xml中，我拟定使用RecyclerView实现，至于自定义列表暂时还没有具体构想。
标题栏使用RelativeLayout实现，并为上面的两个Imageview添加监听事件分别跳转到搜索页面和扫描页面

2.activity_add_music.xml和activity_seek_music.xml我同样也是使用ConstraintLayout实现布局，标题栏我也都使用RelativeLayout实现，
并为上面的返回按钮添加监听事件。同时我还在activity_seek_music.xml添加了一个EditText用于获取输入的搜索信息，并将搜索结果以列表形式显示在一个RecyclerView中。

3、使用Git将代码提交到自己的库中：https://github.com/linkzw/android-labs-2018

4、在自己的GitHub库上创建和发送Pull Request（注意查看Changed files），查看自己是否有上传文件到库里面

5、在GitHub中使用Markdown文件编写实验报告（report3.md, report4.md）然后保存在自己的文件夹下

## 4.实验结果

![image](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p3.png)

![image](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p4.png)

![image](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p5.png)

![image](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p6.png)

## 4.实验体会
    根据课题需求对app主要的几个界面进行初步设计，
    目前只对搜索和本地扫描、返回按钮及导航栏添加监听和事件处理，
    点击相应按钮进入相应的页面，但音乐列表生成和通知栏以及音乐播放等功能还待实现。
    
    通过这次实验，算是对android的空间有了进一步的了解，知道了一些常见布局如何编写。但实现过程中出现了点问题，
    Imageview的图片显示不出来，但控件确实存在，在无法解决这个问题后，我只能换一张图片，成功显示。
