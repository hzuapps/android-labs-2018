package androidlabs.hzuapps.edu.soft1614080902335;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Soft1614080902335Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq5);

        final Soft1614080902335Activity4 thisActivity = this;

        // 保存图书信息
        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveBook();
            }
        });

        // 加载下一本书
        findViewById(R.id.button_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.showNextBook();
            }
        });
    }

    // 保存图书信息
    private void saveBook() {
        String id = ((EditText) findViewById(R.id._id)).getText().toString();
        String name = ((EditText) findViewById(R.id._name)).getText().toString();
        String sex = ((EditText) findViewById(R.id._sex)).getText().toString();
        String area = ((EditText) findViewById(R.id._area)).getText().toString();

        // 插入新记录
        ContentValues user = new ContentValues();
        user.put(UserInformationProvider._ID, id);
        user.put(UserInformationProvider.NAME, name);
        user.put(UserInformationProvider.Sex, sex);
        user.put(UserInformationProvider.Area, area);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(UserInformationProvider.CONTENT_URI, user);

        Toast.makeText(getBaseContext(), //
                "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();

        this.showBookInfo("", "","",""); // 清除内容
    }

    private void showBookInfo(String id, String name, String sex,String area) {
        ((EditText) findViewById(R.id._id)).setText(id);
        ((EditText) findViewById(R.id._name)).setText(name);
        ((EditText) findViewById(R.id._sex)).setText(sex);
        ((EditText) findViewById(R.id._area)).setText(area);
    }

    // 显示下一用户
    private void showNextBook() {
        Cursor c = getContentResolver() // 执行查询
                .query(UserInformationProvider.CONTENT_URI, null, null, null, null);

        // 随机取1条记录
        int random = (new Random()).nextInt(10);

        if (c.moveToFirst()) {
            String id = "";
            String name = "";
            String sex = "";
            String area = "";
            int count = 1;
            do {
                id = c.getString(c.getColumnIndex(UserInformationProvider._ID));
                name = c.getString(c.getColumnIndex(UserInformationProvider.NAME));
                sex = c.getString(c.getColumnIndex(UserInformationProvider.Sex));
                area = c.getString(c.getColumnIndex(UserInformationProvider.Area));
                if (count++ == random) {
                    break;
                }
            } while (c.moveToNext());
            // 显示在界面上
            this.showBookInfo(id, name, sex , area);
        } else {
            Toast.makeText(getBaseContext(), //
                    "没有可显示的图书!", Toast.LENGTH_LONG).show();
        }
    }
}
