# 第三次实验 
掌握在Android应用中使用图片等资源的方法。 

## 1. 实验目标 
### 1.在界面上显示至少一张图片（按照自己的题目添加）； 
### 2.提交res/drawable及图片使用的代码； 
### 3.提交res/values, res/layout等其他代码； 
### 4.将应用运行结果截图，放到实验报告中； 
### 5.点击图片（或按钮）时，打开另一个Activity。 

## 2. 实验步骤 
### 1.下载图片文件并存放至工程目录中
### 2.打开Android Studio
在`activity_com1606081301137.xml`定义`TextView`
```Java
<TextView
    android:id="@+id/csicon"
    android:textAppearance="?android:attr/textAppearanceLarge"
    android:layout_width="wrap_content"
    android:layout_height="90dp"
    android:drawableBottom="@drawable/csicon"
    android:gravity="center"/>
```
在`TimeView.java`中调用`csicon`：
```Java
csicon = (TextView) findViewById(R.id.csicon);
csicon.setText(" ");
private TextView csicon;
```
### 3.运行模拟器，显示结果

## 3. 实验结果  
### 1.app运行看见第一个Activity:  
 ![](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E301.png)
### 2.点击按钮切换到不同的Activity：  
![](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E302.png)
![](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E303.png)
![](https://raw.githubusercontent.com/ChaShu618/android-labs-2018/master/com1606081301137/AndroidProject/Project01/E304.png)

## 4. 实验体会  
通过这一次实验，我学会了如何添加按钮和图片，以及如何打开其他的Activity。由于新增了内容，程序的编译运行过程略微缓慢，这也与机器的硬件性能有关。
