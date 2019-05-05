# 实验三
 
## 一、 实验目标
	掌握在Android应用中使用图片等资源的方法。
	1、在界面上显示至少一张图片（按照自己的题目添加）；  
	2、提交res/drawable及图片使用的代码；  
	3、提交res/values, res/layout等其他代码；  
	4、将应用运行结果截图，放到实验报告中；  
	5、点击图片（或按钮）时，打开另一个Activity。 
 
## 二、 实验步骤
	1、创建一个新的Activity：turnActivity；
	2、在res/drawable下添加图片；
	3、在layout/activity_turn.xml中添加有关图片的代码：
		 <ImageView
        	android:id="@+id/pic2"
        	android:src="@drawable/add"
        	android:scaleType="centerCrop"
        	android:layout_width="match_parent"
        	android:layout_height="match_parent" />
	4、添加按钮
		 <Button
        	android:id="@+id/startButton"
        	android:layout_width="156dp"
        	android:layout_height="wrap_content"
        	android:layout_marginBottom="8dp"
        	android:text="添加"
        	app:layout_constraintEnd_toEndOf="parent"
        	app:layout_constraintStart_toStartOf="parent" />
	5、实现点击按钮跳转
		 startButton = (Button)findViewById(R.id.startButton);
        	startButton.setOnClickListener(new OnClickListener(){
            	@Override
            	public void onClick(View v) {
                	Intent intent = new Intent(Soft1614080902313EventReminderActivity.this,turnActivity.class);
                	startActivity(intent);
           		 }
      		  } );
	6、提交代码并发Pull Request：
		$ git pull
		$ git add 路径/项目/* 
		$ git commit "#4 #970 第四次实验" 
		$ git push


## 三、 实验结果

## app运行看见第一个Activity:
![](https://github.com/LingEcro/android-labs-2018/blob/master/soft1614080902313/%E5%AE%9E%E9%AA%8C%E4%B8%89%E5%9B%BE%E4%B8%80.png)

## 点击下方"添加"按钮后调到另一个Activity：
![](https://github.com/LingEcro/android-labs-2018/blob/master/soft1614080902313/%E5%AE%9E%E9%AA%8C%E4%B8%89%E5%9B%BE%E4%BA%8C.png)

## 四、 实验体会
 	APP运行时，要实现页面跳转，要通过事件来完成，虽然实现代码比较简单，但要使界面更加美观需要费更多的心思。
