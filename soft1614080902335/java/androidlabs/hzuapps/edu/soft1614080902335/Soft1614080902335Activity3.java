package androidlabs.hzuapps.edu.soft1614080902335;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Soft1614080902335Activity3 extends AppCompatActivity {

    static boolean flag=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902335_qq5);

        final Soft1614080902335Activity3 thisActivity = this;

        final Button btnOpen = (Button) findViewById(R.id.button_save);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                    thisActivity.saveUser();
                    Intent intent = new Intent(thisActivity,Soft1614080902335Activity4.class);
                    thisActivity.startActivity(intent);
            }
        });
    }
    private void saveUser() {

        String name = ((EditText) findViewById(R.id._name)).getText().toString();
        String sex = ((EditText) findViewById(R.id._sex)).getText().toString();
        String area = ((EditText) findViewById(R.id._area)).getText().toString();

        ContentValues user = new ContentValues();
        user.put(UserInformationProvider.NAME, name);
        user.put(UserInformationProvider.Sex, sex);
        user.put(UserInformationProvider.Area, area);

        if(flag) {
            Uri uri = getContentResolver() // 执行插入操作
                    .insert(UserInformationProvider.CONTENT_URI, user);

            Toast.makeText(getBaseContext(), //
                    "保存成功! \n" + uri.toString(), Toast.LENGTH_LONG).show();
            flag=false;
        }

        // 更新记录
        else {
            int uri = getContentResolver() // 执行插入操作
                    .update(UserInformationProvider.CONTENT_URI,user,"", new String[]{});

            Toast.makeText(getBaseContext(), //
                    "保存成功! \n" , Toast.LENGTH_LONG).show();
        }
    }
}
