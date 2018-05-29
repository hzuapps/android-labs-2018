package soft1614080902342.androidlabs.hzuapps.edu.tripmanager;
//用来显示开始的界面

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private String filename="test";
    private EditText et;
    private TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setContentView(R.layout.my_layout);
        findViewById(R.id.btnStarAnotherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Soft1614080902342.class));
            }
        });
        et=(EditText) findViewById(R.id.et);
        show = findViewById(R.id.show);

        findViewById(R.id.writeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
                    osw.write(et.getText().toString());
                    osw.flush();
                    fos.flush();
                    osw.close();
                    fos.close();
                    Toast.makeText(getApplicationContext(),"写入完成",Toast.LENGTH_SHORT).show();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.readBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fis = openFileInput(filename);
                    InputStreamReader is = new InputStreamReader(fis,"UTF-8");
                    char input[]=new char [fis.available()];
                    is.read(input);
                    is.close();
                    fis.close();
                    String readed = new String(input);
                    show.setText(readed);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("test.json"),"UTF-8");
            BufferedReader br= new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while((line=br.readLine())!=null){
                builder.append(line);
            }
            JSONObject root = new JSONObject(builder.toString());
            System.out.println("cat="+root.getString("cat"));
            JSONArray array = root.getJSONArray("languages");
            for(int i=0;i<array.length();i++){
                JSONObject lan = array.getJSONObject(i);
                System.out.println("---------------------");
                System.out.println("id="+lan.getInt("id"));
                System.out.println("name="+lan.getString("name"));
                System.out.println("ide="+lan.getString("ide"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
