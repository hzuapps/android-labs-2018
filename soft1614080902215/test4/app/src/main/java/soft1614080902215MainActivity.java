package androidlabs.hzuapps.edu.soft1614080902215;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;
public class soft1614080902215MainActivity extends AppCompatActivity {

    private Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902215_main);

        Button=(Button)findViewById(R.id.button);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(soft1614080902215MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
