# 第五次实验 

## 1. 实验目标
掌握在Android App中存储数据

## 2. 实验要求

根据选题要求使用文件存储

1.  将应用产生的数据保存到logs文件存储中，自定义文件名为logs；<br>
2.  使用的文件存储方式为内部；<br>
3.  将运行结果截图。<br>

## 3. 实验步骤
1.  在`res/layout`下编写`activity_cityinfo.xml`文件，新增`tv编辑框`和`btn_search搜索按钮`，接着实现相应的监听接口，实现界面控件的事件处理。
2.  在`CityInfoActivity.java`的类中编写代码获取`tv编辑框`所输入的文本，并调用自定义的`save`方法将其保存至内部存储的文件`logs`中。
3.  注意：当前app路径应用在内存上的目录是`/data/data/包名/files`
3.  检查好预览效果，整理好界面的布局以及控件的位置。最好用虚拟机运行即可。
4.  使用Git将代码提交到自己的库中：
>$ git pull <br>
>$ git add 学号目录/* <br>
>$ git commit "#12345678 "<br>
>$ git push <br>
5.  编辑实验报告，然后将项目目录一并pull给老师;



## 4. 实验结果
我的截图1：<br><br>
![image](https://github.com/neptuneman/android-labs-2018/blob/master/soft1614080902334/lab5_screenshot_1.png "我的截图1")

我的截图2：<br><br>
![image](https://github.com/neptuneman/android-labs-2018/blob/master/soft1614080902334/lab5_screenshot_2.png "我的截图2")

我的截图3：<br><br>
![image](https://github.com/neptuneman/android-labs-2018/blob/master/soft1614080902334/lab5_screenshot_3.png "我的截图3")

## 5. 实验体会
1.  这次实验难度略有，所以我考虑了选择内部存储，以后有机会定要试试其他存储方式~
2.  发现了editText里面可以用hint属性设置失去焦点时的提示文本，挺方便的。
3.  本来想要在编辑框输入中文的，但由于虚拟机自带的是不行的，要的话需要另外下载个中文输入法。
4.  对IDE的运用有进步。期待下一节的内容。
