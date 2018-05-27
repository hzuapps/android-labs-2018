package com.example.administrator.soft1614080902219;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64OutputStream;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class bookcase extends Activity {
   // public static final String FILENAME = "setting.set";
     private Button push;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcase);
        push=(Button)this.findViewById(R.id.tobook);
           // String content =null ;
            try {
                FileInputStream fis = openFileInput("setting.set");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                 byte[] content = baos.toByteArray();
                push.setText(new String(content,"UTF-8"));
                fis.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


