package edu.hzuapps.androidlabs.Com1614080901239;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Com1614080901239Activity extends AppCompatActivity implements View.OnClickListener {
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button numA;
    private Button numB;
    private Button numC;
    private Button numD;
    private Button numE;
    private Button numF;
    private Button plus_btn;
    private Button subtract_btn;
    private Button multiply_btn;
    private Button divide_btn;
    private Button equal_btn;
    private Button dot_btn;
    private Button percent_btn;
    private Button delete_btn;
    private Button ac_btn;
    private Button HEX_btn;
    private Button DEC_btn;
    private Button OCT_btn;
    private Button BIN_btn;
    private Button QWORD_btn;
    private Button Lsh_btn;
    private Button Rsh_btn;
    private Button Or_btn;
    private Button Xor_btn;
    private Button Not_btn;
    private Button And_btn;
    private EditText mResultText;
    private Button picture_btn;
    private String existedText = "";
    private boolean isCounted = false;
    private boolean startWithOperator = false;
    private boolean startWithSubtract = false;
    private boolean noStartWithOperator = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modle);

        initView();
        initEvent();
        new pictureThread("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1527601939&di=2a4b28667c41ebb7b2a07f29c6c57f7b&src=http://pic.90sjimg.com/back_pic/u/00/38/54/05/55fbe8a6d099d.jpg",mResultText,new Handler()).start();


    }

    private void initView() {
        num0 = (Button) findViewById(R.id.num_zero);
        num1 = (Button) findViewById(R.id.num_one);
        num2 = (Button) findViewById(R.id.num_two);
        num3 = (Button) findViewById(R.id.num_three);
        num4 = (Button) findViewById(R.id.num_four);
        num5 = (Button) findViewById(R.id.num_five);
        num6 = (Button) findViewById(R.id.num_six);
        num7 = (Button) findViewById(R.id.num_seven);
        num8 = (Button) findViewById(R.id.num_eight);
        num9 = (Button) findViewById(R.id.num_nine);
        numA = (Button) findViewById(R.id.num_A);
        numB = (Button) findViewById(R.id.num_B);
        numC = (Button) findViewById(R.id.num_C);
        numD = (Button) findViewById(R.id.num_D);
        numE = (Button) findViewById(R.id.num_E);
        numF = (Button) findViewById(R.id.num_F);
        plus_btn = (Button) findViewById(R.id.plus_btn);
        subtract_btn = (Button) findViewById(R.id.subtract_btn);
        multiply_btn = (Button) findViewById(R.id.multiply_btn);
        divide_btn = (Button) findViewById(R.id.divide_btn);
        equal_btn = (Button) findViewById(R.id.equal_btn);
        dot_btn = (Button) findViewById(R.id.dot_btn);
        percent_btn = (Button) findViewById(R.id.percent_btn);
        delete_btn = (Button) findViewById(R.id.delete_btn);
        ac_btn = (Button) findViewById(R.id.ac_btn);
        HEX_btn = (Button) findViewById(R.id.HEX_btn);
        DEC_btn = (Button) findViewById(R.id.DEC_btn);
        OCT_btn = (Button) findViewById(R.id.OCT_btn);
        BIN_btn = (Button) findViewById(R.id.BIN_btn);
        Lsh_btn = (Button) findViewById(R.id.Lsh_btn);
        Rsh_btn = (Button) findViewById(R.id.Rsh_btn);
        Or_btn = (Button) findViewById(R.id.Or_btn);
        Xor_btn = (Button) findViewById(R.id.Xor_btn);
        Not_btn = (Button) findViewById(R.id.Not_btn);
        And_btn = (Button) findViewById(R.id.And_btn);
        journal_btn = (Button) findViewById(R.id.journal_btn);
        picture_btn = (Button) findViewById(R.id.picture_btn);

        mResultText = (EditText) findViewById(R.id.result_text);
        existedText = mResultText.getText().toString();

    }

    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        plus_btn.setOnClickListener(this);
        subtract_btn.setOnClickListener(this);
        multiply_btn.setOnClickListener(this);
        divide_btn.setOnClickListener(this);
        equal_btn.setOnClickListener(this);

        dot_btn.setOnClickListener(this);
        percent_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
        ac_btn.setOnClickListener(this);
        journal_btn.setOnClickListener(this);
        picture_btn.setOnClickListener(this);

    }
    public void onClick(View v) {

        switch (v.getId()) {
            /**
             * 数字
             */
            case R.id.num_zero:
                existedText = "0";
                mResultText.setText(existedText);
                break;
            case R.id.num_one:
                existedText = "1";
                mResultText.setText(existedText);
                break;
            case R.id.num_two:
                existedText = "2";
                mResultText.setText(existedText);
                break;
            case R.id.num_three:
                existedText = "3";
                mResultText.setText(existedText);
                break;
            case R.id.num_four:
                existedText = "4";
                mResultText.setText(existedText);
                break;
            case R.id.num_five:
                existedText = "5";
                mResultText.setText(existedText);
                break;
            case R.id.num_six:
                existedText = "6";
                mResultText.setText(existedText);
                break;
            case R.id.num_seven:
                existedText = "7";
                mResultText.setText(existedText);
                break;
            case R.id.num_eight:
                existedText = "8";
                mResultText.setText(existedText);
                break;
            case R.id.num_nine:
                existedText = "9";
                mResultText.setText(existedText);
                break;
            case R.id.equal_btn:
                saveTextIntoInternalStorage(existedText);
                break;
            case R.id.journal_btn:
                Intent intent = new Intent(thisActivity, journal.class);
                thisActivity.startActivity(intent);
                break;
            case R.id.picture_btn:
                Intent intent1 = new Intent(thisActivity, journal.class);
                thisActivity.startActivity(intent1);
                break;
        }
    }

    private void saveTextIntoInternalStorage(String text) {

        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("text",text);
        editor.apply();
    }



}

        }
    }
        }

