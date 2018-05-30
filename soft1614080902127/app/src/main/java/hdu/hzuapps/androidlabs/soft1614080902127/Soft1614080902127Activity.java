package edu.hzuapps.androidlabs.soft1614080902127;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import java.io.InputStream;
import java.util.Scanner;


public class Soft1614080902127Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902127);
        load();
    }
    public void onClick(View view)
    {
        startActivity(new Intent(".SecondActivity"));
    }
    public void load() {
        Resources resources = this.getResources();
        EditText text1 = (EditText)findViewById(R.id.username);
        InputStream StdInfo = null;


        String [] editTexts = new String[6];


        try {
            // 用InputStream方式读取保存在 /raw/data.txt 下的原始文件
            StdInfo = resources.openRawResource(R.raw.data);

            if (StdInfo.available() == 0){
                text1.setText("error");
                return;
            }
            if(StdInfo != null) {
                //用utf-8读取文件
                Scanner input = new Scanner(StdInfo, "utf-8");
                String str2="";
                str2 += text1.getText();
                while (input.hasNext()) {

                    String str1 = input.next();

                    str2 += str1;
                }
                text1.setText(str2);
            }


        } catch (Exception e) {
            text1.setText("error");
        }
    }
}
