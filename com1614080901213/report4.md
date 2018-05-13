# 第四次实验

## 1.实验目标
 根据选题要求设计界面布局及控件使用；
 布局xml及界面控制操作代码提交并截图；
 将应用运行结果截图。（不要做登录注册！）
## 2.实验步骤
 (1)在实验二的基础上编写和创建新的文件，首先在drawable加入两张图片名字分别为beimian.png  fangkuai.png
 在activity_second.xml进行布局，代码如下
     <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/mText"
            android:layout_width="750px"
            android:layout_height="300px"
            android:layout_x="20px"
            android:layout_y="32px"
            android:text="请猜那一张是方块A"
            android:textSize="18sp">
        </TextView>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="200dp">

            <ImageButton
                android:id="@+id/mImage01"
                android:layout_width="127dp"
                android:layout_height="200dp"
                android:background="@drawable/beimian" />

            <ImageButton
                android:id="@+id/mImage02"
                android:layout_width="125dp"
                android:layout_height="200dp"
                android:background="@drawable/beimian" />

            <ImageButton
                android:id="@+id/mImage03"
                android:layout_width="125dp"
                android:layout_height="200dp"
                android:background="@drawable/beimian" />

        </LinearLayout>

    </LinearLayout>
可以在design看到布局结果

在Second.java 编写监听器和事件代码如下
private ImageButton pai1, pai2, pai3;
    private Button mImage01;
    private Button mImage02;
    private Button mImage03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        pai1 = (ImageButton) findViewById(R.id.mImage01);
        pai2 = (ImageButton) findViewById(R.id.mImage02);
        pai3 = (ImageButton) findViewById(R.id.mImage03);
        pai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThreeActivity.class);

                startActivity(intent);
            }
        });

        pai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

        pai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, FourActivity.class);

                startActivity(intent);
            }
        });

    }
创建两个新的Activity名字分别为ThreeActivity  FourActivity.

在activity_three.xml编写游戏跳转后结果，代码如下
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:layout_width="750px"
            android:layout_height="100px"
            android:layout_x="20px"
            android:layout_y="32px"
            android:text="恭喜你猜对了"
            android:textSize="18sp">
        </TextView>

        <TextView
            android:id="@+id/text2"
            android:layout_width="380sp"
            android:layout_height="500sp"
            android:background="@drawable/fangkuai"/>

    </LinearLayout>

在 activity_four.xml编写另一个游戏结果，代码如下
  <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <TextView
            android:id="@+id/mText"
            android:layout_width="750px"
            android:layout_height="100px"
            android:layout_x="20px"
            android:layout_y="32px"
            android:text="很遗憾猜错了"
            android:textSize="18sp">
        </TextView>

    </LinearLayout>
(2)
使用Git将代码提交到自己的库中：https://github.com/YOUR_NAME/android-labs-2018 

$ git pull 

$ git add 学号目录/* 

$ git commit "#3 #1453第四次实验+报告" 

$ git push 

在自己的GitHub库上创建和发送Pull Request（注意查看Changed files） 

// 是否只修改了自己的文件？ 

在GitHub中使用Markdown文件编写实验报告（report4.md） 

// 保存在自己的文件夹下 
## 3.实验结果
![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/5.png)

![image](https://github.com/huangdewei/android-labs-2018/blob/master/com1614080901213/6.png)
## 5.实验体会

通过这次实验对界面布局从陌生到有一定的了解，和怎么去编写监听器，了解事件的怎么发生。