第三次实验
1、实验要求
掌握在Android应用中使用图片等资源的方法。

2.实验内容
1.使用一种布局方式，设计所选题目的界面
2.通过控件ID获取界面对象，执行相关操作
3.实现界面控件的事件处理，例如点击按钮

2、实验步骤
在网上找到一张图片然后把图片放在res/drawable文件夹命名为exp.png
在anni_home.xml中的一个TextViews中添加android:drawableTop="@drawable/exp",添加刚才下载的图片
用以下代码实现跳转到另一个activity
btnOpen.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(thisActivity,"跳转的类名".class);
        thisActivity.startActivity(intent);
    }
});

3.实验结果
![image](https://github.com/HuangVen/android-labs-2018/blob/master/Com1614080901228/result4_1.png）
![image](https://github.com/HuangVen/android-labs-2018/blob/master/Com1614080901228/result4_2.png）
4.实验体会
本次实验通过学习掌握安卓的布局方式，并在自己建立的issue基础上用LinearLayout布局方式，在实验过程中，为了实现点击button响应函数并跳转功能，
实验重复了好多遍，并且在调整首页时通过网上查询学习如何调整页面内容的布局也花费了较多时间。
