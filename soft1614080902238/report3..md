# 实验三
## 实验目标
 
*掌握在Android应用中使用图片等资源的方法。

## 实验要求
*在界面上显示至少一张图片（按照自己的题目添加）；
  
*提交res/drawable及图片使用的代码；
  
*提交res/values, res/layout等其他代码；
  
*将应用运行结果截图，放到实验报告中；
  
*点击图片（或按钮）时，打开另一个Activity。
## 实验步骤
*`首先创建一个项目，并将要在界面中显示的图片放在res/drawable文件夹下面。`

*`在app/src/main/java/edu.hzuapps.androids目录下新建一个Activity。`

*`编写两个Activity的.java文件以及相应的布局文件xml代码。`

*调试运行程序。

*提交res/drawable以及两个Activity的.java文件以及xml布局文件等文件到github 仓库中，并编写实验报告。

*res/drawable以及两个Activity的.java文件以及xml布局文件等文件到github 仓库中：https://github.com/mvp-szf/android-labs-2018
  
      $ git pull origin master
      
      $ git add soft1614080902238(git rm 学号目录/*)
      
      $ git commit "#3 # 963 第3次实验"
      
      $ git push

*在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）

## 实验结果
![](https://github.com/hzuapps/android-labs-2018/blob/master/soft1614080902238/Soft614080902238b/shiyan3jietu1.jpg?raw=true)
![](https://github.com/hzuapps/android-labs-2018/blob/master/soft1614080902238/Soft614080902238b/shiyan3jietu2.jpg?raw=true)      
## 实验体会
 通过这次实验，可以了解在Android应用中使用图片等资源的方法，在实验的过程中，因为一开始使用的图片命名上不符合java命名格式，
 导致运行的时候出现了错误。`这次实验首先需要创建新的Activity,并通过Intent方法来实现Acticvity的跳转。在实验中，我在第一个
 Activity中使用编写了按钮，并添加事件监听，在事件处理的方法中调用itent方法来实现跳转。`成功达到目标，但因为在第二个Activity
 的。java文件中，绑定xml布局文件时，不小心绑定了两次不同的内容，导致第二个Activity中显示的图片和自己预想的不一样。
