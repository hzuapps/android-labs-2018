第四次实验报告
实验目标

1、根据选题要求设计界面布局及控件使用；

2、布局xml及界面控制操作代码提交并截图；

3、将应用运行结果截图。（不要做登录注册！）

实验步骤

1、启动Android studio，打开项目

2、这是以前做过的项目，有登录界面，但这次提交的是主界面，包含三个碎片

3、第一个碎片是主页

4、第二个碎片是菜谱推荐

5、第三个碎片是“我”的详细

6、碎片一存放的布局主要是用ScrollView和LinearLayout嵌套完成的，包括GridView和一个图片切换框架

7、实验截图如下展示

实验结果



![image](https://github.com/henyiwu/android-labs-2018/blob/master/com1614080901234/main/res/drawable/16825217735265188.jpg?raw=true)

![image](https://github.com/henyiwu/android-labs-2018/blob/master/com1614080901234/main/res/drawable/433627875314971818.jpg?raw=true)

![image](https://github.com/henyiwu/android-labs-2018/blob/master/com1614080901234/main/res/drawable/898333339364222214.jpg?raw=true)

实验体会

主界面用ScrollView和LinearLayout嵌套写成，基本没什么问题，外面嵌套一个ScrollView使得如果手机屏幕分辨率比较低的话，布局不会被挡住而是可以通过上滑显示出来。菜谱展示界面使用的是RecyclerView，只要是子项的编写，子项的编写使用的是相对布局，控件依次排列在前一个控件的右边，采用sp定义长度，margin定义边距。实验截图如上所示。