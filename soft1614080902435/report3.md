# 第三次实验
## 1.实验目的
掌握在Android应用中使用图片等资源的方法
## 2.实验步骤
1、把自己手机的计算器界面截图并上传到电脑上，重命名为beijing.png，然后复制粘贴到res/drawable里

2、在edu.hzuapps.androidlabs.Soft1614080902435下新建一个空Activity，并命名为jiemianerActivity，同时Layout activity命名为activity_jiemianer.xml

3、此处没有使用TextView，而使用了ImageView控件

4、添加按钮，并监听

5、编译运行

6、使用git bash将更新的文件和文件夹push到GitHub上，提交。

## 3.实验结果
1、activity_soft1614080902435.xml
![image](https://raw.githubusercontent.com/AisakaTaika/android-labs-2018/master/soft1614080902435/3.1.png)
2、activity_jiemianer.xml
![image](https://raw.githubusercontent.com/AisakaTaika/android-labs-2018/master/soft1614080902435/3.2.png)
## 4.实验体会
　此次实验我学会了怎么在AS中创建Activity，并用IamgeView控件显示图片，然后点击图片（或按钮）时，打开另一个Activity。当东找西找资料之后把代码写完，然后调试的时候发现一打开APP就闪退，但是代码并没有提示错误（可能是提示了自己不知道错在哪），然后纠结了半天。最后发现是调用的时候把xml文件的名字弄错了，最后就可以正常调试了。
 调试的时候发现按钮的位置老是调不到中间，上网查了之后我改用了绝对布局，然后就可以拉动按钮到哪他就在哪了。
