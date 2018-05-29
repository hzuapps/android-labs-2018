package soft1614080902339.androidlabs.hzuapps.edu.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView contentTextView;
    private TextView dateAndTimeTextView;

    private Database currDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();

    }

    public void init(){
        titleTextView=(TextView)findViewById(R.id.textview_01);
        contentTextView=(TextView)findViewById(R.id.textview_02);
        dateAndTimeTextView=(TextView)findViewById(R.id.textview_03);

        Intent intent=getIntent();


        currDatabase=DataSupport.find(Database.class,intent.getIntExtra("currId",-1));

        titleTextView.setText(currDatabase.getTitle());
        contentTextView.setText(currDatabase.getContent());
        dateAndTimeTextView.setText(currDatabase.getDateAndTime());
    }


}
