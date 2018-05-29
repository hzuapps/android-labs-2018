package edu.hzuapps.androidlabs.soft1614080902429.gs01;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends Activity implements OnClickListener {
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8,
            btn_9, btn_0, btn_jia, btn_jian, btn_dengyu, btn_clear, btn_chuyi,
            btn_chengyi, btn_dian; //各个按钮
    private EditText et_show; //显示输入数字和结果
    public int flag = 0;  //为判断是加减乘除四种运算中的哪一种设定的标志位
    private String text1 = "0",  //获得输入的第一个数
            text2 = "0";         //获得输入的第二个数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("计算器");
        //获得各个控件
        et_show = (EditText) findViewById(R.id.et_show);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_jia = (Button) findViewById(R.id.btn_jia);
        btn_jian = (Button) findViewById(R.id.btn_jian);
        btn_chengyi = (Button) findViewById(R.id.btn_chengyi);
        btn_chuyi = (Button) findViewById(R.id.btn_chuyi);
        btn_dengyu = (Button) findViewById(R.id.btn_dengyu);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_dian = (Button) findViewById(R.id.btn_dian);
        //设置监听器
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_jia.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_chengyi.setOnClickListener(this);
        btn_chuyi.setOnClickListener(this);
        btn_dian.setOnClickListener(this);
        btn_dengyu.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        switch (arg0.getId()) {
            case R.id.btn_0:
                et_show.append("0");
                break;
            case R.id.btn_1:
                et_show.append("1");
                break;
            case R.id.btn_2:
                et_show.append("2");
                break;
            case R.id.btn_3:
                et_show.append("3");
                break;
            case R.id.btn_4:
                et_show.append("4");
                break;
            case R.id.btn_5:
                et_show.append("5");
                break;
            case R.id.btn_6:
                et_show.append("6");
                break;
            case R.id.btn_7:
                et_show.append("7");
                break;
            case R.id.btn_8:
                et_show.append("8");
                break;
            case R.id.btn_9:
                et_show.append("9");
                break;

            case R.id.btn_dian:
                et_show.append(".");
                break;
            case R.id.btn_jia:
                flag = 1;
                text1 = et_show.getText().toString();
                et_show.setText("");
                break;
            case R.id.btn_jian:
                flag = 2;
                text1 = et_show.getText().toString();
                et_show.setText("");

                break;
            case R.id.btn_chengyi:
                flag = 3;
                text1 = et_show.getText().toString();
                et_show.setText("");

                break;
            case R.id.btn_chuyi:
                flag = 4;
                text1 = et_show.getText().toString();
                et_show.setText("");

                break;
            case R.id.btn_dengyu:
                switch (flag) {
                    case 0:
                        // et_show.setText(text1);
                        et_show.append("0");
                        Log.d("text1", text1);
                        Log.d("text2", text2);
                        break;
                    case 1:
                        text2 = et_show.getText().toString();
                        Double res = Double.parseDouble(text1)
                                + Double.parseDouble(text2);
                        // et_show.setText("flag=1");
                        CharSequence r = res.toString();
                        et_show.setText(res + "");
                        Log.d("text1", text1);
                        Log.d("text2", text2);
                        Log.d("res", res.toString());
                        break;
                    case 2:
                        text2 = et_show.getText().toString();
                        Double res2 = (Double.parseDouble(text1) - Double
                                .parseDouble(text2));
                        CharSequence r2 = res2.toString();
                        et_show.setText(res2 + "");
                        Log.d("text1", text1);
                        Log.d("text2", text2);
                        Log.d("res", res2.toString());
                        // et_show.setText("flag=2");
                        break;
                    case 3:

                        text2 = et_show.getText().toString();
                        Double res3 = Double.parseDouble(text1)
                                * Double.parseDouble(text2);
                        // et_show.setText("flag=3");
                        CharSequence r3 = res3.toString();
                        et_show.setText(res3 + "");
                        Log.d("text1", text1);
                        Log.d("text2", text2);
                        Log.d("res", res3.toString());
                        break;
                    case 4:
                        text2 = et_show.getText().toString();
                        Double res4 = Double.parseDouble(text1)
                                / Double.parseDouble(text2);
                        // et_show.setText("flag=4");
                        CharSequence r4 = res4.toString();
                        et_show.setText(res4 + "");
                        Log.d("text1", text1);
                        Log.d("text2", text2);
                        Log.d("res", res4.toString());
                        break;

                    default:
                        break;
                }
                break;
            case R.id.btn_clear:
                flag = 0;
                text1 = "0";
                text2 = "0";
                et_show.setText("");
                break;
            default:
                break;
        }
    }
}