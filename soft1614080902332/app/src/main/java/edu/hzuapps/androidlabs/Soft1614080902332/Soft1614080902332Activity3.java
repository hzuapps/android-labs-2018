package edu.hzuapps.androidlabs.Soft1614080902332;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Soft1614080902332Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902332_activity3);

        final Soft1614080902332Activity3 thisActivity = this;

        final Button btn3 = (Button) findViewById(R.id.button3);
        final Button btn2 = (Button) findViewById(R.id.button2);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btn3)) {
                    Intent intent = new Intent(thisActivity,Soft1614080902332Activity1.class);
                    thisActivity.startActivity(intent);
                }
            }
        });

        // 保存失物信息
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.equals(btn2)) {
                    thisActivity.saveObject();
                }
            }
        });

    }

    // 保存失物信息
    private void saveObject(){
        String name = ((EditText) findViewById(R.id.editText1)).getText().toString();
        String time = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String place = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String phone = ((EditText) findViewById(R.id.editText4)).getText().toString();

        // 插入新记录
        ContentValues lostObject = new ContentValues();

        lostObject.put(Soft1614080902332Activity4.NAME, name);
        lostObject.put(Soft1614080902332Activity4.TIME, time);
        lostObject.put(Soft1614080902332Activity4.PLACE, place);
        lostObject.put(Soft1614080902332Activity4.PHONE, phone);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(Soft1614080902332Activity4.CONTENT_URI, lostObject);

        Toast.makeText(getBaseContext(),
                "上传成功！ \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showObjectInfo("", "", "", ""); // 清除内容
    }

    private void showObjectInfo(String name, String time, String place, String phone) {
        ((EditText) findViewById(R.id.editText1)).setText(name);
        ((EditText) findViewById(R.id.editText2)).setText(time);
        ((EditText) findViewById(R.id.editText3)).setText(place);
        ((EditText) findViewById(R.id.editText4)).setText(phone);
    }

}
