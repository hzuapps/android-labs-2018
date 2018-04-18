# 1.实验目标
了解Android组件编程

# 2.实验步骤
（1）在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2018/issues ；
（2）根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
（3）将标题设置为自己的学号+对应的功能或题目；
（4）根据自己选择的题目实现Activity中导航、调用等功能（选做）。

# 3.实验结果
（1）package edu.hzuapps.androidlabs.soft1614080902220

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class soft1614080902220Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soft1614080902220)
    }
}
（2）
<resources>
    <string name="app_name">soft1614080902220微信自动抢红包软件</string>
</resources>

# 4.实验体会
  初步了解了Android组件编程的步骤，虽然比较简单，但对后续的Android代码编写不可缺少，同时提高了对Android软件的认识！
