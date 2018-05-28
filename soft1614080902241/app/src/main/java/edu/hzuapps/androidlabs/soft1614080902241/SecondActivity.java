package edu.hzuapps.androidlabs.soft1614080902241;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {
    private ImageButton button1_2;
    private TextView zhichu;
    private double sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1_2=(ImageButton) findViewById(R.id.imagebutton_01_02);

        button1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1_2=new Intent(SecondActivity.this,thirdActivity.class);
                startActivityForResult(intent1_2,1);
            }
        });
        zhichu=findViewById(R.id.textview_zhichu);

    }
     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            String s=data.getStringExtra("data");
            if(!s.isEmpty()) {
                sum += Double.parseDouble(s);
                zhichu.setText("¥ " + sum);
                write(s);
            }
            refreshHistoricalRecord(s);
        }
        initHistoricalRecord();
    }

    private void refreshHistoricalRecord(String msg)  //刷新一下记录
    {
        if(msg==null) return;

        TextView textView = (TextView) findViewById(R.id.textview_jilu);
        String s = textView.getText().toString();
        java.util.Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate=df.format(c.getTime());
        textView.setText(s+"\n["+formattedDate+"] 消费 ¥  "+msg);
    }
    private void initHistoricalRecord()  //初始化记录
    {
        TextView textView = (TextView) findViewById(R.id.textview_jilu);
        String s = read();
        if(s!=null)
            refreshHistoricalRecord(s);
    }

    public String read() {   //读入存储数据
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

    public void write(String msg){   //写出存储数据
        // 步骤1：获取输入值
        if(msg == null) return;
        try {
            // 步骤2:创建一个FileOutputStream对象,MODE_APPEND追加模式
            msg += read();  //前面的也读进来
            FileOutputStream fos = openFileOutput("storage.txt", MODE_APPEND);
            // 步骤3：将获取过来的值放入文件
            fos.write(msg.getBytes());
            // 步骤4：关闭数据流
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String NumberFormat(double num){//转换数字格式
        NumberFormat number_format=NumberFormat.getInstance(Locale.CHINA);
        return number_format.format(num);
    }

}
