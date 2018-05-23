package edu.hzuapps.androidlabs.soft1614080902338;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Soft1614080902338Activity extends AppCompatActivity {
    private static final String TAG ="Soft1614080902338Activity" ;

    //input number
    private int[] idNum = {R.id.txt0, R.id.txt1, R.id.txt2, R.id.txt3,
            R.id.txt4, R.id.txt5, R.id.txt6, R.id.txt7, R.id.txt8, R.id.txt9};

    //input operator
    private int[] idCal = {R.id.txtPlus, R.id.txtMinus, R.id.txtMul, R.id.txtDiv,
            R.id.txtLeft,R.id.txtRight,R.id.txtDot};
    private Button[] buttonsCal = new Button[idCal.length];
    private Button[] buttonsNum = new Button[idNum.length];
    private Button buttonEqu;
    private Button buttonClear;
    private Button buttonDel;
    // EditText输入
    private EditText input ;
    // TextView输出
    private EditText output;
    private static String Text;


    private EditText input1;
    private EditText output1;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902338);

        // 第一步，找控件
        initView();
        // 第二步
        initListenter();


        input = (EditText) findViewById(R.id.input);
        input.setText("");
        input.setEnabled(false);
        output = (EditText) findViewById(R.id.output);
        output.setText("");
        buttonEqu = (Button) findViewById(R.id.txtIs);
        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText(new Calculate(input.getText().toString()).str);
            }
        });
        buttonClear = (Button) findViewById(R.id.txtClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });
        buttonDel = (Button) findViewById(R.id.txtDel);

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!input.getText().toString().isEmpty() ) {
                    Text = input.getText().toString();
                    Text = Text.substring(0, Text.length() - 1);
                    input.setText(Text);
                }
            }
        });

        // 点击按钮事件
        for (int idcal = 0; idcal < idCal.length; idcal++) {
            buttonsCal[idcal] = (Button) findViewById(idCal[idcal]);
            buttonsCal[idcal].setOnClickListener(new CalOnClick(buttonsCal[idcal].getText().toString()));

        }
        for (int i = 0; i < idNum.length; i++) {
            buttonsNum[i] = (Button) findViewById(idNum[i]);
            buttonsNum[i].setOnClickListener(new NumberOnClick(buttonsNum[i].getText().toString()));
        }
    }

