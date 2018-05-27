# 第三次实验

## 1、实验要求  

**掌握在Android应用中使用图片等资源的方法。**  
## 2、实验步骤 

1. 在网上找到一张图片然后把图片放在res/drawable文件夹命名为share.png  
2. 在anni_home.xml中的一个TextViews中添加android:drawableTop="@drawable/share",添加刚才下载的图片  
3. 用以下代码实现跳转到另一个activity  
```
btnOpen.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(thisActivity,"跳转的类名".class);
        thisActivity.startActivity(intent);
    }
});
```


## 3、实验结果 
我的Android应用第一个activity截图。
![](https://github.com/YoMiao/android-labs-2018/blob/master/com1614080901130/screen/report3_screen01.png)
点击按钮后跳转的activity.
![](https://github.com/YoMiao/android-labs-2018/blob/master/com1614080901130/screen/report3_screen02.png)
## 4、实验体会 
1. 配置android环境的时候用了很多时间，心态有点崩，自己走了弯路。 
2. 现在看到成果还是不错的。
