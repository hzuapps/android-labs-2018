package edu.hzuapps.androidlabs.soft1614080902416;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.ContextWrapper;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Spinner;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class soft1614080902416Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_soft1614080902416);
//    }
private float x,y;
    private String text="";
    private int tagremeber=0;
    private EditText textview;
    private boolean eqstatus=false;
    private boolean zestatus=false;
    private int count=0;

    private Calculate cl;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902416);
        textview=(EditText) findViewById(R.id.result);
        textview.setText(null);
        textview.requestFocus();

        Button bt_0=(Button) findViewById(R.id.c_0);
        Button bt_1=(Button) findViewById(R.id.c_1);
        Button bt_2=(Button) findViewById(R.id.c_2);
        Button bt_3=(Button) findViewById(R.id.c_3);
        Button bt_4=(Button) findViewById(R.id.c_4);
        Button bt_5=(Button) findViewById(R.id.c_5);
        Button bt_6=(Button) findViewById(R.id.c_6);
        Button bt_7=(Button) findViewById(R.id.c_7);
        Button bt_8=(Button) findViewById(R.id.c_8);
        Button bt_9=(Button) findViewById(R.id.c_9);
        Button bt_add=(Button) findViewById(R.id.c_add);
        Button bt_delete=(Button) findViewById(R.id.c_delete);
        Button bt_mul=(Button) findViewById(R.id.c_X);
        Button bt_div=(Button) findViewById(R.id.c_div);
        Button bt_c=(Button) findViewById(R.id.c_c);
        Button bt_xx=(Button) findViewById(R.id.c_xx);
        Button bt_ce=(Button) findViewById(R.id.c_ce);
        Button bt_aord=(Button) findViewById(R.id.c_aord);
        Button bt_equal=(Button) findViewById(R.id.c_equal);
        Button bt_point=(Button) findViewById(R.id.c_point);

        //其中1-10为数字  11-20位运算符
        bt_0.setTag(20);
        bt_1.setTag(1);
        bt_2.setTag(2);
        bt_3.setTag(3);
        bt_4.setTag(4);
        bt_5.setTag(5);
        bt_6.setTag(6);
        bt_7.setTag(7);
        bt_8.setTag(8);
        bt_9.setTag(9);
        bt_add.setTag(10);
        bt_delete.setTag(11);
        bt_mul.setTag(12);
        bt_div.setTag(13);

        bt_c.setTag(14);
        bt_xx.setTag(15);
        bt_ce.setTag(16);
        bt_aord.setTag(17);
        bt_equal.setTag(18);
        bt_point.setTag(19);
        //给0-9和.加上数值对应的监听
        bt_0.setOnClickListener(ol);
        bt_1.setOnClickListener(ol);
        bt_2.setOnClickListener(ol);
        bt_3.setOnClickListener(ol);
        bt_4.setOnClickListener(ol);
        bt_5.setOnClickListener(ol);
        bt_6.setOnClickListener(ol);
        bt_7.setOnClickListener(ol);
        bt_8.setOnClickListener(ol);
        bt_9.setOnClickListener(ol);
        bt_point.setOnClickListener(ol);
        //运算符类按钮加上运算法类的监听
        bt_add.setOnClickListener(cal_listener);
        bt_delete.setOnClickListener(cal_listener);
        bt_mul.setOnClickListener(cal_listener);
        bt_div.setOnClickListener(cal_listener);
        bt_equal.setOnClickListener(cal_listener);
        //清除等按钮
        bt_c.setOnClickListener(setzero_listener);
        bt_xx.setOnClickListener(setzero_listener);
        bt_ce.setOnClickListener(setzero_listener);
        bt_aord.setOnClickListener(setzero_listener);
    }
    OnClickListener ol=new OnClickListener() {
        public void onClick(View view) {
            int tag=(Integer) view.getTag();
            if(eqstatus){
                text="";
                textview.setSelection(text.length());
                eqstatus=false;
            }

            if(zestatus){
                text="";
                textview.setSelection(text.length());
                zestatus=false;
            }

            switch(tag){

                case 20:
                    text=text+"0";
                    break;
                case 1:
                    text=text+"1";
                    break;
                case 2:
                    text=text+"2";
                    break;
                case 3:
                    text=text+"3";
                    break;
                case 4:
                    text=text+"4";
                    break;
                case 5:
                    text=text+"5";
                    break;
                case 6:
                    text=text+"6";
                    break;
                case 7:
                    text=text+"7";
                    break;
                case 8:
                    text=text+"8";
                    break;
                case 9:
                    text=text+"9";
                    break;
                case 19:
                    text=text+".";
            }
            textview.setText(text);
            textview.setSelection(text.length());
        }
    };


    OnClickListener cal_listener=new OnClickListener() {

        public void onClick(View view) {
            int tag=(Integer) view.getTag();
            //当单击运算按钮不为=时
            if(tag!=18){
                //保存x并清除文本域
                x=Float.parseFloat(text);
                tagremeber=tag;
                text="";
                textview.setText(text);
                textview.setSelection(text.length());
            }
            //点击=运算符时
            else if(tag==18){


                y=Float.parseFloat(text);
                switch(tagremeber){
//                    case 10:
//                        cl=new Add();
//                        break;
//                    case 11:
//                        cl=new Delete();
//                        break;
//                    case 12:
//                        cl=new Mulitply();
//                        break;
//                    case 13:
//                        cl=new Div();
//                        break;

                }
                float result=cl.calculate(x, y);
                text=String.valueOf(result);
                textview.setText(text);
                textview.setSelection(text.length());

                //表示当前状态为结果状态，下次点击数字时会自动清除这次结果
                eqstatus=true;
            }

        }
    };


    OnClickListener setzero_listener=new OnClickListener() {
        //
        @Override
        public void onClick(View view) {
            int tag=(Integer) view.getTag();

            switch(tag){
                //全部清除
                case 14:
                    //调用保存的方法
                    savenumber(text);
//                    x=0;
//                    y=0;
//                    text="";
//                    zestatus=true;
//                    break;
                case 15:
                    text=text.substring(0,text.length()-1);
                    break;
                case 16:
                    x=0;
                    text="";
                    zestatus=true;
                    break;
                case 17:
                    count++;
                    if(count!=0&&count%2==0){
                        text=text.substring(1);
                    }
                    else if(count%2==1){
                        text="-"+text;
                    }
                    break;
            }
            textview.setText(text);
            textview.setSelection(text.length());

        }
    };


    /**
     * 配置菜单组件
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 0, 1,"退出" );
        menu.add(0,1,2,"关于");
        return true;
    }

    /**
     * 触发相应的事件
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case 0:
                finish();
            case 1:
                Toast.makeText(soft1614080902416Activity.this, "这是陈晓杰计算机", 1).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //保存的方法
    public void savenumber(String text){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{

            out=openFileOutput("number", ContextWrapper.MODE_APPEND);
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
