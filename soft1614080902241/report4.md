# 第四次实验

## 1.实验目标
 根据选题要求设计界面布局及控件使用；
 布局xml及界面控制操作代码提交并截图；
 将应用运行结果截图。（不要做登录注册！）
## 2.实验步骤
 (1)在实验二的基础上编写和创建新的文件，首先在drawable加入两张图片名字分别为jiemian.png  jiyibi.jpg
 在activity_second.xml进行布局，代码如下
     <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:text="支出情况："
            android:textSize="50sp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:text="今天：    ¥ 0.00"
            android:textSize="50sp" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:text="本月：    ¥ 0.00"
            android:textSize="50sp" />
        <ImageView
            android:layout_width="match_parent"
            android:layout_height="100dp" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:orientation="horizontal">

            <ImageButton
                android:id="@+id/imagebutton_01_01"
                android:layout_width="140sp"
                android:layout_height="100sp"
                android:background="#FFFFFF"/>
            <ImageButton
                android:id="@+id/imagebutton_01_02"
                android:layout_width="100sp"
                android:layout_height="100sp"
                android:background="@drawable/jiyibi" />

        </LinearLayout>


    </LinearLayout>
可以在design看到布局结果

在SecondActivity.java 编写监听器和事件代码如下
public class SecondActivity extends AppCompatActivity {
    private ImageButton button1_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1_2=(ImageButton) findViewById(R.id.imagebutton_01_02);

        button1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1_2=new Intent(SecondActivity.this,thirdActivity.class);
                startActivity(intent1_2);
            }
        });


    }

}


创建一个新的Activity名字分别为thirdActivity  

在activity_third.xml编写记账页面，代码如下
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="150dp"
            android:background="@drawable/jiemian"/>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="350dp"


            android:background="#FFEC4B"
            android:orientation="horizontal"
            >
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="本次消费"
                android:textSize="30sp"
                android:textStyle="bold"
                android:textColor="#FFFFFF"

                />
            <EditText
                android:layout_width="300dp"
                android:layout_height="wrap_content"
                android:text="                ¥ 0.00"
                android:textColor="#FFFFFF"
                android:textStyle="bold"
                android:textSize="30sp"

                />

        </LinearLayout>

        <Button
            android:id="@+id/button01_02"
            android:layout_width="match_parent"
            android:layout_height="70dp"
            android:text="保存"
            android:textSize="30sp"
            android:textStyle="bold"

            android:background="#FFFFFF"
            />
    </LinearLayout>
(2)
使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018 

$ git pull 

$ git add 学号目录/* 

$ git commit "#4 #921 第四次实验" 

$ git push 

在自己的GitHub库上创建和发送Pull Request（注意查看Changed files） 

// 是否只修改了自己的文件？ 

在GitHub中使用Markdown文件编写实验报告（report4.md） 

// 保存在自己的文件夹下 
## 3.实验结果
![image](https://github.com/LuoJKL/android-labs-2018/blob/master/soft1614080902241/4_1.jpg)

![image](https://github.com/LuoJKL/android-labs-2018/blob/master/soft1614080902241/4_2.jpg)

![image](https://github.com/LuoJKL/android-labs-2018/blob/master/soft1614080902241/4_3.jpg)
## 5.实验体会

通过本次实验对界面布局有了一定的了解，知道怎么去编写监听器，了解了事件是怎么发生的。
