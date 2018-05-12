package edu.hzuapps.androidlabs.soft1614080902221;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private EditText etText = null;
    private RadioGroup sex_rg = null;
    private RadioGroup gameCharacters = null;
    private TextView text2 = null;
    private Button okButton = null;
    private Button resetButton = null;
    private Button goButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();// 隐藏ActionBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//remove notification bar  即全屏
        setContentView(R.layout.activity_2);
        initView();
    }

    private void initView() {
        etText = (EditText) findViewById(R.id.edText1);
        sex_rg = (RadioGroup) findViewById(R.id.sex_rg);
        gameCharacters = (RadioGroup) findViewById(R.id.gameCharacters);
        text2 = (TextView) findViewById(R.id.text2);
        okButton = (Button) findViewById(R.id.okButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        goButton = (Button) findViewById(R.id.goButton);
        goButton.setVisibility(View.INVISIBLE);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPersonName = etText.getText().toString();

                int sex = sex_rg.getCheckedRadioButtonId();
                RadioButton sex_rb = (RadioButton) findViewById(sex);
                String strSex = sex_rb.getText().toString();

                int gameName = gameCharacters.getCheckedRadioButtonId();
                RadioButton gameName_rb = (RadioButton) findViewById(gameName);
                String strGameName = gameName_rb.getText().toString();

                if (strPersonName.equals("")) {
                    goButton.setVisibility(View.INVISIBLE);
                    Toast.makeText(Activity2.this, "请输入您的名称", Toast.LENGTH_SHORT).show();
                    //text2.setText("请输入您的名称！！！");
                } else {
                    goButton.setVisibility(View.VISIBLE);
                    text2.setText("亲爱的" + strPersonName + "玩家，\n" + "性别:" + strSex + "\n" +
                            "你选择的角色：" + strGameName);
                }


            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etText.setText("");

                RadioButton sex_rb = (RadioButton) findViewById(R.id.male_rb);
                sex_rb.setChecked(true);

                RadioButton gameName_rb = (RadioButton) findViewById(R.id.muLing);
                gameName_rb.setChecked(true);

                text2.setText("");
                goButton.setVisibility(View.INVISIBLE);


            }
        });


    }


}
