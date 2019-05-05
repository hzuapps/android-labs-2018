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
 android:id="@+id/my_button"
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
 1.用LinearLayout布局设计页面
 2.把context用.com1614080901230Activity来弄
 3.加一个“点击查看详情”的按钮
 4.然后进行查看
  
 ## 实验结果
 ![image](https://raw.githubusercontent.com/JingZXian/android-labs-2018/master/com1614080901230/3.png)
 ![image](https://raw.githubusercontent.com/JingZXian/android-labs-2018/master/com1614080901230/4.png)
  
 ## 实验心得
   本次实验还容易，可能是因为我选的题目比较简单，所以很快就做出来了，就加几个控件就行。