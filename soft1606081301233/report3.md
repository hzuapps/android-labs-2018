# 实验目的
## 掌握在Android应用中使用图片等资源的方法。
# 实验要求
## 1.在界面上显示至少一张图片（按照自己的题目添加）；
## 2.提交res/drawable及图片使用的代码；
## 3.提交res/values,res/layout等其他代码；
## 4.将应用运行结果截图，放到实验报告中；
## 5.点击图片（或按钮）时，打开另一个Activity。
# 实验步骤（仅供参考）
## 1.统一步骤：

1. 阅读实验要求：https://github.com/hzuapps/android-labs-2018/labels/Lab   

2. 在电脑上Android Studio编写代码  

```   
// 代码要可以运行！
```   

3. 使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018   
```  
$ git pull
$ git add 学号目录/*  (git rm 学号目录/*)
$ git commit "#12345678 "
$ git push
```  

4. 在自己的GitHub库上创建和发送Pull Request（注意查看Changed files）  
```  
// 是否只修改了自己的文件？
```  

5. 在GitHub中使用Markdown文件编写实验报告（report1.md, report2.md）  
```  
// 保存在自己的文件夹下
```  
## 2.Android 在TextView中显示图片的4种方式：
https://blog.csdn.net/u012724237/article/details/79010741
# 实验提示
## 1.在界面中显示图片
<TextView  
    android:id="@+id/textview_01"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:drawableTop="@drawable/ic_launcher"  
    android:text="hello_world" />  
## 2.打开另一个Activity
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
### 完整代码参考：https://github.com/hzuapps/android-labs-2018/tree/master/t123456/app/src/main
## 3.根据自己的选题来设计动作。例如，聊天App中，点击头像显示个人信息；提交表单时，打击按钮显示提交结果；等等。
# 实验结果
## 打开另一个Activity之前的截图
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/%E6%89%93%E5%BC%80%E5%8F%A6%E4%B8%80%E4%B8%AAActivity%E4%B9%8B%E5%89%8D.png)
## 打开另一个Activity之后的截图
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/%E6%89%93%E5%BC%80%E5%8F%A6%E4%B8%80%E4%B8%AAActivity%E4%B9%8B%E5%90%8E.png)
# 实验体会
###   本次实验是在界面添加图片，即在res目录下的drawable添加代码，然后在主Activity新建一个按钮，用于点击跳转到另一个界面，修改相应的配置信息。本次的实验代码我并不会写，查阅过很多资料，总算完成这次实验的基本要求。然后这次安装模拟器装了好久，运行的时候也很慢。