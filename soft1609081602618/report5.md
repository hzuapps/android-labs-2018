# 第五次实验

  1.实验目标
 ### 1.掌握在Android App中存储数据。
 ## 2.实验内容
 ### 1.将应用产生的数据存储到数据库中；
 ### 2.使用UML类图描述表结构；
 ### 3.将应用运行结果截图。
 ## 3.实验步骤 
 ### 1.新建RecordDBHelper类，准备新建数据库；
 ### 2.在名为RecordSearchActivity的Activity中建立RecordDBHelper类的对象，并初始化数据库；
 ### 3.在RecordSearchActivity中分别为创建一个个EditText添加addTextChangedListener,监听EditText；
 ### 4.当用户进行输入的时候进行sql的模糊查询，如果查找到符合的就利用SimpleCursorAdapter适配器将数据放到 ###   listview中
 ### 5.当用户按下回车键的时候就将当前编辑框上的文字保存到数据库中
 ### 6.然后进行跳转，同时使用intent传递用户输入的值，如果服务器中存在相对应的值的话就显示出信息否则弹出 ###   一个无数据记录框
 ### 4.实验结果
 ###![image](https://github.com/unihaoke/android-labs-2018/blob/master/soft1609081602618/1527407300(1).png)
+ ## 5.实验体会
+ ### 这次的实验中遇到了一个bug就是在执行select id as _id,rName from record where rName like "+" '%" + tempName + "%' " +"order by id desc这条语句的时候发现老是不能够正常运行，后来通过自己一步一步的排查发现原来是" '%"前面要使用空格将前面的字符串隔开才能正常执行sql语句
