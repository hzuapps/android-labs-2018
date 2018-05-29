package edu.hzuapps.androidlabs.soft1606081301233;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class Soft1606081301233Activity extends AppCompatActivity {

    private String[]data={"旅游","旅游","旅游"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1606081301233);
        Button btnflagNew1 = (Button) findViewById(R.id.btnflagNew);

        btnflagNew1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Soft1606081301233Activity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<>(
                Soft1606081301233Activity.this,android.R.layout.simple_list_item_1,data);
        final ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
            }
        }

