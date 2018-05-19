package soft1614080902317.androidlabs.hzuapps.edu.tripmanager;

import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ModifyTrip extends AppCompatActivity {
    private TextView timeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_trip);
        timeView=(TextView)findViewById(R.id.button3);
        timeView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent=new Intent(ModifyTrip.this,Main2Activity.class);
                startActivity(intent);
            }});
        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = ((EditText) findViewById(R.id.timeeditText)).getText().toString();
                String text2 = ((EditText) findViewById(R.id.tripeditText)).getText().toString();
                save(text1);
                save(text2);
            }
        });
    }

    private void save(String text) {
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("demo", ContextWrapper.MODE_APPEND);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
