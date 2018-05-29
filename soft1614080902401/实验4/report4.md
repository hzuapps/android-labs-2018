1.实验目标
+  ①根据选题要求设计界面布局及控件使用；
+  ②布局xml及界面控制操作代码提交并截图；
+  ③将应用运行结果截图。（不要做登录注册！）
  
2.实验内容
+  ①使用其中一种布局方式，设计所选题目的界面：
+  ②通过控件ID获取界面对象，执行相关操作：
+  ③实现界面控件的事件处理，例如点击按钮：
  
3.实验步骤  
+  ①创建新项目
+  ②选好理想的布局。
+  ③根据需要向xml中添加控件。
+  ④为点击按钮添加触发事件代码
+   public void jilu(View view) {
+       //实现点击该按钮后跳转到指定界面
+        Intent intent = new Intent(Soft1614080902401.this, Soft16140809024012.class);
+        startActivity(intent);
+    }
+   ⑤界面2实验LinearLayout布局。
   
4.实验结果
  [image](https://github.com/uzi-up/android-labs-2018/blob/master/soft1614080902401/%E5%AE%9E%E9%AA%8C4/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180529195037.png)
  
   [image](https://github.com/uzi-up/android-labs-2018/blob/master/soft1614080902401/%E5%AE%9E%E9%AA%8C4/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20180529195054.png)

5.实验体会
+  此次实验需要先对自己所选课题进行布局选择，选择适合的布局后，根据需要添加控件，需要熟悉对监听event，如点击按钮后触发跳转界面等。

