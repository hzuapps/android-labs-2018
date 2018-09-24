# 第三次实验
## 1.实验目标
1、掌握在Android应用中使用图片等资源的方法。
2、在界面上显示至少一张图片（按照自己的题目添加）；
3、提交res/drawable及图片使用的代码；
4、提交res/values, res/layout等其他代码；
5、将应用运行结果截图，放到实验报告中；
6、点击图片（或按钮）时，打开另一个Activity。
## 2.实验步骤
1、将三张轮播图bg1.jpg、bg2.jpg、bg3.jpg等图片资源以及各种icon放入drawable目录下。
2、将三张轮播图放入layout中，使用ImageView组件，并编写其layout_width、layout_height、layout_marginBottom等属性，使其全屏，再将三张图片都加入viewPager容器中，并启动一线程定时切换使其autoplay。
3、点击相机拍照按钮时，使用startActivityForResult方法打开另一个Activity以拍照。
## 3.实验结果
 ![image](https://raw.githubusercontent.com/w123rq/android-labs-2018/master/soft1614080902403/pic3_1.png)
 ![image](https://raw.githubusercontent.com/w123rq/android-labs-2018/master/soft1614080902403/pic3_2.png)
## 4.实验体会
  本次实验让我掌握了再Android应用中使用图片资源的方法和Activity之间跳转并传递信息的方法。本次实验通过编写一个全屏展示的轮播图，让我熟悉了ViewPager、Button、ImageView等多个组件的使用，在实验过程中，为了让图片、按钮的尺寸和位置、样式符合要求，让我更加熟悉了XML布局文件的编写，以及values资源文件的使用。 