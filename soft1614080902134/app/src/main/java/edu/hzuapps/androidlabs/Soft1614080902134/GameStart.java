package edu.hzuapps.androidlabs.wangzhe;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.io.InputStream;
import java.util.Scanner;

public class GameStart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);

        read();
    }

    public void read() {
        Resources resources = this.getResources();
        InputStream StdInfo = null;


        //绑定6个文本框
        //通过 文本框 id 来获取，并存储在 文本框数组中
        EditText tx[] = new EditText[6];
        tx[0] = (EditText)findViewById(R.id.editText1);
        tx[1] = (EditText)findViewById(R.id.editText2);
        tx[2] = (EditText)findViewById(R.id.editText3);
        tx[3] = (EditText)findViewById(R.id.editText4);
        tx[4] = (EditText)findViewById(R.id.editText5);
        tx[5] = (EditText)findViewById(R.id.editText6);

         try {
            // 用InputStream方式读取保存在 /res/test.txt 下的原始文件
             StdInfo = resources.openRawResource(R.raw.test);

            if (StdInfo.available() == 0){
                return;
            }
            if(StdInfo != null) {
                //用utf-8读取文件
                Scanner input = new Scanner(StdInfo, "utf-8");
                String str2 = "";
                str2 += tx[0].getText();
                int i=0;
                    while (input.hasNext()) {
                        String str1 = input.next();
                        str2 += str1;
                        //文本框中的数据采用 空格 来进行分割
                        if(str1==" "){
                            tx[i++].setText(str2);
                            str2 += tx[i].getText();
                        }
                    }
            }
         } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
