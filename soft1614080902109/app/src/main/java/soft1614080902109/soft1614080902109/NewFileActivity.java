package soft1614080902109.soft1614080902109;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class NewFileActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout rootLayout;
    private LinearGridding schedule;
    private SeekBar magnifyGlass;
    private MyView canvas;
    private TextView text;
    int n=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);


        init();
        drawschedule();
    }
    public void init(){


        magnifyGlass = new SeekBar(this);
        magnifyGlass.setProgressDrawable(getResources().getDrawable(R.drawable.ss));
        magnifyGlass.setIndeterminateDrawable(getResources().getDrawable(android.R.drawable.progress_indeterminate_horizontal));

        magnifyGlass.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        canvas = new MyView(this);

        text = new TextView(this);
        text.setText("3333");
        text.setOnClickListener(this);


        rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.addView(text);
        rootLayout.addView(magnifyGlass);
        rootLayout.addView(canvas);

        LinearLayout.LayoutParams ivParams = (LinearLayout.LayoutParams) magnifyGlass.getLayoutParams();
        ivParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
        ivParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;



        setContentView(rootLayout);


        schedule = new LinearGridding();
        schedule.setMaxN(10);

    }
    public void drawschedule(){

    }

    @Override
    public void onClick(View v) {
        if(v == text){
        }
    }
}
