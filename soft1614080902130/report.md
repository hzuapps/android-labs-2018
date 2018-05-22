# 第四次实验 

## 1. 实验目标
根据选题要求设计界面布局及控件使用；<br>
布局xml及界面控制操作代码提交并截图；<br>
将应用运行结果截图。<br>

## 2. 实验要求
1.  使用其中一种布局方式，设计所选题目的界面：LinearLayout、RelativeLayout、TableLayout、AbsoluteLayout、ListView、GridView；
2.  通过控件ID获取界面对象，执行相关操作：<br>`android:id="@+id/my_button"`
3.  实现界面控件的事件处理，例如点击按钮：<br>
    `@Override`<br>
    `public void onClick(View v) {`<br>
    `......`<br>

## 3. 实验步骤
1.  新建一个`ThirdActivity`，并改写其内容，实现Listview显示玩家信息;
2.  在`res/layout`下编写相应的`activity_third.xml`文件，这里我将Listview加入，实现信息展示
	 <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/list_view"/>
4.  检查好预览效果，整理好界面的布局以及控件的位置。最好用虚拟机运行即可。`
5.  使用Git将代码提交到自己的库中：
	$  git pull <br>
	$  git add 学号目录/* <br>
	$  git commit "#12345678 "<br>
	$  git push <br>
6.  编辑实验报告，然后将项目目录一并pull给老师;



## 4. 实验结果
	实验截图1,2,3

## 5. 实验体会
1.  这次实验难度还行，使我体会到了选择好一种布局方式是多么的重要。
2.  尝试了LinearLayout布局方式，感觉良好。
3.  希望在接下来的时间把app的UI和功能完善好。
4.  对IDE的运用有进步。期待下一节的内容。