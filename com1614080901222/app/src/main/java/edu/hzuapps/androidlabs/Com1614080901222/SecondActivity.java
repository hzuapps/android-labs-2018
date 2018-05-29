package edu.hzuapps.androidlabs.Com1614080901222;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import com.example.imagic.com1614080901222.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final View view =findViewById(R.id.relative2);
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE);
        ImageButton white1 = findViewById(R.id.imageButton1);
        ifOnTouch(white1,R.drawable.white,R.drawable.white_back);
    }

    public boolean ifOnTouch(final ImageButton imageButton,final int upDrable,final int downDrawable){
        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    imageButton.setBackgroundResource(downDrawable);
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    imageButton.setBackgroundResource(upDrable);
                }
                return true;
            }
        });
     return false;
    }

}
