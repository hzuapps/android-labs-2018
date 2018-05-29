# 实验目的
掌握在Android应用中使用图片等资源的方法。
# 实验要求
1.在界面上显示至少一张图片（按照自己的题目添加）；

2.提交res/drawable及图片使用的代码；

3.提交res/values, res/layout等其他代码；

4.将应用运行结果截图，放到实验报告中；

5.点击图片（或按钮）时，打开另一个Activity。
# 实验步骤（仅供参考）
1.统一步骤：
https://github.com/hzuapps/android-labs-2018/blob/master/labs-steps.md

2.Android 在TextView 中显示图片的4种方式：
https://blog.csdn.net/u012724237/article/details/79010741
# 实验提示
1.在界面中显示图片
<TextView
        android:id="@+id/bj"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/qqmusic"
        android:text="QQ音乐!" />
2.打开另一个Activity
public class Soft1614080902121Activity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902121);
        textView=(TextView)findViewById(R.id.button1);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(Soft1614080902121Activity.this,SecondActivity.class);
                startActivity(intent);
            }});
    }

    }
3.根据自己的选题来设计动作。例如，聊天App中，点击头像显示个人信息；提交表单时，打击按钮显示提交结果；等等。
# 实验体会
掌握了在一个Activity打开另一个Activity
