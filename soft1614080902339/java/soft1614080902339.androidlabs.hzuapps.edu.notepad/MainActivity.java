package soft1614080902339.androidlabs.hzuapps.edu.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText titleText;
    private EditText contentText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText=(EditText)findViewById(R.id.textNormal);
        contentText=(EditText)findViewById(R.id.textNormal2);
        saveButton=(Button)findViewById(R.id.roundBtn2) ;

        contentText.setSingleLine(false);
        contentText.setHorizontallyScrolling(false);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database database=new Database();
                database.setTitle(titleText.getText().toString());
                database.setContent(contentText.getText().toString());
                database.save();
                finish();
            }
        });

    }
}
