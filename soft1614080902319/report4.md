# 第四次实验

## 1.实验目标
根据选题要求设计界面布局及控件使用；
布局xml及界面控制操作代码提交并截图；
将应用运行结果截图。

## 2.实验步骤 
（1）、在res.layout中的activity_2中用design拖入Layouts的LinearLayout在界面中间；    
（2）、在LinearLayout中添加四个按钮，并将他们的text内容改成词汇测试选项内容，由于text内容中所有字母默认  
 全显示大写，故在values.styles中加入代码 <item name="android:textAllCaps">false</item>；  
（3）、以TextView的形式加入要测试的单词，         
android:gravity="center_horizontal"  文字居中显示    
    android:text="agreement"            设置文本框内容  
           android:textColor="#ff5e8e"         设置文本颜色，为红色  
            android:textSize="33dp"；            设置文字大小  
（4）、设置一个按钮next放在下面，界面基本形成；  
## 3.实验结果

![image](https://github.com/xiaojiahao/android-labs-2018/blob/master/soft1614080902319/sy4.png)

## 4.实验体会

    这次实验使我学会了很多新的操作，通过这次实验我对这个app的实现更加有想法了，刚开始只是在design中把按钮拖到想  
    要的位置，结果在虚拟机app运行后按钮全都跑到左上角了，后来就在按钮上四条线拉到四边才固定住了。
    
