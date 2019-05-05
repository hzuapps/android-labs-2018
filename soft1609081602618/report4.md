# 第4次实验
## 1.实验目标
1.根据选题要求设计界面布局及控件使用；

2.布局xml及界面控制操作代码提交并截图；

3.将应用运行结果截图。
## 2.实验内容
1.使用其中一种布局方式，设计所选题目的界面

2.通过控件ID获取界面对象，执行相关操作：
android:id="@+id/my_button"

3.实现界面控件的事件处理，例如点击按钮：
public class MainActivity extends Activity  implements OnClickListener {    
    ......   
    @Override    
    public void onClick(View v) { 
    ......
    
## 3.实验步骤
1.打开Android Studio；

2.打开layout文件夹里的soft_1609081602618_activity2.xml和soft_1609081602618_activity3.xml；

3.设计界面布局，添加控件；

4.实现部分控件的事件处理；

5.运行测试。
## 4.实验结果
![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/1526055697(1).png)
![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/1526108833(1).png)
第一张图是进去时显示的页面，第二张图是第一张图向下拉时显示的图片，其中底部的三个image图片是用来切换fragment的
6.实验体会
这次的实验主要有2个bug令我花费蛮多的时间
1.第一个bug就是ImageView中的src属性添加png格式图片的时候显示异常，后来改成jpg格式就可以使用了，具体原因不清楚还请老师解答一下
2.第二个就是fragment的事务
FragmentTransaction begin=fragmentManager.beginTransaction();我写的时候是先初始化FragmentTransaction，然后在click（）方法中调用commit（）方法，但是Logcat显示commit（）方法这里错误，后来查看了一下API发现
每提交一次commit（）需要生成一个FragmentTransaction对象
3.之前学习了ListView，想要使用它来做底部布局的，但是后来想起来Fragment+ViewPager实现底部布局加滑动效果会更好，所以就没有使用ListView。
