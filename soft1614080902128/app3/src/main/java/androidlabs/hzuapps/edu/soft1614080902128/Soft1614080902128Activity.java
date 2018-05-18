package androidlabs.hzuapps.edu.soft1614080902128;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Soft1614080902128Activity extends AppCompatActivity {

    @Override
   protected void onCreate(Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_soft1614080902128);
                Button button=(Button)findViewById(R.id.button_open);
                button.setOnClickListener(new View.OnClickListener(){
               @Override
           public void onClick(View view){
                                           Intent intent = new Intent("Activitysoft1614080902129.class");
                                          startActivity(intent);
                                 }
       });
          }
}
