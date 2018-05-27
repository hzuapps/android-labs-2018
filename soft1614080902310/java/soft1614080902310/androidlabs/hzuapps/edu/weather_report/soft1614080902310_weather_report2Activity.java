package soft1614080902310.androidlabs.hzuapps.edu.weather_report;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class soft1614080902310_weather_report2Activity extends AppCompatActivity {
    private String filename="City_name.txt";
    private Button Bt2;
    private Button Bt3;
    private Button BBJ;
    private  Button BSH;
    private EditText Et1;
    private TextView mTvContent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902310_weather_report2);
        BBJ=findViewById(R.id.B_bj);
        BSH=findViewById(R.id.B_sh);
        Bt2=findViewById(R.id.bt2);
        Bt3=findViewById(R.id.bt3);
        Et1=findViewById(R.id.et1);
        mTvContent=findViewById(R.id.tv2);

        Bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(Et1.getText().toString());
            }
        });

        Bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mTvContent.setText(read());
            }
        });

        BSH.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


               Intent intent= new Intent(soft1614080902310_weather_report2Activity.this,soft1614080902310weather_report1Activity.class);
                String et1Str = BSH.getText().toString();
                intent.putExtra("et1", et1Str);
               startActivity(intent);

            }
        });
        BBJ.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {


                Intent intent= new Intent(soft1614080902310_weather_report2Activity.this,soft1614080902310weather_report1Activity.class);
                String et1Str = BBJ.getText().toString();
                intent.putExtra("et1", et1Str);
                startActivity(intent);
            }
        });

    }


    private void save(String content){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=openFileOutput(filename,MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    private String read(){
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=openFileInput(filename);
            byte[] buff=new byte[1024];
            StringBuilder sb=new StringBuilder("");
            int len=0;
            while((len=fileInputStream.read(buff)) >0){
                sb.append(new String(buff,0,len));

            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}
