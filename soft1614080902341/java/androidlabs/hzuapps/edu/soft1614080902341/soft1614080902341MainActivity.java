package androidlabs.hzuapps.edu.soft1614080902341;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class soft1614080902341MainActivity extends ActionBarActivity {
    private Button myBtn_one;
    private Button myBtn_tow;
    private Button myBtn_thr;
    private Button img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902341_main);
        myBtn_one = (Button) findViewById(R.id.but_one);
        myBtn_tow = (Button) findViewById(R.id.but_tow);
        myBtn_thr = (Button) findViewById(R.id.but_thr);
        img = (Button)findViewById(R.id.img);
        //通过实现onclicklistener接口的类的对象
        myBtn_one.setOnClickListener(new MainActivity());
        myBtn_tow.setOnClickListener(new MainActivity());
        myBtn_thr.setOnClickListener(new MainActivity());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(soft1614080902341MainActivity.this, ImageActivity.class); //设置跳转的Activity
                soft1614080902341MainActivity.this.startActivity(intent);
            }
        });

    }
//        myBtn_one.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
//                Intent intent=new Intent();
//                intent.setClass(soft1614080902341MainActivity.this, jiandaoMainActivity.class); //设置跳转的Activity
//                soft1614080902341MainActivity.this.startActivity(intent);
//            }
//        });
//        myBtn_tow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
//                Intent intent=new Intent();
//                intent.setClass(soft1614080902341MainActivity.this, shitouMainActivity.class); //设置跳转的Activity
//                soft1614080902341MainActivity.this.startActivity(intent);
//            }
//        });
//        myBtn_thr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
//                Intent intent=new Intent();
//                intent.setClass(soft1614080902341MainActivity.this, buMainActivity.class); //设置跳转的Activity
//                soft1614080902341MainActivity.this.startActivity(intent);
//            }
//        });
        private class MainActivity implements View.OnClickListener {
            @Override
            public void onClick(View v){
                EditText editText1 =(EditText)findViewById(R.id.text);
                String name = editText1.getText().toString();
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(soft1614080902341MainActivity.this,"请输入玩家姓名",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Button b = (Button)findViewById(v.getId());
                    String buttontext = b.getText().toString();
                    String fileName = "data.txt";
                    String content = name+"出"+buttontext;
                    FileOutputStream fos;
                    try{
                        fos = openFileOutput(fileName,MODE_APPEND);
                        fos.write(content.getBytes());
                        fos.close();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    Intent intent = new Intent();
                    switch (v.getId()) {
                        case R.id.but_one:
                            intent.setClass(soft1614080902341MainActivity.this, jiandaoMainActivity.class); //设置跳转的Activity
                            soft1614080902341MainActivity.this.startActivity(intent);
                            break;
                        case R.id.but_tow:
                            intent.setClass(soft1614080902341MainActivity.this, shitouMainActivity.class); //设置跳转的Activity
                            soft1614080902341MainActivity.this.startActivity(intent);
                            break;
                        case R.id.but_thr:
                            intent.setClass(soft1614080902341MainActivity.this, buMainActivity.class); //设置跳转的Activity
                            soft1614080902341MainActivity.this.startActivity(intent);
                            break;

                    }
                }
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soft1614080902341_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
