package soft1614080902109.soft1614080902109;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.LevelListDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    //UI Object
    private FrameLayout ly_content;

    private RelativeLayout tab_find;
    private RelativeLayout tab_local;
    private RelativeLayout tab_user;

    //Fragment Object
    private Fragment fg1,fg2,fg3;
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManager = getFragmentManager();
        bindViews();
        tab_local.performClick();   //模拟一次点击

    }

    //UI组件初始化与事件绑定
    private void bindViews() {
        tab_find = (RelativeLayout) findViewById(R.id.tab_find);
        tab_local = (RelativeLayout) findViewById(R.id.tab_local);
        tab_user = (RelativeLayout) findViewById(R.id.tab_user);
        ly_content = (FrameLayout) findViewById(R.id.ly_content);

        tab_local.setOnClickListener(this);
        tab_find.setOnClickListener(this);
        tab_user.setOnClickListener(this);


    }

    //重置所有文本的选中状态
    private void setSelected(){

        tab_local.setSelected(false);
        tab_find.setSelected(false);
        tab_user.setSelected(false);

    }

    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.tab_find:
                setSelected();
                tab_find.setSelected(true);
                if(fg1 == null){
                    fg1 = new FragmentTabLocal();
                    fTransaction.add(R.id.ly_content,fg1);
                }else{
                    fTransaction.show(fg1);
                }
                break;
            case R.id.tab_local:
                setSelected();
                tab_local.setSelected(true);
                if(fg2 == null){
                    fg2 = new MyFragment2().newInstance(2);
                    fTransaction.add(R.id.ly_content,fg2);
                }else{
                    fTransaction.show(fg2);
                }
                break;
            case R.id.tab_user:
                setSelected();
                tab_user.setSelected(true);
                if(fg3 == null){
                    fg3 = new MyFragment().newInstance(3);
                    fTransaction.add(R.id.ly_content,fg3);
                }else{
                    fTransaction.show(fg3);
                }
                break;

        }
        fTransaction.commit();
    }
}
