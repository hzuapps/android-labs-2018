# 第五次实验 

## 1. 实验目标  
掌握Android App中存储数据  
 
## 2. 实验步骤  
1、阅读实验要求：https：//github.com/hzuapps/android-labs-2018/labels/Lab  
2、分析自己App适合的数据存储方式，对于我的课表App，我采用的是文件存储的方法。       
3、在需要写入数据到文件中的Activity的xml文件中添加“写入数据”功能的按钮，就是说点击按钮之后就将写好的数据存储。           
4、在Activity中添加一个TextView用来检查读取数据是否成功（参数由读取函数带回）  
5、在Activity.java文件中书写代码，需要注意：  
①文件存储分为内部存储和外部存储，**我采用的是内部存储**  
②File类可以指向我们想要存储的文件位置，利用**getFilesDir()**方法可以获取内部存储的默认目录  
③**openFileOutput**方法可以直接打开输出流，向设备文件中存入数据，该方法包含2个参数（文件名、枚举类的写入类型）  
④本例之中我们采用的是FileReader与BufferedReader结合的方法进行读取数据。注意几个重要的函数：**File.getAbsoluteFile()**以及**BufferedReader.readLine()**  
⑤本次代码之中设计到很多可能异常，需要添加Try-catch语句。            
6（例行公事)使用Git将代码、截图、报告提交到自己的库中：https：//github.com/YOUR_NAME/android-labs-2018    
$ git pull  
$ git add 学号目录/*  
$ git commit "#12345678 "  
$ git push  
在自己的GitHub库中创建并发送Pull Requset（合并请求），注意是否只改变自己的文件夹。    
在GitHub中使用Markdown文件编写实验报告。


## 3. 实验结果  

![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验5截图/实验五1.png "配置教育网下载代理")    
![在Android SDK Manager中选择6.0库](https://raw.githubusercontent.com/DcXuhm/android-labs-2018/master/soft1614080902337/实验5截图/实验五2.png "配置教育网下载代理")  

  
 

## 4. 实验体会  

**老师辛苦了！**    
实验中有以下心得：      
1、Android studio中存储数据的方式有多种：SharedPreferences、数据库SQL、文件存储等等，需要我们结合实际情况去选择。目前为止，由于java数据流这一块学的一般般，所以也只能使用简单的文件存储了，还需要加强学习。      
2、关于文件存储，实验当中遇到了一些主要的问题，例如：**存到哪里去？**、**怎么存？** **怎么读取？**  
3、通过学习，对上述问题有了一些了解      
    首先，我们数据存到哪里，一般分为内部文件存储和外部存储（例如SD卡等），外部存储是App卸载后仍然会存在的，是大家公用的数据。本次实验的数据我们就存放内部。  
    那么我们如何获取路径呢？AS中提供了获取默认文件存储路径的方法：getFilesDir。获取了目录之后就可以作为参数建立File变量了。当然，我们也可以使用自己想要的路径作为参数新建File变量。  
    关于怎么存，或则说怎么写入，我们可以打开输入流，用**FileOutputStream fos = openFileOutput(filename,MODE_PRIVATE)**这样的语句实现，然后使用输入流的write方法即可。  
    写完之后怎么读呢？可以仍然采用输出流的方法，也可以参照实验参考中的FileReader和BufferedReader的方法来做。  