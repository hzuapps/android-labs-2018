package androidlabs.hzuapps.edu.com1614080901103;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Com1614080901103Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView textView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901103);

        textView=(TextView)findViewById(R.id.textview_01);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Com1614080901103Activity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
