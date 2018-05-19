package edu.hzuapps.androidlabs.Com1614080901237;

        import android.content.Context;
        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.EditText;

        import com.example.myapplication.R;

        import java.io.BufferedWriter;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.OutputStreamWriter;

public class secondActivity extends AppCompatActivity {

    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edit=(EditText)findViewById(R.id.edit);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        String inputText=edit.getText().toString();
        save(inputText);
    }

    public void save(String inputText){
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("data", Context.MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
