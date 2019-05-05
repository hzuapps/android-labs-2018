第四次实验

## 实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。


## 实验内容

1. 使用其中一种布局方式，设计所选题目的界面：
![](https://user-images.githubusercontent.com/627946/39629467-e47676f2-4fde-11e8-920a-fc1ca6351fdf.png)
2. 通过控件ID获取界面对象，执行相关操作：

```
+android:id="@+id/my_button"
```
3. 实现界面控件的事件处理，例如点击按钮：
 ![](https://user-images.githubusercontent.com/627946/39629667-8ba7225a-4fdf-11e8-8a8e-9c7c653eda31.png)

```
public class MainActivity extends Activity  implements OnClickListener {    
    ......   
    @Override    
    public void onClick(View v) { 
     ......
 ```
 

## 实验步骤
1先声明xml使用RelativeLayout布局并嵌入LinearLayout布局
2设置两个RelativeLayout
3一个放图片并加按钮
4另一个放一个按钮
5然后创一个按钮监听器，再进行监听器注册
 
## 实验结果
![image](https://raw.githubusercontent.com/IsMyLucas/android-labs-2018/master/Soft1612070501328/%E5%AE%9E%E9%AA%8C4%E6%88%AA%E5%9B%BE1.png)
![image](https://raw.githubusercontent.com/IsMyLucas/android-labs-2018/master/Soft1612070501328/%E5%AE%9E%E9%AA%8C4%E6%88%AA%E5%9B%BE2.png)
 
## 实验心得
  本次实验难度较以往实验有所增长，但是我还是觉得做的很简陋，不懂的地方需要在网上参考教学视频来学习。
