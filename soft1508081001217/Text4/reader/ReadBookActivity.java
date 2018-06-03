package hzu.soft1508081001217.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class ReadBookActivity extends Activity {

    private TextView bookContent = null ;//显示文本的组件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_book_layout);

        bookContent = (TextView)findViewById(R.id.book_content);//绑定文本组件
        bookContent.setMovementMethod(ScrollingMovementMethod.getInstance());//给文本组件加入滚动条

        String txtFilePath = getIntent().getStringExtra("txtFilePath");//获取传进来的文本路径
        if(txtFilePath != null){//如果有传进数据
            int index = txtFilePath.lastIndexOf(File.separator);//用来截取文本的名字的第一个参数
            String name = txtFilePath.substring(index+1, txtFilePath.length());//截取文本名字
            setTitle(name);//设置标题为文本名字
            try {
                FileInputStream fr = new FileInputStream(txtFilePath);//文件输出流
                BufferedReader br = new BufferedReader(new InputStreamReader(fr, "utf-8"));//缓冲读取文件数据
                String line = "" ;//记录每一行数据
                String content = "" ;
                while((line = br.readLine()) != null){//如果还有下一行数据
                    content += line + "\n" ;
                }
                bookContent.setText(content);;//追加显示数据
                br.close();//关闭文件输出流
                fr.close();//关闭缓冲区
            } catch (IOException e) {//抛出异常
                Toast.makeText(ReadBookActivity.this, "没有此文件！", Toast.LENGTH_SHORT).show();//提示异常
                finish();//直接关闭界面
            }
        }
    }
}