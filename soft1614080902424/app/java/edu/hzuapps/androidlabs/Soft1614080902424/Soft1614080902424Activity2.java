package edu.hzuapps.androidlabs.Soft1614080902424;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Soft1614080902424Activity2 extends AppCompatActivity{
    private Button mButtonDisplay;
    private Spinner mEditTextContent1;
    private EditText mEditTextContent5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_1614080902424_activity2);
        Button send = (Button) findViewById(R.id.send);
        mEditTextContent1 = (Spinner) findViewById(R.id.kg);

       send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity3.class);
                startActivity(intent);
            }
        });

       Button get = (Button) findViewById(R.id.get);

       get.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity4.class);
                startActivity(intent);
            }
        });
        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity5.class);
                startActivity(intent);
            }
        });
        Button yes = (Button) findViewById(R.id.yes);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1614080902424Activity2.this, Soft1614080902424Activity5.class);
                startActivity(intent);
            }
        });

        mButtonDisplay = (Button) findViewById(R.id.submit);
        mButtonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //从内部存储读取数据
                String s = getContent();
                Toast.makeText(Soft1614080902424Activity2.this, s, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private String getContent() {
        String s = null;
        FileInputStream fis = null;
        try {
            //通过该方法从内部存储中的edit_data.txt文件中读取数据
            fis = this.openFileInput("edit_data.txt");
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s = new String(buf, 0, len, "UTF-8");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }

}