// 按钮监听
    private void initListenter() {
        save.setOnClickListener(new View.OnClickListener(){

            public void setFilesDir(File filesDir) {
                this.filesDir = filesDir;
            }

            private File filesDir;

            public File getFilesDir() {
                return filesDir;
            }

            @Override
            public void onClick(View v) {
                Log.d(TAG, "点击了SAVE按钮");
                handlerSaveEven(v);
            }
//  处理SAVE事件
            private void handlerSaveEven(View v) {
                String inputText = input1.getText().toString();
                String outputText = output1.getText().toString();

                //  保存数据
                saveUserInfo(inputText, outputText);
            }

            private void saveUserInfo(String inputText, String outputText) {
                Log.d(TAG, "保存信息...");

                File filesDir = this.getFilesDir();
                File saveFile = new File(filesDir, "");
                Log.d(TAG, "cache dir === "+ filesDir.toString());


                Log.d(TAG, "files dir == " + filesDir.toString());
                try {
                    if(!saveFile.exists()){
                        saveFile.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(saveFile);
                    fos.write((inputText + "=" + outputText).getBytes());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        });
    }

    private void initView() {
        input1 = (EditText) this.findViewById(R.id.input);
        output1 = (EditText) this.findViewById(R.id.output);
        save = (Button) this.findViewById(R.id.bt_SAVE);
    }

    //继承OnClick接口
    class NumberOnClick implements View.OnClickListener {
        String Msg;
        public NumberOnClick(String msg) {
            Msg = msg;
        }

        @Override
        public void onClick(View v) {
            if (!output.getText().toString().equals("")) {
                input.setText("");
                output.setText("");
            }

            input.append(Msg);
        }
    }
    class CalOnClick implements  View.OnClickListener{
        String Msg;
        String[] calSymbol = {"+", "-", "*", "/", "."};
        public CalOnClick(String msg) {
            Msg = msg;
        }
        @Override
        public void onClick(View v) {
            if (!output.getText().toString().equals("")) {
                input.setText("");
                output.setText("");
            }
            // 检查是否运算符重复输入
            for (int i = 0; i < calSymbol.length; i++) {
                if (Msg.equals(calSymbol[i])) {
                    if (input.getText().toString().split("")
                            [input.getText().toString().split("").length - 1].equals(calSymbol[i])) {
                        Msg = "";
                    }

                }
            }
            input.append(Msg);
        }
    }

    //运算返回srting类
    public class Calculate {
        public  String s1;
        StringBuilder str;

        public Calculate(String m) {
            this.s1 = m;
            try {
                eval();
            } catch (Exception e) {
                str.delete(0, str.length());
                str.append("一日紫金终身湖人--NO24");
            }
        }


        public List<String> midToAfter(List<String> midList)throws EmptyStackException {
            List<String> afterList=new ArrayList<String>();
            Stack<String> stack=new Stack<String>();
            for(String str:midList){
                int flag=this.matchWitch(str);
                switch (flag) {
                    case 7:
                        afterList.add(str);
                        break;
                    case 1:
                        stack.push(str);
                        break;
                    case 2:
                        String pop=stack.pop();
                        while(!pop.equals("(")){
                            afterList.add(pop);
                            pop=stack.pop();
                        }
                        break;
                    default:
                        if(stack.isEmpty()){
                            stack.push(str);
                            break;
                        }
                        else{
                            if(stack.peek().equals("(")){
                                stack.push(str);
                                break;
                            }else{
                                int ji1=this.youxianji(str);
                                int ji2=this.youxianji(stack.peek());
                                if(ji1>ji2){
                                    stack.push(str);
                                }else{
                                    while(!stack.isEmpty()){
                                        String f=stack.peek();
                                        if(f.equals("(")){
                                            stack.push(str);
                                            break;
                                        }else{
                                            if(this.youxianji(str)<=this.youxianji(f)){
                                                afterList.add(f);
                                                stack.pop();
                                            }else{
                                                stack.push(str);
                                                break;
                                            }
                                        }
                                    }
                                    if(stack.isEmpty()){
                                        stack.push(str);
                                    }
                                }
                                break;
                            }
                        }
                }
            }
            while(!stack.isEmpty()){
                afterList.add(stack.pop());
            }
            StringBuffer sb=new StringBuffer();
            for(String s:afterList){
                sb.append(s+" ");
            }
            //System.out.println(sb.toString());
            return afterList;
        }

        public int youxianji(String str){
            int result=0;
            if(str.equals("+")||str.equals("-")){
                result=1;
            }else{
                result =2;
            }
            return result;
        }

        public int matchWitch(String s){
            if(s.equals("(")){
                return 1;
            }else if(s.equals(")")){
                return 2;
            }else if(s.equals("+")){
                return 3;
            }else if(s.equals("-")){
                return 4;
            }else if(s.equals("*")){
                return 5;
            }else if(s.equals("/")){
                return 6;
            }else{
                return 7;
            }
        }

        public Double singleEval(Double pop2,Double pop1,String str){
            Double value=0.0;
            if(str.equals("+")){
                value=pop2+pop1;
            }else if(str.equals("-")){
                value=pop2-pop1;
            }else if(str.equals("*")){
                value=pop2*pop1;
            }else {
                value=pop2/pop1;
            }
            return value;
        }
        private double result;

        public double getResult() {
            return result;
        }
        public void setResult(double result) {
            this.result = result;
        }
        private int state;

        public int getState() {
            return state;
        }
        public void setState(int state) {
            this.state = state;
        }

        public void countHouzhui(List<String> list){
            str = new StringBuilder("");
            state=0;
            result=0;
            Stack<Double> stack=new Stack<Double>();
            for(String str:list){
                int flag=this.matchWitch(str);
                switch (flag) {
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        Double pop1=stack.pop();
                        Double pop2=stack.pop();
                        Double value=this.singleEval(pop2, pop1, str);
                        stack.push(value);
                        break;
                    default:
                        Double push=Double.parseDouble(str);
                        stack.push(push);
                        break;
                }
            }
            if(stack.isEmpty()){
                state=1;
            }else{
                result=stack.peek();
                str.append(stack.pop());
            }


        }

        public void eval() {
            List<String> list=new ArrayList<String>();
            Pattern p = Pattern.compile("[+\\-/\\*()]|\\d+\\.?\\d*");
            Matcher m = p.matcher(s1);
            while(m.find()){
                list.add(m.group());
            }
            List<String> afterList=this.midToAfter(list);
            this.countHouzhui(afterList);
        }

    }

}