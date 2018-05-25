package edu.huzapps.androidlabs.soft1614080902222;

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

public class Main3Activity extends AppCompatActivity {
   private TextView tv;
    private EditText ed;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = ed.getText().toString();
                write(s);
                String msg = read();
                if (s.equals("")) {
                    Toast.makeText(Main3Activity.this, "请输入您要搜索的内容", Toast.LENGTH_SHORT).show();

                }
                String record = tv.getText().toString();
                tv.setText(record+"\n"+msg);
            }
        });

    }
    public void init()
    {
        tv=(TextView)findViewById(R.id.kk);
          ed=(EditText)findViewById(R.id.sousuo);
         btn=(Button)findViewById(R.id.kk1);
    }
    public String read() {
        try {
            FileInputStream inStream = this.openFileInput("record.txt");
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
    /*
    数据写入，写入最后一次观看的记录
     */
    public void write(String msg){
        if(msg == null) return;
        try {
            FileOutputStream fos = openFileOutput("record.txt",
                    MODE_PRIVATE);
            fos.write(msg.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
