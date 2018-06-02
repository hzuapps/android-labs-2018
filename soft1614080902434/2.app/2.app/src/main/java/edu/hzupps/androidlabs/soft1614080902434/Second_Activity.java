package soft1614080902434.androidlabs.hzuapps.edu.soft1614080902434;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Second_Activity extends AppCompatActivity implements View.OnClickListener {
   EditText ed;
   Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        this.RegisterEcent();
    }
    public void RegisterEcent(){
        ed = (EditText)findViewById(R.id.edit_text);
        send = (Button)findViewById(R.id.n_12);
        send.setOnClickListener(this);
        Log.d("dd","789");
    }


    public void save(String str){
        String data=str;
        FileOutputStream out=null;
        BufferedWriter writer=null;

        try{
            out =openFileOutput("wechat", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            Log.d("dd","456");
            writer.write(data);
        }   catch(IOException e){
            e.printStackTrace();
        }   finally {
                   if (writer !=null){
                       try {
                           writer.close();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
        }
    }
    @Override
    public void  onClick(View view){
        if(view==send){
            String str =ed.getText().toString();
            this.save(str);
            Log.d("dd","123");
        }
//        for(int i=0;i<17;i++){
//            String str =t[i].getText().toString();
//            this.save(str);
//            String s=couting.getText().toString();
//            ed.setText(s);
//
//        }
//        if(t[i]==view){
//            String str =t[i].getText().toString();
//            counting.append(str);
//        }
    }
}
