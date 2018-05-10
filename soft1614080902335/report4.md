# 第四次实验 
Android界面设计编程。
## 1. 实验目标
1.    根据选题要求设计界面布局及控件使用；  
2.    布局xml及界面控制操作代码提交并截图；  
3.    将应用运行结果截图。  
## 2. 实验步骤

1    打开Android Studio进行编程；
2    对于需填写内容的框则用EditText,图案按钮则用button里面的background或者用ImageView；  
3    对于登录界面进行布局与控件设计，根据现在QQ运行界面进行设计，由于控件都是依次排列，所以采用LearnList布局。采用android:layout_weight="1"来使控件进行并列；  
4    对于聊天消息界面采用了头部、搜索栏、中部、底部分布设计，这是由于以后进行app拓展功能时，使其耦合度减低，也让重复代码减少；  
5    对于聊天界面，由于与后面所需要学的网络通讯有关，所以简单自定义一个大概效果，之后要在ListView中实现多item界面设计。  
6    代码实现后，通过git将app目录结构且有编码、有添加的文件先储存在自己clone下来的目录下，后上传到GitHub。  
git指令代码如下：  
    git add res/*  
    git add drawable/*  
    git add layout/*  
    git commit -m "#3 #994 QQ the 4th lab"  
    git push  

7    继续上传report4.md文件，写实验报告
## 3. 实验结果
1    登录界面：  
  
![Image text](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE1.png)  
  
![Image text](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE4.png)  
  
2    聊天消息界面：  
  
![Image text](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE2.png)  
  
![Image text](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE5.png)  
  
3    聊天界面：
  
![Image text](https://raw.githubusercontent.com/ChenchenJT/android-labs-2018/master/soft1614080902335/%E5%AE%9E%E9%AA%8C%E5%9B%9B%E6%88%AA%E5%9B%BE3.png)  
  
## 4.实验体会
1    在对LearnList布局方式，需要并列时，可以添加android:layout_weight="1"来实现；  
2    在对重复使用的布局时，可以采用导入的方式实现，这样既减少了代码量，还可以减低耦合度；  
3    在对于需填写内容的框则用EditText，其中inputtype可以选择输入类型,图案按钮则用button里面的background或者用ImageView；  
