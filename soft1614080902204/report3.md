# 第3次实验

## 1、实验目的
掌握在Android应用中使用图片等资源的方法。

## 2、实验环境

windows、android studio

## 4、实验步骤

（1）打开已建好的项目soft1614080902204

（2）新建activity：soft1614080902233BActivity

（3）在xml文件中插入代码

<TextView  
    android:id="@+id/textview_01"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" /> 

这样就可以在布局中看到自己想要的图片

（4）在activity中写入相应的监听器代码

public class MainActivity extends Activity  implements OnClickListener {    
    ......    
    
    @Override    
    public void onClick(View v) {    
        if(v.equals(startButton)) {    
            // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
            Intent intent = new Intent("另一个Activity的完整名称");    
            startActivity(intent);    
        }    
    }    
}  

（5）打包成apk文件运行成功，点图片跳转到第二个activity

## 5、实验结果
![实验截图](https://github.com/545072985/android-labs-2018/blob/master/soft1614080902204/tupian3.1.png)
![实验结果](https://github.com/545072985/android-labs-2018/blob/master/soft1614080902204/tupian3.2.png) 

## 6、实验总结
1、经过此次实验，我们对github与git有了进一步的认识，使用github起来更顺心顺意。
