# 第三次实验
## 1.实验目标 掌握在Android应用中使用图片等资源的方法
## 2.实验要求
1.在界面上显示至少一张图片（按照自己的题目添加）；
2.提交res/drawable及图片使用的代码；
3.提交res/values, res/layout等其他代码；
4.将应用运行结果截图，放到实验报告中；
5.点击图片（或按钮）时，打开另一个Activity
## 3.实验步骤
1.在xml文件中创建一个textview   然后再drawable的根目录中加入图片
   然后修改以下是textview的代码
    <TextView  
    android:id="@+id/textview_01"
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" />
 2.然后再xml文件中新建一个button  然后在java文件中对button进行监听，通过下面的代码修改
 然后就可以点击一个button进入到另一个activity中
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
3.运行截图
4.通过git上传文件
$ git pull
$ git add 学号目录/*
$ git commit "#12345678 "
$ git push

## 3. 实验结果
![Android studio安装截图](https://github.com/Caixz/android-labs-2018/blob/master/soft1614080902309/%E7%AC%AC%E4%B8%89%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE1.png);
![Android studio安装截图](https://github.com/Caixz/android-labs-2018/blob/master/soft1614080902309/%E7%AC%AC%E4%B8%89%E6%AC%A1%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE2.png);
## 4. 实验体会
这次实验，总的来说，还是难度不会那么大的，就是在上传文件的时候，上传位置上传失误了，最后花了时间去删除然后再重新上传
通过本次实验，让我进一步提高了对Android开发的认识，以及对Android Studio的实验，
 学会了设置背景图片，还有通过点击一个按钮，就可以进入到另一个activity中
