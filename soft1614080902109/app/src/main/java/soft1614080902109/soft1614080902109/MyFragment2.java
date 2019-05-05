package soft1614080902109.soft1614080902109;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by hasee on 2018/5/22.
 */

public class MyFragment2 extends Fragment implements View.OnClickListener{

    private EditText editname;
    private EditText editdetail;
    private Button btnsave;
    private Button btnclean;
    private Button btnread;
    private Context mContext;

    private String content;
   // private TextView txt_content;
    public MyFragment2() {
    }



    public MyFragment2 newInstance(int content) {
        this.content = content+"";
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fg_2,container,false);
        /*txt_content= (TextView) view.findViewById(R.id.txt_content);

        txt_content.setText(content);
        txt_content.setOnClickListener(this);*/


        mContext = getActivity().getApplicationContext();
        editdetail = (EditText) view.findViewById(R.id.editdetail);
        editname = (EditText) view.findViewById(R.id.editname);
        btnclean = (Button) view.findViewById(R.id.btnclean);
        btnsave = (Button) view.findViewById(R.id.btnsave);
        btnread = (Button) view.findViewById(R.id.btnread);

        btnclean.setOnClickListener(this);
        btnsave.setOnClickListener(this);
        btnread.setOnClickListener(this);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /*case R.id.txt_content:
                    txt_content.setText("1111");
                break;*/
            case R.id.btnclean:
                editdetail.setText("");
                editname.setText("");
                break;
            case R.id.btnsave:
                FileHelper fHelper = new FileHelper(mContext);
                String filename = editname.getText().toString();
                String filedetail = editdetail.getText().toString();

                try {
                    fHelper.save(filename, filedetail);

                    Toast.makeText(getActivity().getApplicationContext(), "数据写入成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    System.out.println(editname.getText().toString()+"  "+editdetail.getText().toString());
                    e.printStackTrace();
                    Toast.makeText(getActivity().getApplicationContext(), "数据写入失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnread:
                String detail = "";
                FileHelper fHelper2 = new FileHelper(getActivity().getApplicationContext());
                try {
                    String fname = editname.getText().toString();
                    detail = fHelper2.read(fname);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getActivity().getApplicationContext(), detail, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
