package soft1614080902109.soft1614080902109;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hasee on 2018/5/22.
 */

public class FragmentTabLocal extends Fragment implements View.OnClickListener{

    private TextView txt_content;
    private ImageView new_file;
    public FragmentTabLocal() {
    }

    private void initbind(View view){
        txt_content = view.findViewById(R.id.hehe);
        new_file = (ImageView) view.findViewById(R.id.img_ic_newfile);
        new_file.setOnClickListener(this);
        txt_content.setOnClickListener(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fg_1,container,false);

        //txt_content =
        initbind(view);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_ic_newfile:
                txt_content.setText("nih");
                startActivity(new Intent(getActivity(),NewFileActivity.class));
                txt_content.setText("ee");

                break;
            case R.id.hehe:
                txt_content.setText("ee");

                break;
        }
    }

}
