# 第三次实验   
掌握在Android应用中使用图片等资源的方法。  
## 1. 实验目标  
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**  

## 2. 实验步骤  

**sp：由于这次的实验要符合选题要求，上次的实验跟我的选题相差比较大，所以基本都删除了**

1. 这次主页面（好像都是）选用的是比较简单易懂的LinearLayout（线性布局）方向是垂直，里面就直接嵌套一个recycleView（由于ListView要考虑比较多的性能问题，还有诸多拓展性的问题，谷歌现在推荐使用recycleView）来展示壁纸列表，设置为两列。然后在每个item里设置点击事件，跳进图片详情看大图。目前没有进行网络连接，图片图片都是死的。（具体看代码）


 ## 3. 实验结果  
打开

 ![](https://github.com/zicong-chen/android-labs-2018/blob/master/com1614080901238/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/1.png)
 
 点击任意一项
 
![](https://github.com/zicong-chen/android-labs-2018/blob/master/com1614080901238/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE/2.png)


 ## 4. 实验体会  
总体还算顺利，学习了LinearLayout，recycleView，在adapter为每个holder设置点击事件等等。。。
