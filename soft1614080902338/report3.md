+# 第三次实验 
+
## 1. 实验目标
+### 掌握在Android应用中使用图片等资源的方法。
## 2. 实验内容
+### (1)在界面上显示至少一张图片（按照自己的题目添加）；
+### (2)提交res/drawable及图片使用的代码；
+### (3)提交res/values, res/layout等其他代码；
+### (4)将应用运行结果截图，放到实验报告中；
+### (5)点击图片（或按钮）时，打开另一个Activity。
## 3.实验步骤
 ### 在AndroidManifest.xml添加 
 <activity
+            android:name=".Soft1614080902338Activity"
+            android:label="@string/app_name"
+            android:theme="@style/AppTheme.NoActionBar">
 <activity
+            android:name=".Second"
+            android:label="@string/title_activity_second"
+            android:theme="@style/AppTheme.NoActionBar"></activity>
 ### 在string.xml下添加 
 <string name="app_name">计算器</string>
+    <string name="action_settings">Settings</string>
+    <string name="title_activity_second">Second</string>
 ### 在drawable下，添加图片
 ### 要实现点击一张图片跳转到另外一张图片，需要在建一个java(Second.java)
 ### 需要进行监听，所以需要设置OnClick,setOnclickListener,通过Intent实现界面跳转

## 4. 实验结果
+
+![结果](https://github.com/kebo24/android-labs-2018/blob/master/soft1614080902338/Activity1.png)
+### 点击后
+![结果](https://github.com/kebo24/android-labs-2018/blob/master/soft1614080902338/Activity2.png)
+## 5. 实验体会
+**这次实验主要是对点击界面事件跳转知识点的掌握，第一次调试虚拟机，刚开始有点懵懂，而且感觉虚拟机运行速度远远没有使用真机快。添加图片id，在实现界面跳转的过程中，设置点击事件，以及对事件进行监听是本次实验的关键，通过intent来实现交互界面。本次实验看似简单，其实也是一个小小的项目，它让你了解了一个项目最基本的内容，点击事件，实现控制事件的内容。
