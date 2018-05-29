# 实验目标
### 1.根据选题要求设计界面布局及控件使用；
### 2. 布局xml及界面控制操作代码提交并截图；
### 3.将应用运行结果截图。
# 实验内容
### 1.使用LinearLayout,TableLayout,RelaitiveLayout,ListView等其中一种布局方式，设计所选题目的界面：
### 2.通过控件ID获取界面对象，执行相关操作：
      android:id="@+id/my_button"
### 3.实现界面控件的事件处理，例如点击按钮：
~~~
public class MainActivity extends Activity  implements OnClickListener {    
    ......   
    @Override    
    public void onClick(View v) { 
    ......
 ~~~
# 实验提示
### 1.重写实验报告，可以网站上直接修改和预览，但是要在自己电脑上执行命令：
~~~
git pull
~~~
### 2.在界面中显示图片
~~~
<TextView  
    android:id="@+id/textview_01"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" />  
~~~
### 3.打开另一个Activity
~~~
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
~~~
### 4.只提交自己创建的文件！！！
# 实验结果
 ![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/tu1.png)
 ![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/tu2.png)
# 实验体会
### 本次实验是布置相关布局，但由于自己学的很少，不清楚各种布局如何使用。最后经过查阅资料，勉强做出最简单的界面。
