package androidlabs.hzuapps.edu.com1614080901103;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Com1614080901103Activity extends AppCompatActivity {

    private ImageView imageView;
    private EditText textBox;
    private static final int READ_BLOCK_SIZE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901103);

        imageView = (ImageView) findViewById(R.id.textview_01);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901103Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        textBox=(EditText) findViewById(R.id.txtText1);
        Button saveBtn=(Button)findViewById(R.id.btnSave);
        Button loadBtn=(Button)findViewById(R.id.btnLoad);

        saveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str=textBox.getText().toString();
                try
                {
                    FileOutputStream fOut=
                            openFileOutput("textfile.txt",MODE_WORLD_READABLE);
                    OutputStreamWriter osw=new OutputStreamWriter(fOut);
                    //-------将字符串写入文件----
                    osw.write(str);
                    osw.flush();
                    osw.close();

                    //-------显示文件被保存的消息----
                    Toast.makeText(getBaseContext(),"File saved successfully",
                            Toast.LENGTH_SHORT).show();
                    //-------清空EditText----
                    textBox.setText("");
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try
                {
                    FileInputStream fIn=
                            openFileInput("textfile.txt");
                    InputStreamReader isr=new InputStreamReader(fIn);

                    char[] inputBuffer=new char[READ_BLOCK_SIZE];
                    String s="";

                    int charRead;
                    while((charRead=isr.read(inputBuffer))>0)
                    {
                        //-------将字符串转换成字符串------
                        String readString=
                                String.copyValueOf(inputBuffer,0,charRead);
                        s+=readString;

                        inputBuffer=new char[READ_BLOCK_SIZE];
                    }
                    //-------将EditText设置为已读取的文本----
                    textBox.setText(s);
                    Toast.makeText(getBaseContext(),"File load successfully!",
                            Toast.LENGTH_SHORT).show();
                }
                catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        });
    }
}
