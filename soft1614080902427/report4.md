# 第四次实验

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

0. 先对Activity的布局分析：Activity中间需要存放歌单的列表，下方是播放控制栏

   列表可以采用ListView控件，播放控制栏可以采用Layout嵌套的方式继续布局
   
   播放控制栏：左边是歌手头像或歌曲封面，接着是两行TextView，最后是两个播放按钮和下一曲按钮
   
   歌单列表：左边显示序号或其他图标，右边两行显示歌曲名和歌手名

    ![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/layout.png)
    
1. 对整个Activity使用ConstraintLayout

2. 播放控制栏也使用ConstraintLayout，分别用 ImageButton，TextView 填充对应位置。用ConstraintLayout约束它们的位置关系

3. 歌单列表同理也用ImageButton和TextView 填充对应位置，修改图标和字体颜色，让人看起来舒服美观。

因为歌单的内容会动态改变，不应该用XML的方式写死布局，所以采用适配器(Adapter)的方式显示。 [相关代码](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/java/edu/hzuapps/androidlabs/soft1614080902427/Player.java#L50-L169)


## 实验结果

![](https://github.com/harytfw/android-labs-2018/blob/master/soft1614080902427/Screenshot_1525757754.png)

## 实验心得

  布局的话先画一个大概的草图，在实际设计的时候对照着草图设计，可以做到心中有数
  
  布局没有使用老师在 [实验四](https://github.com/hzuapps/android-labs-2018/issues/4)提到的布局而是用ConstraintLayout，主要是ConstraintLayout可以很方便的管理控件之间布局的关系，不用过多的关心控件之间的距离，用起来比较简单
  
  对ImageButton设置图标的时候发现图标过大，内容溢出了按钮，在设置 `android:scaleType="fitCenter"` 后可以正常显示
  
  我用自定义的 Adapter 连接想要展示的数据和ListView.关于SongAdapter 的代码一部分是从网上找，一部分是结合需要改动的。
  
  图标我是在[iconfont](http://www.iconfont.cn/)，可以找到一整套图标，而且可以改颜色和大小，非常方便
  
