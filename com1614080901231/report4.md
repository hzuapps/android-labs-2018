# 第四次实验报告
## 实验目标
1、根据选题要求设计界面布局及控件使用；
2、布局xml及界面控制操作代码提交并截图；
3、将应用运行结果截图。（不要做登录注册！）
## 实验步骤
1.使用其中一种布局方式，设计所选题目的界面：LinearLayout ；  
2. 页面有四个按钮，只写了界面，下次做相关的点击处理
3、启动Android studio并打开项目Com1614080901231
4、由于第3次实验只是试做因此现在drawable中的图片要改变，原来的图片保留
5.原来的界面我就不截图了，直接给出这一次写的界面
6、布局全部用LinearLayout，并且原来的activity中LinearLayout的宽高为铺满，方向垂直
7、然后设置给Button设置相应的标题和id
## 实验结果
![image](https://github.com/BACodeLab/android-labs-2018/blob/master/com1614080901231/3.png)
## 实验体会
第一次用LinearLayout，学会了他的方向属性，还学到他一个需要注意的地方就是，横向的话就只有垂直的属性可用，反之亦然
ps：
1、orientation的默认值为horizontal，即从左向右排列。由于一般从上向下排列，所以必须指定orientation属性。

2、layout_gravity与gravity的区别：

（1）gravity指定自身所包含的子元素的对齐方式，如LinearLayout中的gravity指定了它的子元素（即5个TextView）水平居中排名，第二个TextView指定了其子元素（内容）向左对齐。

（2）layout_gravity用于指定自身在父元素中的对齐方式，并可覆盖其父元素的gravity属性。如第一个TextView指定了其自身在父元素(LinearLayou）中向右对齐，并覆盖了LinearLayout中的layout_gravity属性。
