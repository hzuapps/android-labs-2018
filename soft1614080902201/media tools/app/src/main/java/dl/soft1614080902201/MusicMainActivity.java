package dl.soft1614080902201;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MusicMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_back);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,Soft1614080902201MainActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        final ImageButton button_play = (ImageButton) findViewById(R.id.imageButton_play );
        final ImageButton button_pause = (ImageButton) findViewById(R.id.imageButton_pause );
        button_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             button_play.setVisibility(view.GONE);
             button_pause.setVisibility(view.VISIBLE);
            }
        });
        button_pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        button_pause.setVisibility(view.GONE);
                        button_play.setVisibility(view.VISIBLE);
                    }
                }
        );


    }
}
