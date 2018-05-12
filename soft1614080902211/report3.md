# 实验目的


掌握在Android应用中使用图片等资源的方法。


# 实验要求


在界面上显示至少一张图片（按照自己的题目添加）；
提交res/drawable及图片使用的代码；
提交res/values, res/layout等其他代码；
将应用运行结果截图，放到实验报告中；
点击图片（或按钮）时，打开另一个Activity。
实验步骤（仅供参考）
1.统一步骤：
  https://github.com/hzuapps/android-labs-2018/blob/master/labs-steps.md
2.Android 在TextView 中显示图片的4种方式：
  https://blog.csdn.net/u012724237/article/details/79010741
实验提示
在界面中显示图片
<TextView  
    android:id="@+id/textview_01"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" />  
打开另一个Activity
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
完整代码参考：https://github.com/hzuapps/android-labs-2018/tree/master/t123456/app/src/main

3.根据自己的选题来设计动作。例如，聊天App中，点击头像显示个人信息；提交表单时，打击按钮显示提交结果；等等。

# 实验截图
  ![image](https://github.com/LinCJ1998/android-labs-2018/blob/master/soft1614080902211/p1.PNG)
  ![image](https://github.com/LinCJ1998/android-labs-2018/blob/master/soft1614080902211/p2.PNG)
