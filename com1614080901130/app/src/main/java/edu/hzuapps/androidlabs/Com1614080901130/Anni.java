package edu.hzuapps.androidlabs.Com1614080901130;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
//import android.view.View.OnClickListener;

public class Anni extends Activity {

//    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anni_home);

//        textView=(TextView)findViewById(R.id.logo);
//        textView.setCompoundDrawablesWithIntrinsicBounds(null,
//                getResources().getDrawable(R.drawable.share,null),null,null);
//        textView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(Anni.this,Upload.class);
//                startActivity(intent);
//            }
//        });

        final Activity thisActivity = this;
        Button btnOpen =  findViewById(R.id.share_button);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,Show.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}