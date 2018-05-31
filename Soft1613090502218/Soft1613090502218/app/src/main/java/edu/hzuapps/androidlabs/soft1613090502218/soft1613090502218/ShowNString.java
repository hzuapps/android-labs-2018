package edu.hzuapps.androidlabs.soft1613090502218.soft1613090502218;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowNString extends Activity {
    TextView tv;
    Button returnnstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_nstring);

        tv=(TextView)findViewById(R.id.shownstringText);
        getData gd=new getData();
        analyseData ad=new analyseData();
        gd.getJSON();
        ad.parseJson(gd.getText());
        String Tmp="\t";
        for(int i=0;i<10;i++){
            int TopTen=i+1;
            Tmp=Tmp+TopTen+"\t\t\t"+ad.getPn(i)+"\t\t\t\t"+ad.getPs(i)+"\n\t";
        }
        tv.setText(Tmp);
        tv.setTextSize(40);

        returnnstring=(Button)findViewById(R.id.Returnnsting);
        returnnstring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShowNString.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
