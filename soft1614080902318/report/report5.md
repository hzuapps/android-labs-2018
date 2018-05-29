# 第五次实验

## 一、实验目的
掌握在Android App中存储数据<br>

## 二、实验内容
1.将游戏产生的数据保存到文件存储中；<br>
2.文件存储方式：内部；<br>
3.通过点击按钮实现界面控件的事件处理<br>

## 三、实验步骤
1.编写存储数据的方法save，其中打开文件流的方法openFileOutput(String name , int mode),第一个参数设置文件名为result，第二个参数使用追加模式MODE_APPEND<br>
2.在按钮监听中实现数据保存，获取两个单选框和输出文本的值，调用save方法进行保存<br>
3.运行程序，在View->Tool Windows->Device File Explorer中的data/data/包名/files/result查看存储的数据<br>
4.截图，提交实验<br>

## 四、实验截图
![image](https://github.com/linwt/android-labs-2018/blob/master/soft1614080902318/result.png)<br>

## 五、实验体会
本次实验相对简单，总结为三点：一是要学会获取文本、单选框等需要存储的数据，二是要会运用文件流进行写操作，三是要知道文件存储的具体路径在哪里。






