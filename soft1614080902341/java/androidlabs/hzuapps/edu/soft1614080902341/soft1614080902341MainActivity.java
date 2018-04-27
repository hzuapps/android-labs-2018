package androidlabs.hzuapps.edu.soft1614080902341;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class soft1614080902341MainActivity extends ActionBarActivity {
    private Button myBtn_one;
    private Button myBtn_tow;
    private Button myBtn_thr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902341_main);
        myBtn_one =(Button) findViewById(R.id.but_one);
        myBtn_tow =(Button) findViewById(R.id.but_tow);
        myBtn_thr = (Button) findViewById(R.id.but_thr);
        myBtn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent=new Intent();
                intent.setClass(soft1614080902341MainActivity.this, jiandaoMainActivity.class); //设置跳转的Activity
                soft1614080902341MainActivity.this.startActivity(intent);
            }
        });
        myBtn_tow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent=new Intent();
                intent.setClass(soft1614080902341MainActivity.this, shitouMainActivity.class); //设置跳转的Activity
                soft1614080902341MainActivity.this.startActivity(intent);
            }
        });
        myBtn_thr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 另一个Activity的完整名称 = edu.androidlabs.soft123456(包名).Soft123456Activity(类名)
                Intent intent=new Intent();
                intent.setClass(soft1614080902341MainActivity.this, buMainActivity.class); //设置跳转的Activity
                soft1614080902341MainActivity.this.startActivity(intent);
            }
        });

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
