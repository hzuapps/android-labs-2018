# 实验目标
### 掌握在Android App中存储数据
# 实验内容（二选一）
## 一、根据选题要求使用文件存储
#### 1.将应用产生的数据保存到文件存储中；
#### 2.说明使用的文件存储方式：内部 or 外部；
#### 3.将运行结果截图。
## 二、应用数据存储可采用数据库存储
#### 1.将应用产生的数据存储到数据库中；
#### 2.使用UML类图描述表结构；
#### 3.将应用运行结果截图。

# 实验步骤
### 1.打开项目soft1606081301233；
### 2.在activity_second.ml文件中添加btnSave按钮的onClick()方法；
``` 
android:onClick="save"
```
### 3.在SecondActivity.java中实现save()方法，采用文件内部存储的方法：
```
 public void save(View view){
       String content1=etContent1.getText().toString();
       String content2=etContent2.getText().toString();
       String content3=etContent3.getText().toString();
       //定义3个EditText的字节流
       FileOutputStream fos1=null;
       FileOutputStream fos2=null;
       FileOutputStream fos3=null;
       //定义字符流
       BufferedWriter writer1=null;
       BufferedWriter writer2=null;
       BufferedWriter writer3=null;
       ...
```
### 4.运行并截图
### 5.用git push提交更改的文件
# 实验结果
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/lab5_1.png)

![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/lab5_2.png)
# 实验体会
### 1.本次实验是实现对项目产生的文件的存储，我用的是简单的文件内部存储，用到了FileOutputStream文件字节输出流和字符流BufferedWriter；
### 2.最开始真的是无从下手，因为之前的java真的学得很一般，所以这次为了实现文件存储，翻查了不少资料，最后勉强完成本次实验的最基本要求；
### 3.通过本次实验对文件内部存储有了一些了解，但远远不足，后面会继续学习。
