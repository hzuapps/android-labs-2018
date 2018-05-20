# 实验目标
### 掌握在Android App中存储数据
# 实验内容
## 根据选题要求使用文件存储
#### 1.将应用产生的数据保存到文件存储中；
#### 2.说明使用的文件存储方式：内部 or 外部；
#### 3.将运行结果截图。

# 实验步骤
### 1.打开项目soft1606081301233；
### 2.（1）在activity_second.ml文件中添加btnSave按钮的onClick()方法；
``` 
android:onClick="save"
```
### （2）添加btnRead按钮的onClick()的方法：
```
android:onClick="read"
```
### 3.(1)在SecondActivity.java中实现save()方法，采用文件内部存储的方法：
```
 //写入
    public void save(String text) throws IOException {
        FileOutputStream fos = null;
        BufferedWriter writer = null;
        try {
            fos = openFileOutput("test.txt", ContextWrapper.MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(text);
            writer.flush();
            Toast.makeText(this, "写入完成", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
```
### (2)实现read（）方法：
```
//读出
public String read() throws IOException {
        String s=null;
        FileInputStream fis=null;
        try {
            fis=this.openFileInput("test.txt");
            int len=0;
            byte[] buffer=new byte[1024];
            while((len=fis.read(buffer))!=-1){
                s=new String(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                fis.close();
            }
        }
        return s;
    }
```
### 4.运行程序并截图
### 5.用git push提交更改的文件
# 实验结果
### 往文件写入内容的截图：
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/lab5_1.png)
### 读出文件内容的截图：
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/lab5_2.png)
### 查看文件
![image](https://github.com/xiaoshanshanlin/android-labs-2018/blob/master/soft1606081301233/lab5_3.png)
# 实验体会
### 1.本次实验是实现对项目产生的文件的存储，我用的是简单的文件内部存储,把数据存入test.txt文件，然后读取写入的内容；
### 2.最开始真的是无从下手，因为之前的java真的学得很一般，所以这次为了实现文件存储，翻查了不少资料，最后勉强完成本次实验的最基本要求；
### 3.通过本次实验对文件内部存储有了一些了解，虽然每次都要弄很久才做出来，但是又多学了一些知识。
