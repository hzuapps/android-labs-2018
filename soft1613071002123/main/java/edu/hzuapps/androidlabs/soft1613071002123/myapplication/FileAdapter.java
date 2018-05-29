package edu.hzuapps.androidlabs.soft1613071002123.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hww on 2018/5/25.
 */

public class FileAdapter extends ArrayAdapter<File> {
    private int resourceId;

    public FileAdapter(Context context, int textViewResourceId, List<File> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        File file = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else {
            view = convertView;
        }
        ImageView fileImage = view.findViewById(R.id.file_image);
        TextView fileName = view.findViewById(R.id.file_name);
        fileImage.setImageResource(file.getImageId());
        fileName.setText(file.getName());
        return view;
    }
}
