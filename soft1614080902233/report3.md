# 第三次实验

## 1.实验目标
掌握在Android应用中使用图片等资源的方法。

## 2.实验步骤

（1）打开已建好的项目soft1614080902233

（2）创建第二个activity：secondActivity

（3）在第一个activity的xml文件，加入代码

	<TextView  
    		android:id="@+id/textview_01"  
    		android:layout_width="wrap_content"  
    		android:layout_height="wrap_content"  
    		android:drawableTop="@drawable/maomao"  
    		android:text="hello_world" /> 
	activity的预览图中就出现了我想要的图片。

（4）在第一个activity的java文件中加入监听器代码

	public class MainActivity extends Activity  implements OnClickListener {    
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

## 3.实验结果

![image](https://github.com/liaohuajjj/android-labs-2018/blob/master/soft1614080902233/shiyan3/tupian3.1.png)

![image](https://github.com/liaohuajjj/android-labs-2018/blob/master/soft1614080902233/shiyan3/tupian3.2.png)

## 4.实验体会

这次实验对我来说非常困难，主要是因为不懂得Java的语法，需要百度学习。最后把程序转换为apk文件在手机上安装运行，感觉挺好的。