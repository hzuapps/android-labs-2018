package soft1614080902339.androidlabs.hzuapps.edu.notepad;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Database> databaseList=new ArrayList<>();
    private Button deleteButton;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
    }

    public void init(){


        databaseList=DataSupport.findAll(Database.class);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        deleteButton=(Button)findViewById(R.id.delete_button);

        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new MyAdapter(databaseList,this);
        recyclerView.setAdapter(adapter);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("注意？");
                builder.setMessage("是否删除全部记录？");
                builder.setCancelable(false);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DataSupport.deleteAll(Database.class);
                        databaseList=DataSupport.findAll(Database.class);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter=new MyAdapter(databaseList,ListActivity.this);
                        recyclerView.setAdapter(adapter);
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });
    }
}
