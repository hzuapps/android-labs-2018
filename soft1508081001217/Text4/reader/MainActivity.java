package hzu.soft1508081001217.reader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView bookList = null ;//显示图书(txt)列表组件
    private Button btnAdd = null ;//追加书按钮组件
    private ArrayAdapter<String> adapter = null ;//适配器
    private List<String> data = null ; //用于存储数据，加载到适配器中
    private List<String> pathData = null ;//记录路径
    private static final int REMOVE_BOOK = Menu.FIRST;//移除书上下文菜单标识
    //程序中要使用到的路径
    public static final String MYPATH = Environment.getExternalStorageDirectory().getPath() + File.separator + "myBook";
    private int longClickPosition = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = (ListView)findViewById(R.id.book_list);//绑定组件
        btnAdd = (Button)findViewById(R.id.btn_add);//绑定组件

        createOrRead();//创建或读取文件方法，顺带显示数据

        registerForContextMenu(bookList);//为txt列表组件注册上下文菜单

        btnAdd.setOnClickListener(new OnClick());//添加图书按钮的单击监听处理
        bookList.setOnItemClickListener(new OnItemClick());//图书列表的子项单击监听处理
        bookList.setOnItemLongClickListener(new OnItemLongClick());//图书列表的子项单击监听处理

    }

    //文件的创建和读取
    public void createOrRead(){
        File dirFile = new File(MYPATH);//声明并实例化一个File类，路径为MYPATH（路径详细看上面）
        if(!dirFile.exists()){//如果文件夹不存在
            dirFile.mkdirs();//创建文件夹
        }
        File file = new File(dirFile,"bookPath.txt");//声明并实例化一个File类，父路径为dirFile，文件名为bookPath.txt
        if(!file.exists()){//如果文件不存在
            try {
                file.createNewFile();//创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{//如果文件已经存在
            try {
                FileReader fr = new FileReader(file);//声明并实例化FileReader类，路径为file
                BufferedReader br = new BufferedReader(fr);//声明并实例化BufferedFile类，缓冲读取数据
                data = new ArrayList<String>();//实例化List类，用于添加数据，加载在适配器中
                pathData = new ArrayList<String>();//记录路径
                String line = "" ;//用于存储读取到的数据

                while((line = br.readLine()) != null){//如果还有下一行数据
                    int sub = line.lastIndexOf(File.separator);//截取文件名使用
                    String strName = line.substring(sub+1, line.length());//截取到文件名
                    data.add(strName);//添加文件名
                    pathData.add(line);//添加整个文件路径
                }
                br.close();//关闭BufferedReader类
                fr.close();//关闭FileReader类
                //加载数据在适配器
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
                bookList.setAdapter(adapter);//设置适配器
            } catch (FileNotFoundException e) {//抛出异常
                e.printStackTrace();
            } catch (IOException e) {//抛出异常
                e.printStackTrace();
            }
        }
    }

    //用来监听图书列表的选项单击事件
    private class OnItemClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, ReadBookActivity.class);//用于跳转Activity使用，此处跳转到读取图书界面
            intent.putExtra("txtFilePath", pathData.get(position));//传送要打开的txt文件路径
            startActivity(intent);//跳转界面
        }

    }
    //用来监听图书列表的选项长按事件
    private class OnItemLongClick implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            longClickPosition = position;//记录长按了列表哪个子项
            return false;
        }
    }

    //用来监听添加图书按钮的单击事件
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, FileBrowserActivity.class);//跳转到文件浏览选择界面
            startActivity(intent);//跳转界面
        }

    }

    //创建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        menu.add(0, REMOVE_BOOK, 0, "移除读书");//添加菜单子项
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == REMOVE_BOOK){//移除图书处理
            removeBook();
        }
        return super.onContextItemSelected(item);
    }

    //移除图书处理
    public void removeBook(){
        try {
            data.remove(longClickPosition);//移除该项
            pathData.remove(longClickPosition);//移除该项
            FileWriter fw = new FileWriter(new File(MYPATH + File.separator + "bookPath.txt"));//设置读取文件
            BufferedWriter bw = new BufferedWriter(fw);//用BufferedWriter类写入数据
            for(String str : pathData){//遍历pathData对象
                bw.write(str);//写入数据
                bw.newLine();//新的一行
            }
            bw.close();
            //加载数据在适配器
            adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
            bookList.setAdapter(adapter);//设置适配器
        } catch (IOException e) {//抛出异常
            e.printStackTrace();
        }
    }

}