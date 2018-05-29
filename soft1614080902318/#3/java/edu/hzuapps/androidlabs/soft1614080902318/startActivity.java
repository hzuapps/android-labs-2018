package edu.hzuapps.androidlabs.soft1614080902318;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class startActivity extends AppCompatActivity {

    private Button button;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioButton stone1;
    private RadioButton stone2;
    private RadioButton scissors1;
    private RadioButton scissors2;
    private RadioButton cloth1;
    private RadioButton cloth2;
    private TextView result_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        button=(Button)findViewById(R.id.startButtonId);
        radioGroup1= (RadioGroup)findViewById(R.id.radioGroup1Id);
        radioGroup2= (RadioGroup)findViewById(R.id.radioGroup2Id);
        stone1= (RadioButton)findViewById(R.id.stone1Id);
        stone2= (RadioButton)findViewById(R.id.stone2Id);
        scissors1=(RadioButton)findViewById(R.id.scissors1Id);
        scissors2=(RadioButton)findViewById(R.id.scissors2Id);
        cloth1=(RadioButton)findViewById(R.id.cloth1Id);
        cloth2=(RadioButton)findViewById(R.id.cloth2Id);
        result_textview=(TextView)findViewById(R.id.resultId);

        ButtonListener listerner=new ButtonListener();
        button.setOnClickListener(listerner);
    }


    class ButtonListener implements android.view.View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(radioGroup1.getCheckedRadioButtonId()==R.id.stone1Id&&radioGroup2.getCheckedRadioButtonId()==R.id.stone2Id||radioGroup1.getCheckedRadioButtonId()==R.id.scissors1Id&&radioGroup2.getCheckedRadioButtonId()==R.id.scissors2Id||radioGroup1.getCheckedRadioButtonId()==R.id.cloth1Id&&radioGroup2.getCheckedRadioButtonId()==R.id.cloth2Id){
                result_textview.setText("打成平局啦！");
            }
            else if(radioGroup1.getCheckedRadioButtonId()==R.id.stone1Id&&radioGroup2.getCheckedRadioButtonId()==R.id.scissors2Id||radioGroup1.getCheckedRadioButtonId()==R.id.stone1Id&&radioGroup2.getCheckedRadioButtonId()==R.id.cloth2Id||radioGroup1.getCheckedRadioButtonId()==R.id.scissors1Id&&radioGroup2.getCheckedRadioButtonId()==R.id.cloth2Id){
                result_textview.setText("阿狸赢啦！");
            }
            else{
                result_textview.setText("桃子赢啦！");
            }

            RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup1Id);
            RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
            String text1 = radioButton.getText().toString();

            RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.radioGroup2Id);
            RadioButton radioButton2 = (RadioButton)findViewById(radioGroup2.getCheckedRadioButtonId());
            String text2 = radioButton2.getText().toString();

            TextView text = (TextView)findViewById(R.id.resultId);
            String text3 = text.getText().toString();

            save(text1);
            save(text2);
            save(text3);
        }
    }

    public void save(String text){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("result", ContextWrapper.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
