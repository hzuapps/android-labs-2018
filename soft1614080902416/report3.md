# 实验目的
掌握在Android应用中使用图片等资源的方法。
# 实验要求
1.在界面上显示至少一张图片（按照自己的题目添加），点击时跳转。

2.提交res/drawable及图片使用的代码；

3.提交res/layout等其他代码；

4.将应用运行结果截图，放到实验报告中；

5.点击图片（或按钮）时，打开另一个Activity。
# 实验步骤（仅供参考）
1.统一步骤：
https://github.com/hzuapps/android-labs-2018/blob/master/labs-steps.md

2.Android 在TextView 中显示图片的4种方式：

# 实验提示
1.在界面中显示图片
    <TextView
        android:id="@+id/textview-01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/plusicon"
        android:text="hello_world" />

2.打开另一个Activity
public class soft1614080902416main1Activity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902416main1);
        Button bt1 = (Button)findViewById(R.id.button);
        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,soft1614080902416main2Activity.class);
        startActivity(intent);
    }
}

# 实验体会
了解了动作的跳转，和Activity的使用和各个界面之间的联系，各加复习了java
