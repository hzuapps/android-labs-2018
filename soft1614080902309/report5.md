  ## 第五次实验
 
## 1.实验目标
   （1）掌握在Android App中存储数据。
## 2.实验步骤
   （1）item添加监听，获取item的内容，将其保存为字符串msg
   （2）通过openFileOutput("message.txt",MODE_PRIVATE);
   （3）创建一个FileOutStream的对象fos，第一个参数是文件名，第二个参数是文件打开方式
   （4）将msg.getBytesz转换成字节型数据，fos.write()将其写入文件中，读取文件时，创建Stringbuilder对象，逐一接收openFileInput对象文件的内容
   （5）返回其内容字符串类型 将输入的文字点击“存储”按钮进行存储，然后通过之后点击“查看”按钮进行内存的读取和查看
   （6）git提交  git 提交操作步骤：1.git add   2.git commit -m ""    3.git push 
## 3.实验结果
![Android studio安装截图](https://github.com/Caixz/android-labs-2018/blob/master/soft1614080902309/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C2.png);
![Android studio安装截图](https://github.com/Caixz/android-labs-2018/blob/master/soft1614080902309/%E7%AC%AC%E4%BA%94%E6%AC%A1%E5%AE%9E%E9%AA%8C1.png);
## 4.实验体会
 做完本次实验，我学会了Android的文件存储，一开始做的时候有些无从下手，之后再同学和查看网上的一些知识后，懂了一些语句的用法，然后再对有语法错误的地方进行更改，总的来说收获满满，
 对android开发有了进一步的认识和了解
