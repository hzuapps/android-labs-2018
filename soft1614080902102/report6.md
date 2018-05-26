# 第六次实验报告
 
## 一、实验目的：掌握Android网络访问方法。
 
## 二、实验内容：
1、在个人目录中创建一个表示数据的XML或JSON文件；

2、数据文件代码提交之后从GitHub获取文件URL；

3、在应用中通过网络编程访问GitHub的数据文件；

4、在应用中解析并显示文件所包含的数据；

5、将应用运行结果截图。
 
## 三、实验步骤：
1、用json在线编辑器，写好自己的json文件，然后保存下来；

2、通过 git上传json文件到自己的github库里；

3、然后打开已经建好的项目soft1614080902102，导入第三方的OK和gson的封装
（代码为implementation 'com.zhy:okhttputils:2.6.2'；implementation 'com.google.code.gson:gson:2.2.4'）

4、新建一个MyApplication,要继承它的Application类，重写它的onCreate方法，对OK进行初始化；

5、在Main3Activity中写URL，写解析的代码；
 
6、为了有上网权限，在AndroidManifest.xml添加对应代码获许权限；

7、运行程序并截图，使用git将代码提交到自己的库里，在自己的GitHub库上创建和发送Pull Request；
 
8、在GitHub中使用Markdown文件编写实验报告。
 
# 四、实验结果：
![image](https://github.com/1614080902102/android-labs-2018/blob/master/soft1614080902102/shiyan6.png?raw=true)
 
# 五、实验体会：

1、刚开始写json文件时，是新建文本文档然后改后缀名为json的结果上传到github上一直是乱码，传了3次，3次乱码，有点绝望，幸好后来百度了一下，用json在线编辑器保存来的就不会乱码了下来。

2、解析文件的代码不是很难，主要问题就是在自己有点想当然，导致在json文件上浪费了很多时间。

3、获取json文件的URL时，我是在整个网页源代码里找到的json文件的URL的，过程繁琐麻烦，不是很好找，但是目前没有找到更好获取URL的方法，所以只能如此，等下去请教一下别的同学，看看有没有更好的方法

4、谢谢老师的悉心教导，课下更要勤加练习了，加油！
