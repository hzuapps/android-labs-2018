# 实验六：Android网络编程
  
## 实验目标
掌握Android网络访问方法
理解XML和JSON表示数据的方法
 
## 实验内容（选做一）
在个人目录中创建一个表示数据的XML或JSON文件
数据文件代码提交之后从GitHub获取文件URL
在应用中通过网络编程访问GitHub的数据文件
在应用中解析并显示文件所包含的数据
将应用运行结果截图

## 实验内容（选做二）
从网络下载一个文件（图片、MP3、MP4）
保存到手机，在应用中使用文件
将应用运行结果截图

## 实验提示
可以尝试访问目前已有的一个 JSON 文件：
https://api.github.com/repos/hzuapps/android-labs-2018/pulls
注意复习和参考前几次实验的步骤与要求：
实验一：#1
实验二：#2
实验三：#3
实验四：#4

## 实验结果
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE1.png
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE2.png
https://github.com/MrZengXianSheng/android-labs-2018/blob/master/soft1614080902131/%E5%AE%9E%E9%AA%8C%E5%85%AD%E6%88%AA%E5%9B%BE3.png

## 实验体会
  此次实验我做的是选做二，从网络下载一张图片并让它可作为app页面的背景。我用的是安卓Glide图片加载框架，此框架能利用url方便地从本地和网络将图片加载到ImageView中，不需要利用繁杂的输入流，当然，输入流作为底层实现原理，我们还是去了解的。
  实验中我将相对布局改为帧布局，因为要用到ImageView，我将ImageView放到最底层、充满父布局，作为页面背景。
