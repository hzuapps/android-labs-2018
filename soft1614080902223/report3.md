# 第3次实验

## 1、实验目的

掌握在Android应用中使用图片等资源的方法

## 2、实验环境

Android studio、windows

## 3、实验步骤

（1）打开已建好的项目soft1614080902223 

（2）创建第二个activity：Soft1614080902223BMainActivity

（3）在第一个activity的xml文件，加入代码 activity的预览图中就出现了我想要的图片。 

（4）在第一个activity的java文件中加入监听器代码 public class MainActivity extends Activity implements OnClickListener {
......

	@Override    
	public void onClick(View v) {    
    	if(v.equals(startButton)) {    
     	   // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
     	   Intent intent = new Intent("另一个Activity的完整名称");    
     	   startActivity(intent);    
    		}    
 	}    
}  
这样就可以点打开另外一个新建的activity

（5）用 git 上传

## 4、实验结果
![实验截图](https://github.com/soulDeer/android-labs-2018/blob/master/soft1614080902223/shiyan3/shiyan3_1.png)

![实验报告](https://github.com/soulDeer/android-labs-2018/blob/master/soft1614080902223/shiyan3/shiyan3_2.png)

## 5、实验总结
通过实验，在百度查询帮助下，学会了在xml文件里面添加照片，学会了安装监听器在照片上。
