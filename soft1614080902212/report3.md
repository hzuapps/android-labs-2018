# 第三次实验

## 1.实验目标

掌握在Android应用中使用图片等资源的方法。

## 2.实验步骤

（1）打开已建好的项目soft1614080902212

（2）创建第2个activity：SecondActivity

（3）在第一个activity的xml文件，添加自己想要的图片

（4）在第一个activity的Java文件中加入监听器的代码：Button=(Button)findViewById(R.id.button1);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Soft1614080902212MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

（5）用git上传

## 3.实验结果

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png3.1.png)

![](https://github.com/hzulinzr/android-labs-2018/blob/master/soft1614080902212/png3.2.png)

## 4.实验体会

这次实验对我来说挺困难的，在同学的帮助下，终于完成了这次实验。了解了许多之前不懂的知识。