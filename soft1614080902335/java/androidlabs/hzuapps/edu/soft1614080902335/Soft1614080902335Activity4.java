package androidlabs.hzuapps.edu.soft1614080902335;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Soft1614080902335Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq4);

        final Soft1614080902335Activity4 thisActivity = this;

        this.showBook();

        final Button btnOpen = (Button) findViewById(R.id.button_change);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Soft1614080902335Activity3.class);
                thisActivity.startActivity(intent);
            }
        });
    }

    // 显示用户信息
    private void showBook() {
        Cursor c = getContentResolver() // 执行查询
                .query(UserInformationProvider.CONTENT_URI, null, null, null, null);

        if(c.moveToFirst()) {

            String id = "";
            String name = "";
            String sex = "";
            String area = "";
            id = c.getString(c.getColumnIndex(UserInformationProvider._ID));
            name = c.getString(c.getColumnIndex(UserInformationProvider.NAME));
            sex = c.getString(c.getColumnIndex(UserInformationProvider.Sex));
            area = c.getString(c.getColumnIndex(UserInformationProvider.Area));


            ((TextView) findViewById(R.id.profile_name)).setText(name);
            ((TextView) findViewById(R.id.profile_sex)).setText(sex);
            ((TextView) findViewById(R.id.profile_area)).setText(area);
        }
        }
}

