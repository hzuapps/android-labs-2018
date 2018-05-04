## 第三次实验报告

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

 <ImageView
 
            android:layout_width="100dp"
            android:layout_height="100dp" 
            android:layout_marginLeft="135dp"
            android:layout_marginTop="50dp"
            android:background="@drawable/addition"/>
            
        
2.打开另一个Activity

public class Soft1613071002123Activity extends AppCompatActivity{
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1613071002123);
        login = (Button)findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Soft1613071002123Activity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

3.根据自己的选题来设计动作。例如，聊天App中，点击头像显示个人信息；提交表单时，打击按钮显示提交结果；等等。

# 实验结果
登录注册界面截图：
![image](https://raw.githubusercontent.com/Beginner-hww/android-labs-2018/master/soft1613071002123/%E7%99%BB%E5%BD%95%E6%B3%A8%E5%86%8C%E7%95%8C%E9%9D%A2.png)

登录成功界面截图：
![image](https://raw.githubusercontent.com/Beginner-hww/android-labs-2018/master/soft1613071002123/%E7%99%BB%E5%BD%95%E6%88%90%E5%8A%9F%E7%95%8C%E9%9D%A2.png)

# 实验体会

通过这次实验，学习了如何通过ImageView节点插入图片，通过TextView创建文本框，通过EditText创建输入栏，通过Botton节点创建按钮，并且学会了界面转换。
感觉这次实验让我学到了很多东西。
