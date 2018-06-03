# 第四次实验 
## 1.实验目标 
①根据选题要求设计界面布局及控件使用；                   
②布局xml及界面控制操作代码提交并截图；                    
③将应用运行结果截图。（不要做登录注册！）                     

## 2.实验内容 
①加入TextView，Button控件；                         
②TextViwe展示相应内容，Button进行跳转；                

## 3.实验步骤 
①加入TextView，输入“图书列表”；                         
②编辑Button，如下模板
btn_save.setOnClickListener(new View.OnClickListener()
{
   @Override
   public void onClick(View view)
   {
    Intent intent = new Intent(当前的Activity.this, 要跳转的Activity.class);
    startActivity(intent);
   }
 });；                
③在相应布局的Java文件下编辑即可完成；        
④进行调试，手机需打开开发者选项，并且usb调试和usb安装要打开；                                             
⑤安装完app后点击添加图书即可跳转

## 4.实验结果 
 ![image](https://github.com/Flash404/android-labs-2018/blob/master/soft1508081001217/%E8%BF%90%E8%A1%8C%E6%88%AA%E5%9B%BE.png) 

## 5.实验体会 
按钮是我认为app最容易出错地方之一。命名和定义都需要极其准确。有时候在手机调试app，点击图标会闪退。或者进入程序但点击按钮会闪退出来。
得注意Activity有没有打错。并且安卓的四大组件都要在manifest中注册才能使用。
