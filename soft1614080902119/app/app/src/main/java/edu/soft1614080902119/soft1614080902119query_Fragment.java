package edu.soft1614080902119;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 财务查询界面
 */
public class soft1614080902119query_Fragment extends Fragment{
    private EditText textOut_1;
    private EditText textOut_2;
    private EditText textOut_3;
    private EditText textOut_4;
    private EditText textOut_5;
    private EditText textOut_6;
    private SharedPreferences sharedPreferences;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_query, container, false);
        textOut_1 =(EditText)view.findViewById(R.id.out_1);
        textOut_2 =(EditText)view.findViewById(R.id.out_2);
        textOut_3 =(EditText)view.findViewById(R.id.out_3);
        textOut_4 =(EditText)view.findViewById(R.id.out_4);
        textOut_5 =(EditText)view.findViewById(R.id.out_5);
        textOut_6 =(EditText)view.findViewById(R.id.out_6);
        sharedPreferences = getActivity().getSharedPreferences("edit_s", Activity.MODE_PRIVATE);
        String str_1=sharedPreferences.getString("edit_1", "0");
        String str_2 = sharedPreferences.getString("edit_2", "0");
        String str_3 = sharedPreferences.getString("edit_3", "0");
        String str_4 = sharedPreferences.getString("edit_4", "0");
        String str_5 = sharedPreferences.getString("edit_5", "0");
        String str_6 = sharedPreferences.getString("edit_6", "0");
        textOut_1.setText(str_1);
        textOut_2.setText(str_2);
        textOut_3.setText(str_3);
        textOut_4.setText(str_4);
        textOut_5.setText(str_5);
        textOut_6.setText(str_6);

        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button1 = (Button) getActivity().findViewById(R.id.cancel_1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String str_1=sharedPreferences.getString("1", "0");
                String str_2 = sharedPreferences.getString("1", "0");
                String str_3 = sharedPreferences.getString("1", "0");
                String str_4 = sharedPreferences.getString("1", "0");
                String str_5 = sharedPreferences.getString("1", "0");
                String str_6 = sharedPreferences.getString("1", "0");
                textOut_1.setText(str_1);
                textOut_2.setText(str_2);
                textOut_3.setText(str_3);
                textOut_4.setText(str_4);
                textOut_5.setText(str_5);
                textOut_6.setText(str_6);
                Toast.makeText(getActivity(), "清零成功", Toast.LENGTH_LONG).show();
            }
        });
    }
}
