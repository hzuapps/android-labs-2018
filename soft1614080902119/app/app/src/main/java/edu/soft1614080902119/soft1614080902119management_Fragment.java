package edu.soft1614080902119;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * 财务管理界面
 */
public class soft1614080902119management_Fragment extends Fragment {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText textOut_1;
    private EditText textOut_2;
    private EditText textOut_3;
    private EditText textOut_4;
    private EditText textOut_5;
    private EditText textOut_6;
    private SharedPreferences sharedPreferences;
    public static final String DIRECTORY = "demo";
    public static final String FILENAME = "file_demo.txt";
    public static final String TAG = soft1614080902119management_Fragment.class.getSimpleName();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_management, container, false);
        View view1 = inflater.inflate(R.layout.activity_query, container, false);
        Button button = (Button) getActivity().findViewById(R.id.maintain_1);
        editText1 = (EditText)view.findViewById(R.id.edit_1);
        editText2 = (EditText)view.findViewById(R.id.edit_2);
        editText3 = (EditText)view.findViewById(R.id.edit_3);
        editText4 = (EditText)view.findViewById(R.id.edit_4);
        editText5 = (EditText)view.findViewById(R.id.edit_5);
        editText6 = (EditText)view.findViewById(R.id.edit_6);

        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button = (Button) getActivity().findViewById(R.id.maintain_1);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                savewifisettings();
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void savewifisettings(){

        sharedPreferences = getActivity().getSharedPreferences("edit_s", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("edit_1",editText1.getText().toString());
        editor.putString("edit_2",editText2.getText().toString());
        editor.putString("edit_3",editText3.getText().toString());
        editor.putString("edit_4",editText4.getText().toString());
        editor.putString("edit_5",editText5.getText().toString());
        editor.putString("edit_6",editText6.getText().toString());

        editor.commit();
    }
}