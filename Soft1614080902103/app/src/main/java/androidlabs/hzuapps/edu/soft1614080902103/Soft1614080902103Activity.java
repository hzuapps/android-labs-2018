package androidlabs.hzuapps.edu.soft1614080902103;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;



        import org.w3c.dom.Text;

        public class Soft1614080902103Activity extends AppCompatActivity {

            private TextView textView;



            @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_soft1614080902103);


                Button btnCancel2=(Button)findViewById(R.id.button1);
                        btnCancel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                                        Intent intent = new Intent();
                                        intent.setClass(Soft1614080902103Activity.this, SecondActivity.class);
                                        startActivity(intent);
                                    }
        });


                                    }
}