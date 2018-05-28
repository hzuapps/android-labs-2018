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

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    private TextView tv_eyuTouch,tv_ruiwenTouch,tv_yasuoTouch,tv_huangziTouch,tv_timoTouch,tv_nuoshouTouch;
    int eyuCount,ruiwenCount,yasuoCount,huangziCount,timoCount,nuoshouCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901102);

        s_eyu = (LinearLayout) findViewById(R.id.ll_eyu);
        s_ruiwen = (LinearLayout) findViewById(R.id.ll_ruiwen);
        s_yasuo = (LinearLayout) findViewById(R.id.ll_yasuo);
        s_huangzi = (LinearLayout) findViewById(R.id.ll_huangzi);
        s_timo = (LinearLayout) findViewById(R.id.ll_timo);
        s_nuoshou = (LinearLayout) findViewById(R.id.ll_nuoshou);
    }


    sp =getSharedPreferences("touch",MODE_PRIVATE);
    editor = sp.edit();

    eyuCount=sp.getInt("eyuCount",0);
    ruiwenCount=sp.getInt("ruiwenCount",0);
    yasuoCount=sp.getInt("yasuoCount",0);
    huangziCount=sp.getInt("huangziCount",0);
    timoCount=sp.getInt("timoCount",0);
    nuoshouCount=sp.getInt("nuoshouCount",0);

        tv_eyuTouch.setText(eyuCount+"");
        tv_ruiwenTouch.setText(ruiwenCount+"");
        tv_yasuoTouch.setText(yasuoCount+"");
        tv_huangziTouch.setText(huangziCount+"");
        tv_timoTouch.setText(timoCount+"");
        tv_nuoshouTouch.setText(nuoshouCount+"");


    private void addEY(){
        eyuCount = sp.getInt("eyuCount",0);
        eyuCount++;
        editor.putInt("eyuCount",eyuCount);
        editor.commit();
        tv_eyuTouch.setText(eyuCount+"");
    }
    private void addRW(){
        ruiwenCount = sp.getInt("ruiwenCount",0);
        ruiwenCount++;
        editor.putInt("ruiwenCount",ruiwenCount);
        editor.commit();
        tv_ruiwenTouch.setText(ruiwenCount+"");
    }
    private void addYS(){
        yasuoCount =sp.getInt("yasuoCount",0);
        yasuoCount++;
        editor.putInt("yasuoCount",yasuoCount);
        editor.commit();
        tv_yasuoTouch.setText(yasuoCount+"");
    }
    private void addHZ(){
        huangziCount =sp.getInt("huangziCount",0);
        huangziCount++;
        editor.putInt("huangziCount",huangziCount);
        editor.commit();
        tv_huangziTouch.setText(huangziCount+"");
    }
    private void addTM(){
        timoCount =sp.getInt("timoCount",0);
        timoCount++;
        editor.putInt("timoCount",timoCount);
        editor.commit();
        tv_timoTouch.setText(timoCount+"");
    }
    private void addNS(){
        nuoshouCount=sp.getInt("nuoshouCount",0);
        nuoshouCount++;
        editor.putInt("nuoshouCount",nuoshouCount);
        editor.commit();
        tv_nuoshouTouch.setText(nuoshouCount+"");
    }



    private void readEY(){
        int eyuCount = sp.getInt("eyuCount",0);
        tv_eyuTouch.setText(eyuCount+"");
    }
    private void readRW(){
        int ruiwenCount =sp.getInt("ruiwenCount",0);
        tv_ruiwenTouch.setText(ruiwenCount+"");
    }
    private void readYS(){
        int yasuoCount =sp.getInt("yasuoCount",0);
        tv_yasuoTouch.setText(yasuoCount+"");
    }
    private void readHZ(){
        int huangziCouch =sp.getInt("huangziCount",0);
        tv_huangziTouch.setText(huangziCouch+"");
    }
    private void readTM(){
        int timoCount=sp.getInt("timoCount",0);
        tv_timoTouch.setText(timoCount+"");
    }
    private void readNS(){
        int nuoshouCount=sp.getInt("nuoshouCount",0);
        tv_nuoshouTouch.setText(nuoshouCount+"");
    }

}