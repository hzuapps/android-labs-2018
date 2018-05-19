实验五
=
一、实验目的
-
掌握在Android App中存储数据
  
二、实验内容
-
根据选题要求使用文件存储

将应用产生的数据保存到文件存储中；<br>
说明使用的文件存储方式：内部 or 外部；<br>
将运行结果截图。<br>
三、实验步骤
-
Item添加监听，获取Item内容，将其保存为字符串msg<br>
通过 openFileOutput("record.txt",MODE_PRIVATE);创建一个FileOutStream的对象fos，第一个参数是文件名，第二个参数是文件打开方式<br>
将msg.getBytesz转换成字节型数据,fos.write()将其写入文件中<br>
读取文件时，创建Stringbuilder对象，逐一接收openFileInput对象中文件的内容，返回其内容字符串类型 <br>
四、实验截图
-
![](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/r51.png)<br>
![](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/r52.png)<br>
![](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/r53.png)<br>
![](https://github.com/zglx/android-labs-2018/blob/master/soft1614080902231/r54.png)<br>
五、实验体会
-
学会了Android的文件存储，由于先前学过Java输入输出流，所以感觉并不怎么困难
