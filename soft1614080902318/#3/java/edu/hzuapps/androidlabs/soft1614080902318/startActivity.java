package edu.hzuapps.androidlabs.soft1614080902318;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        }
    }

}
