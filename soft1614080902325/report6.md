# 第六次实验 

## 1.实验目标
掌握Android网络访问方法；  
理解XML和JSON表示数据的方法。

###实验内容
我用在实现网络访问加载图片的方法是利用Android图片加载图Glide来实现访问网络图片的，没有按照老师说的实验内容做，如果不允许请告诉我重做
## 2. 实验步骤
1、在GitHub上面搜索Glide，里面有详细说明用法。  
利用Android studio的gradle的功能帮我们加载库，方法是：  
在bulid.gradle里面添加如下代码：  

    repositories {  
        mavenCentral()  
        google()  
    }  

    implementation 'com.github.bumptech.glide:glide:4.7.1'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.7.1'
完成之后在右上角点sync now更新。  
2、此时利用之前activity_personal_information.xml写的一个ImageView

    <ImageView
        android:id="@+id/tv_11"
        android:layout_width="match_parent"
        android:layout_height="250dp"
        />
在personalInformationActivity.java上先声明ImageView tv_11，然后用Glide实现访问网络上的惠州学院图标。

    private ImageView tv_11;
    
        tv_11=findViewById(R.id.tv_11);
        Glide.with(this).load("http://p8.qhmsg.com/dr/217_214_/t01fe2c1732a6a9a83d.jpg").into((ImageView) tv_11);
3、最后最重要的是要得到网络授权。  
在AndroidManifest.xml上加入代码：

    <uses-permission android:name="android.permission.INTERNET"/>
## 3. 实验结果

![在Android SDK](https://github.com/li763407418/android-labs-2018/blob/master/soft1614080902325/%236.png)


## 4. 实验体会
我做的是利用Imageview来实现访问网络上的图片，跟老师的要求有点不太一样，老师要求是下载保存到本地然后将图片显示在应用上，而我的是不下载直接显示。

**加粗**常规