# 第六次实验

## 实验目标

1.掌握Android网络访问方法

2.理解XML和JSON表示数据的方法

## 实验步骤

1.在AndroidManifest.xml文件的application下添加权限
 
2.在原有的 activity_add_music.xml 添加一个 Button 来控制下载，添加一个 EditText 用于输入图片地址，添加一个 Imageview 用于显示下载的图片

3.在 add_music.java 中初始化组件，new一个Handler用于在子线程中更新UI，给下载图片的 button02 添加监听器，写一个子线程来下载图片资源

4.将运行结果截图，使用Git将代码提交到自己的库里

## 实验内容

1.
![截图1](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p9.png)

2.
![截图2](https://github.com/linkzw/android-labs-2018/blob/master/soft1614080902125/p8.png)

## 实验体会

这次实验刚开始真的毫无头绪，甚至连个大体的思路都没有，还好在同学的帮助下对这次实验有了个清晰的认识，
一开始本来是想从网上下载存放歌曲信息的list文件来创建listview，但文件的写入一直有问题，也没有解决的头绪，
只能放弃改做图片显示，还好图片显示并没有遇到太大的问题，还对前面遇到的问题有了点思路。
