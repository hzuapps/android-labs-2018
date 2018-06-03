package hzu.soft1508081001217.reader;


import java.io.File;

public class SubFile {

    private File file =null ;//封装一个File类，用于接收传进构造方法中的File类

    public SubFile(File file) {//构造方法
        this.file = file ;//本类中的file赋值为传进来的file
    }

    public File getFile() {//getter方法，返回File类
        return this.file;//返回本类中的file对象
    }

    @Override
    public String toString() {
        String str = null; //声明一个字符串用来返回值
        if(file.isDirectory()) {//是文件夹
            str = "[文件夹]" + file.getName();
        }else {//是文件
            if(file.getName().lastIndexOf(".txt")>-1) {//这里是过滤掉别的文件，做文件浏览器，可以去掉
                str = "[文件]" + file.getName();//赋值"[文件]"+文件名字
            }
        }
        return str;//返回该字符串
    }
}