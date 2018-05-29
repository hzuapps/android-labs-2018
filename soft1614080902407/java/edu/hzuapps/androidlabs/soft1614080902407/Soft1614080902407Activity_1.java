package edu.hzuapps.androidlabs.soft1614080902407;
import java.lang.String;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class Soft1614080902407Activity_1 extends AppCompatActivity {
    String[]  adapterData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902407_1);
        final ListView listView = (ListView)findViewById(R.id.listview);
        adapterData = new String[] { "文本1","文本2", "文本3","文本4"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>( Soft1614080902407Activity_1.this, android.R.layout.simple_list_item_1, adapterData);
        listView.setAdapter(arrayAdapter);
        final Activity  thisActivity = this;
        Button  btnHome = (Button)findViewById(R.id.btn_new);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,SecondActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
