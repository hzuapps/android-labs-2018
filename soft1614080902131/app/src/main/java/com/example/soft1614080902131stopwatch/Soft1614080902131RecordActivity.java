package com.example.soft1614080902131stopwatch;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Soft1614080902131RecordActivity extends AppCompatActivity implements View.OnClickListener{

    private List<DateRecord> findDateRecord=new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902131_record);
        init();
    }

    public void init(){

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        setTitle("");
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        findDateRecord= DataSupport.findAll(DateRecord.class);

        recyclerView=(RecyclerView) findViewById(R.id.record_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerAdaptRecord adaptRecord=new RecyclerAdaptRecord(findDateRecord,this);
        recyclerView.setAdapter(adaptRecord);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                break;
            case R.id.delete:
                DataSupport.deleteAll(DateRecord.class);
                DataSupport.deleteAll(Timer1Record.class);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }


}
