# 第四次实验报告
## 实验目标
### 1、根据选题要求设计界面布局及控件使用；
### 2、布局xml及界面控制操作代码提交并截图；
### 3、将应用运行结果截图。（不要做登录注册！）
## 实验步骤
### 1、启动Android studio并打开项目Soft1613090502218
### 2、由于第3次实验只是试做因此现在drawable中的图片要改变，原来的图片保留
### 3、创建一个新的选择难度activity，并在原来的activity当中添加点击按钮事件跳转到新activity
### 4、布局全部用LinearLayout，并且原来的activity中LinearLayout的宽为410sp,高为610sp，垂直居中
### 5、选择难度的activity则是由一个大的LinearLayout包含由两个小的LinearLayout，大的大小与上面一样，而小的则平均分成两半并且垂直分布
### 6、由于按钮中的文本直接android:text="开始游戏"会由警告，因此就在strings.xml中添加了
### 7、然后就用git rm删除原来不用的和要替换的，再用git add添加会需要的
## 实验结果
### ![image](https://github.com/ChenYHeng/android-labs-2018/blob/master/Soft1613090502218/r41.png)
### ![image](https://github.com/ChenYHeng/android-labs-2018/blob/master/Soft1613090502218/r42.png)
## 实验体会
### 这次实验解决点击事件时就比较顺畅，但是在修改图片和按钮的位置就比较麻烦，再加上运行时电脑会很慢，并且还出现运行时nexus 5x was killed的问题，导致时间就越用越多，不过虚拟机的问题只要删了重装就可以继续用