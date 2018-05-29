package edu.hzuapps.androidlabs;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ShowFromJSON extends AppCompatActivity {

    private ScrollView scrollView;
    private LinearLayout linearLayout;
    int index1=0;
    int index2=1;
    int index3=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_from_json);

        //执行接收并分析JSON的操作
        FetchJSON fetch=new FetchJSON();
        AnalyseJSON analyse=new AnalyseJSON();
        analyse.parseByGSON(fetch.getJson());

        linearLayout = (LinearLayout) this.findViewById(R.id.linearLayout1);
        for (int i = 0; i < 4; i++) {
            TextView textName=new TextView(this);
            textName.setText(analyse.name[i]);
            TextView textDescription=new TextView(this);
            textDescription.setText(analyse.description[i]+"\n");
            textName.setTextSize(30);
            textDescription.setTextSize(20);
            textName.setGravity(Gravity.CENTER_HORIZONTAL);
            textDescription.setGravity(Gravity.CENTER_HORIZONTAL);
            linearLayout.addView(textName, index1);
            linearLayout.addView(textDescription, index2);
            index1=index1+2;
            index2=index2+2;
        }
    }
}
