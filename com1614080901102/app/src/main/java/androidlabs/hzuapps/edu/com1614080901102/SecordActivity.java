package androidlabs.hzuapps.edu.com1614080901102;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
public class SecondActivity extends AppCompatActivity {

    private LinearLayout s_eyu;
    private LinearLayout s_ruiwen;
    private LinearLayout s_yasuo;
    private LinearLayout s_huangzi;
    private LinearLayout s_timo;
    private LinearLayout s_nuoshou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901102);

        s_eyu=(LinearLayout)findViewById(R.id.ll_eyu);
        s_ruiwen=(LinearLayout)findViewById(R.id.ll_ruiwen);
        s_yasuo=(LinearLayout)findViewById(R.id.ll_yasuo);
        s_huangzi=(LinearLayout)findViewById(R.id.ll_huangzi);
        s_timo=(LinearLayout)findViewById(R.id.ll_timo);
        s_nuoshou=(LinearLayout)findViewById(R.id.ll_nuoshou);

