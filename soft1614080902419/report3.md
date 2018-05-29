# 第三次实验
## 1.实验目的
掌握在Android应用中使用图片等资源的方法
## 2.实验步骤
1、打开实验2时的工程项目 

2、在edu\hzuapps\androidlabs\Soft1614080902419下新建Activity Second_Activity,并将其布局命名为second_activity  

3、将图片bg.png粘贴至res/drawable目录下  

4、在second_activity.xml中添加控件ImageView,其代码为  
<ImageView  

        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/bg"
        />
    
5、在soft_1614080902419_activity.xml中添加Button控件  

6、在Soft1614080902419Activity类中添加Button b，并监听，其代码如下：

b = (Button)findViewById(R.id.open_cal);  
b.setOnClickListener(this);

7、写监听函数，其代码如下： 

@Override  

    public void onClick(View view) {
        if(view==b){
            Intent intent = new Intent();
            intent.setClass(Soft1614080902419Activity.this,Second_Activity.class);
            startActivity(intent);
        }
    }
    
8、编译运行  

9、打开git bash，将文件夹push上github，向老师提交pull request.  

## 3.实验结果
Soft1614080902419Activity  
![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/3.1.png)
Second_Activity  
![Image text](https://github.com/ccxm/android-labs-2018/blob/master/soft1614080902419/3.2.png)

## 4.实验体会
学会了怎么新建Activity、如何添加图片、怎么切换Activity。刚开始做实验时，直接新建java类文件,报了很多错误,原来是活动需要注册,然后在manifest里注册,可是运行的时候页面不见了。对照着Soft1614080902419Activity看，原来每个活动都要调用一个界面才有显示。后来偶然翻书来看一下，发现直接新建Activity这样更方便，把注册活动和注册页面都省了。  
通过这次实验，逐渐了解了Android是怎么写的，基本就是Java的知识，而页面就是HTML的知识，一下子感觉简单了许多。

