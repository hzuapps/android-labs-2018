
!# 第三次实验  
## 1.实验目的  
掌握在Android应用中使用图片等资源的方法  
## 2.实验步骤  

1、打开实验2时的工程项目 

2、在edu\hzuapps\androidlabs\soft1614080902434下新建Activity,命名为Second_Activity  

3、将图片wc.png粘贴至res/drawable目录下 

4、在second_activity.xml中添加控件ImageView,其代码为

<ImageView   

    android:layout_width="match_parent"  
    android:layout_height="match_parent"
    android:src="@drawable/wc"/> 
    
5、在soft_1614080902434_activity.xml中添加Button控件  
6、在soft1614080902419Activity类中添加Button


b，并监听，其代码如下： 

@Override  

public void onClick(View view) {  

    if(view==b){
        Intent intent = new Intent();
        intent.setClass(Wechat.this,Second_Activity.class);
        startActivity(intent);
    }
}：  

8、编译运行  

9、打开git bash，将文件夹push上github，向老师提交pull request.  

## 3.实验结果:  
![Image text](https://github.com/Min4396/android-labs-2018/blob/master/soft1614080902434/3.1.png)
![Image text](https://github.com/Min4396/android-labs-2018/blob/master/soft1614080902434/3.0.png)

## 4.实验体会：  
 学会了怎么新建Activity、如何添加图片、怎么切换Activity。，刚开始做的时候，因为我的电脑运行不了虚拟机，因为BIOS设置不了，所以我只能用实体机运行，而我的实体机型号是范围是1980*1080，而Android studio没有这个范围，所以就选了另一个范围，这就导致了布局有点尴尬。这次实验，算是初步了解怎么安装按钮和监听了。
