# 第四次实验

 ## 1.实验目标
 ### 1.根据选题要求设计界面布局及控件使用；
 ### 2.布局xml及界面控制操作代码提交并截图；
 ### 3.将应用运行结果截图。（不要做登录注册！）
 ## 2.实验步骤 
 ### 1.添加需要的图片到drawable；
 ### 2.主activity中使用Linearlayout，按顺序添加了添加和查询图片及文字；
 ### 3.新建两个activity分别命名为add和search；
 ### 4.add和search中也使用Linearlayout进行布局，其中add中使用了嵌套布局，通过设置weight实现屏幕的一比一布局：
 ### 5.在主activity中，对两个ImageView控件分别获取id；
 ### 6.设置点击事件，分别跳转到对应的activity。
 ## 3.实验结果
 ![image](https://github.com/zhaokangye/android-labs-2018/blob/master/soft1613071002201/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE/01.png?raw=true) 
 ![image](https://github.com/zhaokangye/android-labs-2018/blob/master/soft1613071002201/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE/02.png?raw=true) 
 ![image](https://github.com/zhaokangye/android-labs-2018/blob/master/soft1613071002201/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE/03.png?raw=true) 
 ## 4.实验体会
 ### 此次实验主要使用LinearLayout进行界面的布局，将APP的外观框架初步搭建了起来。在xml里设置布局，特别是嵌套布局的时候，遇到了一点点麻烦，漏了一些代码因此耗了不少的时间才能布局完成。而在点击事件里，将ID转换为BUTTON的时候出现了一点问题，查阅资料之后仍未解决，而转换为ImageView时则能正常运行，因此对此还有些疑惑，希望能在接下来的实验里能解决这个问题。
  

