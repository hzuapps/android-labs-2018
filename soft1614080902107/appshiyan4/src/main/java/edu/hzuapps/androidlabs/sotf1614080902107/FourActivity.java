package edu.hzuapps.androidlabs.sotf1614080902107;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.attr.data;

public class FourActivity extends AppCompatActivity {
    private String[] data={"第一次","第二次","第三次","第四次","第五次","第六次","第七次","第八次","第九次","第十次"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_four);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FourActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView=(ListView)findViewById(R.id.listview1);
        listView.setAdapter(adapter);

    }
}
