# 第五次实验
## 1.实验目标
掌握在Android App中存储数据

## 2.实验步骤
### 1.根据选题要求使用文件存储
### 2.将应用产生的数据保存到文件存储中；
### 3.说明使用的文件存储方式：内部 or 外部；
### 4.将运行结果截图。
##3.实验步骤
### 1.Context提供了两个方法来打开数据文件里的文件IO流 FileInputStream openFileInput(String name);FileOutputStream(String name , int mode),
这两个方法第一个参数 用于指定文件名，第二个参数指定打开文件的模式,这里我使用的是MODE_APPEND.指定文件名为demo.
### 2.获取edittext和spinner的值.
### 3.创建存储文件的函数save,这里我使用的是内部存储
### 4.调用save函数，传递edittext和spinner的值.
###5.使用Git将代码提交到自己的库中：https://github.com/PickForSth/android-labs-2018

   $ git pull origin master<br>
   $ git add com1613090502214<br>
   $ git commit "#5 #1370第5次实验"<br>
   $ git push<br>
## 4.实验结果
![在Android SDK Manager中配置教育网下载代理](android-labs-2018/soft1614080902129/chuan.png "配置教育网下载代理")

## 5.实验体会
通过这次实验使我更加熟悉git和android studio,获取edittext和spinner控件的值，将值内部存储到文件，创建事件监听器对button控件进行处理，处理事件要心细，不能够太过于心急。
