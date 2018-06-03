package hzu.soft1508081001217.reader;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class FileBrowserActivity extends Activity {

	private ListView fileList = null ;//显示文件的列表
	private ArrayAdapter adapter = null ;//适配器

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_browser_layout);
		setTitle("选择您的文件名");//更改标题
		fileList = (ListView)findViewById(R.id.file_list);//绑定组件
		openFile(adapter, fileList);//打开文件和配置适配器，显示在列表上

		fileList.setOnItemClickListener(new OnItemClick());//文件列表的子项单击监听处理

	}

	/**
	 * 此方法用于装载数据
	 * @param adapter ArrayAdapter适配器
	 * @param list 要显示的ListView
	 */
	public void openFile(ArrayAdapter adapter, ListView list){
		List<SubFile> ndata = new ArrayList<SubFile>();//用于存放文件名，加载到适配器中
		String strPath = getIntent().getStringExtra("filename");//获取上个界面传来的值
		if(strPath == null){//没有有数据
			strPath = Environment.getExternalStorageDirectory().getPath();//根目录
		}
		File pathFile = new File(strPath);//要显示的目录
		if(pathFile != null){//有这个目录
			File[] files = pathFile.listFiles();//获取目录下的所有文件夹与文件
			for(File file : files){//全部遍历
				if(new SubFile(file).toString()!=null){//如果不是筛选掉的文件
					ndata.add(new SubFile(file));//添加到mdata对象中
				}
			}
			//配置适配器
			adapter = new ArrayAdapter(FileBrowserActivity.this, android.R.layout.simple_list_item_1, ndata);
			list.setAdapter(adapter);//设置列表的适配去
		}else{//空文件处理
			Toast.makeText(FileBrowserActivity.this , "查找文件为空！", Toast.LENGTH_SHORT).show();
		}
	}

	//文件列表子项的单击监听处理
	private class OnItemClick implements AdapterView.OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			SubFile subFile = (SubFile) parent.getAdapter().getItem(position);//获取子项存储的SubFile类，该类可以获取到子项所在路径
			String filename = subFile.getFile().getPath();//filename赋值为subFile对象中的路径
			Intent intent = null;//声明Intent类，用于跳转界面
			if(subFile.getFile().isDirectory()){//如果路径为文件夹
				intent = new Intent(FileBrowserActivity.this, FileBrowserActivity.class);//还是跳转到改Activity
				intent.putExtra("filename", filename);//传入路径
			}else{//文件的话
				intent = new Intent(FileBrowserActivity.this, MainActivity.class);//跳转到主界面
				writeData(filename);//调用writeData方法，该方法用于写入数据
			}
			startActivity(intent);//跳转界面
			finish();//清除界面
		}

	}

	/**
	 * 该方法用于写入数据
	 * @param str 要写入的值
	 */

	public void writeData(String str){
		File file = new File(MainActivity.MYPATH+File.separator+"bookPath.txt");//要操作的文件
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));//用BufferedWriter类追加写入数据
			bw.append(str);//追加数据
			bw.newLine();//新的一行
			bw.close();//关闭BufferedWrite类
		} catch (IOException e) {//抛出异常
			e.printStackTrace();
		}
	}

}