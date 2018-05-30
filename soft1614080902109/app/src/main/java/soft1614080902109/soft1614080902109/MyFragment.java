package soft1614080902109.soft1614080902109;

import android.app.Fragment;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hasee on 2018/5/22.
 */

public class MyFragment extends Fragment implements View.OnClickListener{

    private String content;
    private TextView txt_content;
    public MyFragment() {
    }


    public MyFragment newInstance(int content) {
        this.content = content+"";
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        txt_content= (TextView) view.findViewById(R.id.txt_content);

        txt_content.setText(content);
        txt_content.setOnClickListener(this);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_content:
                    txt_content.setText("1111");
                break;
        }
    }

}
