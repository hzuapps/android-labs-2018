# 第三次实验

## 实验目的

掌握在Android应用中使用图片等资源的方法。

## 实验要求

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 实验步骤（仅供参考）

1. 统一步骤：
    https://github.com/hzuapps/android-labs-2018/blob/master/labs-steps.md
2. Android 在TextView 中显示图片的4种方式：
    https://blog.csdn.net/u012724237/article/details/79010741

## 实验提示

1. 在界面中显示图片

```
<TextView  
    android:id="@+id/textview_01"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" />  
```

2. 打开另一个Activity

```
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
```

完整代码参考：https://github.com/hzuapps/android-labs-2018/tree/master/t123456/app/src/main

3. 根据自己的选题来设计动作。例如，聊天App中，点击头像显示个人信息；提交表单时，打击按钮显示提交结果；等等。

## 实验步骤

0. 给起始的 Activity 添加一张图片，设置点击事件，跳转到Player的Activity。
1. 新建一个Activity，命名为Player，用来当播放器的控制界面
2. 添加三个按钮，功能分别是："选择文件","播放","下一首"(未实现)
3. 在Activity对应的Java文件  Player.java 中给按钮添加按钮事件，具体代码请参考 [Player.java](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/java/edu.hzuapps.androidlabs.soft1614080902427/Player.java)
4. 实现"选择文件"和"播放"音乐功能

## 实验结果

![1](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1524494176.png)

![2](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1524494180.png)

![3](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1524494458.png)


## 实验心得

这个实验需要对UI部件添加点击事件，经过一番摸索和网上的搜索终于添加成功。

不过老师给出的跳转Activity代码似乎有错：
```
Intent intent = new Intent("另一个Activity的完整名称");    
startActivity(intent);    
```

我在网上找到打开新的Activity的代码：

参数mContext是当前的Activity,可以用this替换

参数NewActivity.class 则是Activity的class对象，我就把它换成Player.class  [代码](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/java/edu.hzuapps.androidlabs.soft1614080902427/Soft1614080902427Activity.java#L28-L29)
```
Intent intent = new Intent(mContext,NewActivity.class);    
startActivity(intent);    
```

"选择文件" 功能参考了Android文档上的代码 [Storage Access Framework](https://developer.android.com/guide/topics/providers/document-provider.html)

"播放"  功能参考了 [error-creating-mediaplayer-with-uri-or-file-in-assets](https://stackoverflow.com/questions/3093562/error-creating-mediaplayer-with-uri-or-file-in-assets)
