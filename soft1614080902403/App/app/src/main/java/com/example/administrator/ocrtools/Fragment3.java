package com.example.administrator.ocrtools;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private SQLiteDatabase db;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_fragment4, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        ArrayList datas = new ArrayList<String>();
        final HashMap hashMap = new HashMap<Integer,String>();
        DBHelper helper = new DBHelper(getActivity(),"history.db");
        db = helper.getWritableDatabase();
        Cursor cs = db.rawQuery("select * from History order by _id desc",null);
        int i=0;
        while(cs.moveToNext()){
            String ShortStr = cs.getString(cs.getColumnIndex("content")).substring(0,20);
            datas.add(ShortStr);
            hashMap.put(i, cs.getString(cs.getColumnIndex("content")));
            i++;
        }

        super.onActivityCreated(savedInstanceState);

        ListView lsv = getActivity().findViewById(R.id.listview);
        lsv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas));
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(getActivity(),Content.class);
                Bundle bundle = new Bundle();
                bundle.putString("content", (String) hashMap.get(i));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
