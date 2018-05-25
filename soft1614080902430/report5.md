# 实验五：Android存储编程

## 一、实验目标
掌握在Android App中存储数据 <br />

## 二、实验步骤
1、选择以文件存储存储数据信息<br />
2、应用外部存储空间，
File dir = new File(Environment.getExternalStoragePublicDirectory(type), dirName);<br />
3、应用FileOutputStream输出流写入字符串 String text = "content";<br />
4、返回文件目录，显示在TextView控件中

## 三、实验截图
![image](https://github.com/Zhuangyupeng/android-labs-2018/blob/master/soft1614080902430/%E5%AE%9E%E9%AA%8C%E4%BA%94%E6%88%AA%E5%9B%BE.jpg?raw=true)

## 四、实验体会
本次实验比较抽象比较难一点，花费了较多的时间，最后在老师给的示例代码中得到启发，因此代码比较相似。通过这次实验，习得了使用文件存储来数据，同时也复习了java的输入输出流
。
