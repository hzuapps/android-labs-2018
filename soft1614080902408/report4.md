# 第四次实验

## 实验目标

1. 做出守望先锋掌游宝的新闻滑动界面
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

1.先画出布局
![](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/布局.png)
2.根据布局再写java代码和相应的xml代码，我这一次实验使用的是listview来实现列表嵌套，这种布局的好处是比较流畅，不卡，为了在listview中画出我想要的嵌套布局，我还要
再写一个xml文件，叫做news_list_item.xml。在这个文件中单独设置在listview中的组成单位item，这样就可以完成我想要的listview嵌套布局。

## 实验结果

![](https://github.com/wsgtl/android-labs-2018/blob/master/soft1614080902408/picture/实验四.PNG)

## 实验心得

  布局的话先画一个草图先，再根据草图我就可以心中有数，比较清楚地能够做出来。
  布局没有使用老师提到的布局而是用ConstraintLayout，主要是ConstraintLayout可以很方便的管理控件之间布局的关系，用起来比较简单。
  在过程中遇到列表不显示的问题，后来发现是我由于上一个也写了onCrete函数，导致两个oncreate函数不能正确识别，所以列表就不能显示。所以我把两个函数合并
  之后，列表就可以正常显示。我还遇到了列表不能扩展到下面导致下面是空白的问题，后来发现是 android:layout_height="567dp"中的567dp，我改成了  android:layout_height="match_parent"就可以正常扩展到下面，而match_parent是尽力扩展的意思。
