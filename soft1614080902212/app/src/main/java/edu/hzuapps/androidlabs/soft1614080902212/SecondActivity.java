package edu.hzuapps.androidlabs.soft1614080902212;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SecondActivity extends AppCompatActivity {

    private Button Button;
    private EditText Edit;
    private String sr;
    private TextView cxjl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button = (Button) findViewById(R.id.button2);
        Edit = (EditText) findViewById(R.id.sr1);
        cxjl = (TextView)findViewById(R.id.cxjl);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sr = Edit.getText().toString();
                write(sr);
                String msg = read();
                if (sr.equals("")) {
                    Toast.makeText(SecondActivity.this, "请输入您要查询的时间段", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    startActivity(intent);

                }
                String record = cxjl.getText().toString();
                cxjl.setText(record+"\n"+msg);
            }
        });

    }
        public String read() {
            try {
                FileInputStream inStream = this.openFileInput("message.txt");
                byte[] buffer = new byte[1024];
                int hasRead = 0;
                StringBuilder sb = new StringBuilder();
                while ((hasRead = inStream.read(buffer)) != -1) {
                    sb.append(new String(buffer, 0, hasRead));
                }
                inStream.close();
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public void write(String msg){

            if (msg == null) return;
            try {

                FileOutputStream fos = openFileOutput("message.txt",
                        MODE_PRIVATE
                );

                fos.write(msg.getBytes());

                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
